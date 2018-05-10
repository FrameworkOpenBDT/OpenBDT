package io.openbdt.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.PropertyException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.openbdt.exception.PropertyNotFoundException;
import io.openbdt.exception.ReportException;
import io.openbdt.filter.FileFilterJson;
import io.openbdt.model.Feature;
import io.openbdt.model.Feature;
import io.openbdt.model.Resume;
import io.openbdt.model.Screenshots;
import io.openbdt.model.CustomScreenshot;
import io.openbdt.model.TestSteps;
import io.openbdt.properties.PropertiesSerenityUtil;
import io.openbdt.service.ReportService;
import io.openbdt.util.DataBind;
import io.openbdt.util.GenericExtFilter;
import io.openbdt.validation.ValidationHelper;

@Service
public final class ReportServiceImpl implements ReportService {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(ReportServiceImpl.class.getName());
	public static final String EXTENSION_JSON = ".json";

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
			
			this.mergeJsonSerenityWithJsonCustom();

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
	
	
	private void mergeJsonSerenityWithJsonCustom() throws ReportException {

		try {
			Gson gson = new Gson();
			File dir = new File(PropertiesSerenityUtil.getProperty("serenity.outputDirectory"));
			
			File jsonCustom = new File(PropertiesSerenityUtil.getProperty("serenity.outputDirectory")
					.concat(File.separator)
					.concat("screenshot")
					.concat(File.separator)
					.concat("screenshot.json"));
			if(!jsonCustom.exists())
				return;
			BufferedReader br = new BufferedReader(new InputStreamReader(
				    new FileInputStream(jsonCustom), "UTF-8"));

			CustomScreenshot screenshotCustom = gson.fromJson(br, CustomScreenshot.class);
			br.close();
			
			

			GenericExtFilter filter = new GenericExtFilter(EXTENSION_JSON);
			String[] list = dir.list(filter);
	
			for (String file : list) {
				String fileJson = new StringBuffer(PropertiesSerenityUtil.getProperty("serenity.outputDirectory")).append(File.separator).append(file).toString();
				
				br = new BufferedReader(new InputStreamReader(
					    new FileInputStream(fileJson), "UTF-8"));
	
				Feature principal = gson.fromJson(br, Feature.class);
				br.close();
				
				List<TestSteps> testSteps = principal.getTestSteps();
				
				List<TestSteps> listTestSteps = new ArrayList<TestSteps>();
				
				for(TestSteps test : testSteps) {
					
					List<Screenshots> listScreenshot = new ArrayList<Screenshots>();

					for(CustomScreenshot custom : screenshotCustom.getListScreenShot()) {
						
						if(Integer.valueOf(custom.getId()) == test.getNumber()) {
							
							Screenshots screen = new Screenshots();
							screen.setScreenshot(custom.getPathImage());
							listScreenshot.add(screen);
							
						}
						
						test.setScreenshots(listScreenshot);
						
					}
					
					listTestSteps.add(test);
					
				}
				
				principal.setTestSteps(listTestSteps);
				
				
		        String jsonString = gson.toJson(principal);

		        FileWriter fileWriter;
				fileWriter = new FileWriter(PropertiesSerenityUtil.getProperty("serenity.outputDirectory").concat(File.separator).concat(file));

		        fileWriter.write(jsonString);
		        fileWriter.close();


				
			}
			
		} catch(Exception e) {
			
			throw new ReportException("Falha no merge do json serenity x json custom", e);
			
		}
	}

}
