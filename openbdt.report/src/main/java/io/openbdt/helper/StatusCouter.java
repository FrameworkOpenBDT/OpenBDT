package io.openbdt.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import io.openbdt.exception.ReportException;
import io.openbdt.model.Feature;
import io.openbdt.model.FeatureTag;
import io.openbdt.model.Resume;
import io.openbdt.model.Rows;
import io.openbdt.model.Tags;

/**
 * Classe que faz os cálculos do resultado.
 * @author caio.moraes
 *
 */
public class StatusCouter {

	/**
	 * 
	 */
	private static Map<String, Integer> counter = new HashMap<String, Integer>();

	private static void initializeCounterMap() {
		counter.put("PENDING", 0);
		counter.put("ERROR", 0);
		counter.put("SUCCESS", 0);
		counter.put("IGNORED", 0);
		counter.put("FAILURE", 0);
	}

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(StatusCouter.class.getName());

	/**
	 * 
	 * @author caio.moraes
	 * @param feature
	 * @return
	 * @throws ReportException
	 */
	public static Resume sumResult(final Feature feature) throws ReportException {

		initializeCounterMap();

		LOG.info("Calculate result outline");

		try {

			if (feature.getDataTable() != null) {
				return calcResultOutline(feature);

			} else {
				return calcResult(feature);
			}
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}

	}

	/**
	 * 
	 * @author caio.moraes
	 * @param resumeList
	 * @return
	 * @throws ReportException
	 */
	public static Resume getTotalStatus(final ArrayList<Resume> resumeList) throws ReportException {
		
		LOG.info("Get result total status");

		Resume processTotalStatus = null;

		try {

			processTotalStatus = processTotalStatus(resumeList);

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}

		return processTotalStatus;
	}

	/**
	 * 
	 * @author caio.moraes
	 * @param feature
	 * @return
	 * @throws ReportException
	 */
	private static Resume calcResult(final Feature feature) throws ReportException {
		
		LOG.info("Calculate result");

		try {

			if (isIgnored(feature)) {
				counter.put("IGNORED", 1);
			} else {
				counter.put(feature.getResult(), 1);
			}

			return new Resume(counter.get("PENDING"), counter.get("ERROR") + counter.get("FAILURE"), counter.get("SUCCESS"),
					counter.get("IGNORED"));

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}

	}

	/**
	 * 
	 * @author caio.moraes
	 * @param feature
	 * @return Resume
	 * @throws ReportException
	 */
	private static Resume calcResultOutline(final Feature feature) throws ReportException {
		
		LOG.info("Calculate result outline");

		try {
			List<Rows> rows = feature.getDataTable().getRows();

			for (Rows row : rows) {
				String result = row.getResult();

				if (isIgnored(feature)) {
					counter.put("IGNORED", counter.get("IGNORED") + 1);
				} else {
					counter.put(result, counter.get(result) + 1);
				}
			}

			return new Resume(counter.get("PENDING"), counter.get("ERROR") + counter.get("FAILURE"), counter.get("SUCCESS"),
					counter.get("IGNORED"));

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}
	}

	/**
	 * @author caio.moraes
	 * @param resumeList
	 * @return Resume
	 * @throws ReportException
	 */
	private static Resume processTotalStatus(final ArrayList<Resume> resumeList) throws ReportException {
		
		LOG.info("Calculate result total status");

		Integer pending = 0;
		Integer error = 0;
		Integer success = 0;
		Integer ignored = 0;

		Resume result = null;

		try {

			for (Resume resume : resumeList) {
				pending += resume.getPending();
				error += resume.getError();
				success += resume.getSuccess();
				ignored += resume.getIgnored();
			}

			result = new Resume(pending, error, success, ignored);

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}

		return result;
	}

	/**
	 * Valid test ignored
	 * 
	 * @author caio.moraes
	 * @param feature
	 * @return boolean
	 * @throws ReportException
	 */
	private static boolean isIgnored(final Feature feature) throws ReportException {
		
		LOG.info("Is ignored method");
		try {
			FeatureTag tag = feature.getFeatureTag();
				if (tag.getName().equals("ignored")) {
					return true;
				}
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}

		return false;
	}

	/**
	 * @author caio.moraes
	 * @param feature
	 * @return String
	 * @throws ReportException
	 */
	public static String generateDivScenario(final Feature feature) throws ReportException {
		
		LOG.info("Generate div scenarios");
		String div = "";
		try {

			Resume resume = feature.getFeatureStatus();

			/*div = 	"<div class=\"row\">\r\n" + 
					"<div class=\"row top_tiles\">\r\n" + 
					"<div class=\"animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12\">\r\n" + 
					"<div class=\"tile-stats\">\r\n" + 
					"<div class=\"div_generate col-lg-3 col-md-3 col-sm-6 col-xs-12\">\r\n" + 
					"<h3>Cenário:</h3>\r\n" + 
					"<p>"+feature.getTitle()+"</p>\r\n" + 
					"<div class=\"count_tes\"><p class=\"orange_rsi\">"+resume.getPending()+"</p></div>\r\n" + 
					"<div class=\"count_tes\"><p class=\"red\">"+resume.getError()+"</p></div>\r\n" + 
					"<div class=\"count_tes\"><p class=\"green\">"+resume.getSuccess()+"</p></div>\r\n" + 
					"<div class=\"count_tes\"><p class=\"blue_rsi\">"+resume.getIgnored()+"</p></div>\r\n" + 
					"</div><div class=\"cout_row\">\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"</div>";*/
			
			div = "<div class=\"animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12\">\r\n"
					+ "    <div class=\"tile-stats\">\r\n"
					+ "    <div class=\"div_generate col-lg-3 col-md-3 col-sm-6 col-xs-12 \"> <div class=\"count_tes\"><p class=\"orange_bdt\" data-toggle=\"tooltip\" title=\"Pendente\">"
					+ resume.getPending() + "</p></div>\r\n" + "        <div class=\"count_tes\"><p class=\"red\">"
					+ resume.getError() + "</p></div>\r\n" + "        <div class=\"count_tes\"><p class=\"green\">"
					+ resume.getSuccess() + "</p></div>\r\n" + "        <div class=\"count_tes\"><p class=\"blue_bdt\">"
					+ resume.getIgnored() + "</p></div>\r\n" + "        </div><div class=\"cout_row\">\r\n"
					+ "        <h3>Cenário:</h3>\r\n" + "        <p>" + feature.getTitle() + "</p>\r\n"
					+ "  </div>  </div>\r\n" + "</div>";

		} catch (ReportException e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}
		return div;
	}

}
