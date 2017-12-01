package io.openbdt.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import javax.xml.bind.PropertyException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import io.openbdt.exception.PropertyNotFoundException;
import io.openbdt.exception.ReportException;
import io.openbdt.helper.StatusCouter;
import io.openbdt.model.Feature;
import io.openbdt.model.Resume;
import io.openbdt.properties.PropertiesProjectUtil;

/**
 * Classe que faz o bind do model para o template .tfl e gera o html.
 * 
 * @author caio.moraes
 *
 */
public class DataBind {

	private List<Feature> features;
	private ArrayList<Resume> totalFeatureStatus;

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(DataBind.class.getName());

	public DataBind(List<Feature> features, ArrayList<Resume> totalFeatureStatus) {
		this.features = features;
		this.totalFeatureStatus = totalFeatureStatus;
	}

	/**
	 * Gera o html apartir do template .ftl fazendo o bind dos dados.
	 * 
	 * @author caio.moraes
	 * @throws ReportException
	 * @throws IOException
	 * @throws PropertyNotFoundException 
	 * @throws PropertyException
	 * 
	 */
	public void generateReport() throws ReportException, IOException, PropertyNotFoundException {

		LOG.info("Data Bind para o template");

		Writer file = null;
		try {
			
			// Instantiate Configuration class
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
			cfg.setDirectoryForTemplateLoading(new File("src/test/resources/template/production/"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// Create Data Model
			Map<String, Object> map = new HashMap<>();

			Resume totalStatus = StatusCouter.getTotalStatus(this.totalFeatureStatus);

			map.put("count_pending", totalStatus.getPending());
			map.put("count_error", totalStatus.getError());
			map.put("count_success", totalStatus.getSuccess());
			map.put("count_ignored", totalStatus.getIgnored());

			List<String> divScenario = new ArrayList<>();

			for (Feature feature : features) {
				String generateDivScenario = StatusCouter.generateDivScenario(feature);
				divScenario.add(generateDivScenario);
			}

			map.put("scenario_div", divScenario);

			// Instantiate template
			Template template = cfg.getTemplate("index.ftl");

			// File output
			file = new FileWriter(new File(PropertiesProjectUtil.getProperty("report.outputDirectory")));
	
			template.process(map, file);
			
			file.flush();
			file.close();

		} catch (IOException e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		} catch (TemplateException e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		} finally {
		}
	}

}
