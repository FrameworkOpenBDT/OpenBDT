package br.com.rsi.framework.bdd;

import io.openbdt.service.impl.ReportServiceImpl;

public class TestMain {

	public static void main(String[] args) {

		ReportServiceImpl imp = new ReportServiceImpl();
		
		try {
			imp.generateReport();

		} catch (Exception e) {
			
		}

	}

}
