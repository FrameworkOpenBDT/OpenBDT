package io.openbdt.service;

import java.io.FileNotFoundException;

import io.openbdt.exception.PropertyNotFoundException;
import io.openbdt.exception.ReportException;
import io.openbdt.model.Feature;

/**
 * Interface to generate report. 
 *
 */
public interface ReportService {
	
	/**
	 * Generate report
	 * 
	 * @param pathJsonReport - String
	 * 
	 * @throws ReportException
	 * @throws FileNotFoundException
	 * 
	 * @return Example
	 */
	Feature parseJson(String pathJsonReport) throws ReportException, FileNotFoundException;
	
	void generateReport() throws ReportException, FileNotFoundException, PropertyNotFoundException;
	
}
