package br.com.rsi.framework.bdd;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.openbdt.exception.ReportException;
import io.openbdt.exception.ValidationException;
import io.openbdt.model.Feature;
import io.openbdt.service.ReportService;
import io.openbdt.service.impl.ReportServiceImpl;
import io.openbdt.validation.ValidationHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ReportServiceImpl.class, ValidationHelper.class})
public class TestServiceGenerator {

	@Autowired
	private ReportService reportService;
	
	@Test(expected = ValidationException.class)
	public void testGenerateWithNoJson() throws ReportException, FileNotFoundException {
		this.reportService.parseJson(null);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testGenerateWithPathJsonNotFound() throws ReportException, FileNotFoundException {
		this.reportService.parseJson("C:/notfoundJson.json");
	}
	
	@Test
	public void testGenerate() throws ReportException, FileNotFoundException {
		
		final String pathJsonTest = this.getClass().getResource("/json-test/d297c13dc309d9aebd64508c4d102c36a0f5151b88a430e63e23279d252b77d1.json").getPath();
		
		final Feature jsonConverted = this.reportService.parseJson(pathJsonTest);
		
		System.out.println("Result>>>>>>>>>>>>>>>>>>>");
		System.out.println(jsonConverted);
		
		Assert.assertNotNull(jsonConverted);
	}
	
	@Test(expected = ReportException.class)
	public void testGenerateErrorParser() throws ReportException, FileNotFoundException {
		
		final String pathJsonTest = this.getClass().getResource("/json-test/incorret.json").getPath();
		
		final Feature jsonConverted = this.reportService.parseJson(pathJsonTest);
		
		System.out.println("Result>>>>>>>>>>>>>>>>>>>");
		System.out.println(jsonConverted);
		
		Assert.assertNotNull(jsonConverted);
	}
	
}
