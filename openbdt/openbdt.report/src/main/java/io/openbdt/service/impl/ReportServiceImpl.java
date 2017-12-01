package io.openbdt.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import javax.xml.bind.PropertyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openbdt.exception.PropertyNotFoundException;
import io.openbdt.exception.ReportException;
import io.openbdt.filter.FileFilterJson;
import io.openbdt.model.Feature;
import io.openbdt.model.Resume;
import io.openbdt.properties.PropertiesSerenityUtil;
import io.openbdt.service.ReportService;
import io.openbdt.util.DataBind;
import io.openbdt.validation.ValidationHelper;

@Service
public final class ReportServiceImpl implements ReportService {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(ReportServiceImpl.class.getName());

	private ValidationHelper validate = new ValidationHelper();

	/**
	 * Generate report
	 * 
	 * @param pathJsonReport - String
	 * 
	 * @return Example
	 * 
	 * @throws ReportException
	 * @throws FileNotFoundException
	 */
	@Override
	public Feature parseJson(final String pathJsonReport) throws ReportException, FileNotFoundException {
		LOG.info("Parse json for POJO : " + pathJsonReport);

		this.validate.isStringEmpty(pathJsonReport, "path to json report is null");

		final File json = new File(pathJsonReport);

		if (!json.exists()) {
			throw new FileNotFoundException("Json report: " + pathJsonReport + " not found");
		}

		try (final Reader reader = new InputStreamReader(new FileInputStream(pathJsonReport), StandardCharsets.UTF_8)) {

			final ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			// this prevents printing eg. 2.20 as 2.2
			mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

			return mapper.readValue(reader, Feature.class);

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}
	}

	/**
	 * Generate report to json for html.
	 * 
	 * @author caio.moraes
	 */
	@Override
	public void generateReport() throws ReportException, PropertyNotFoundException {

		LOG.info("Generating report");

		File dirJson = null;

		try {

			dirJson = new File(PropertiesSerenityUtil.getProperty("serenity.outputDirectory"));
			final File[] listFiles = dirJson.listFiles(new FileFilterJson());

			List<Feature> examplesReport = new ArrayList<>();

			if (listFiles != null) {
				for (File file : listFiles) {
					examplesReport.add(parseJson(file.getAbsolutePath()));
				}
			}

			ArrayList<Resume> totalFeatureStatus = new ArrayList<>();

			for (Feature feature : examplesReport) {
				totalFeatureStatus.add(feature.getFeatureStatus());
			}

			DataBind dataBind = new DataBind(examplesReport, totalFeatureStatus);
			dataBind.generateReport();

		} catch (ReportException e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		} catch (PropertyException e) {
			LOG.fatal(e.getMessage(), e);
			throw new PropertyNotFoundException(e);
		} catch (FileNotFoundException e) {
			LOG.fatal(e.getMessage(), e);
			throw new PropertyNotFoundException(e);
		} catch (IOException e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}
	}

}
