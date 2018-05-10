package io.openbdt.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.PropertyException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.gson.Gson;

import io.openbdt.driver.MobileCustomDriver;
import io.openbdt.properties.PropertiesSerenityUtil;

/**
 * Listener events execution test by Junit
 * 
 */
public final class CustomRunListenerJunit extends RunListener {

	private MobileCustomDriver mobileCustomDriver;
	private String dirScreenShot;

	public CustomRunListenerJunit(MobileCustomDriver mobileCustomDriver) {
		this.mobileCustomDriver = mobileCustomDriver;
		try {
			dirScreenShot = PropertiesSerenityUtil.getProperty("serenity.outputDirectory");
		} catch (PropertyException e) {}
	}
	
	private List<ScreenShot> listScreenShot = new ArrayList<ScreenShot>();

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(CustomRunListenerJunit.class.getName());

	/**
	 * On test failure
	 * 
	 * @param failure
	 *            - Failure
	 * 
	 * @throws Exception
	 */
	@Override
	public void testFailure(final Failure failure) throws Exception {
		LOG.info("test Failure: " + failure);
		super.testFailure(failure);
	}

	/**
	 * On test assumption failure
	 * 
	 * @param failure
	 *            - Failure
	 * 
	 * @throws Exception
	 */
	@Override
	public void testAssumptionFailure(final Failure failure) {
		LOG.info("test Assumption Failure: " + failure);
		super.testAssumptionFailure(failure);
	}

	/**
	 * On test finished
	 * 
	 * @param description
	 *            - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testFinished(final Description description) throws Exception {
		LOG.info("test finished: " + description);
		takeScreen(description.getMethodName());
		super.testFinished(description);
	}

	private int contador = 1;
	
	private void takeScreen(String methodName) {
		try {
			if(methodName != null) {
			
				
				File scrFile = ((TakesScreenshot) mobileCustomDriver.getAppiumDriver()).getScreenshotAs(OutputType.FILE);
				DateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss");
				new File(dirScreenShot).mkdirs();
				String destFile = contador+"_"+dateFormat.format(new Date()) + ".png";
				File file = new File(dirScreenShot.concat(File.separator).concat(destFile));
				FileUtils.copyFile(scrFile, file);
				
				listScreenShot.add(new ScreenShot(contador, methodName, destFile));
				contador++;
				
			}
			
		} catch (IOException e) {
			LOG.error("Falha no printscreen", e);
		    e.printStackTrace();
		}
	}

	/**
	 * On test ignored
	 * 
	 * @param description
	 *            - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testIgnored(final Description description) throws Exception {
		LOG.info("test ignored: " + description);
		super.testIgnored(description);
	}

	/**
	 * On test ignored
	 * 
	 * @param description
	 *            - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testRunFinished(final Result result) throws Exception {
		LOG.info("test run finished: " + result);
		this.generateFileJson();
		super.testRunFinished(result);
	}

	/**
	 * On test run started
	 * 
	 * @param description
	 *            - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testRunStarted(final Description description) throws Exception {
		// print OpenBdt
		LOG.info("test run started: " + description);
		super.testRunStarted(description);
	}
	
	

	/**
	 * On test started
	 * 
	 * @param description
	 *            - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testStarted(final Description description) throws Exception {
		LOG.info("test started: " + description);
		super.testStarted(description);
	}
	
	private void generateFileJson() {
		
		// Create a new Gson object
        Gson gson = new Gson();
        
        ScreenShot screenShot = new ScreenShot();
        screenShot.setListScreenShot(listScreenShot);

        String jsonString = gson.toJson(screenShot);

        FileWriter fileWriter;
		try {
			File file = new File(dirScreenShot.concat(File.separator).concat("screenshot"));
			file.mkdirs();
			
			fileWriter = new FileWriter(dirScreenShot.concat(File.separator).concat("screenshot").concat(File.separator).concat("screenshot.json"));

	        fileWriter.write(jsonString);
	        fileWriter.close();

		} catch (IOException e) {
			LOG.error("Falha na geração do arquivo json custom", e);
			e.printStackTrace();
		}
		
	}
	
}

class ScreenShot {
	
	private String description;
	private String pathImage;
	private int id;
	private List<ScreenShot> listScreenShot;
	
	
	public ScreenShot() {}

	public ScreenShot(int id, String description, String pathImage) {
		super();
		this.id = id;
		this.description = description;
		this.pathImage = pathImage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	public List<ScreenShot> getListScreenShot() {
		return listScreenShot;
	}
	public void setListScreenShot(List<ScreenShot> listScreenShot) {
		this.listScreenShot = listScreenShot;
	}

}
