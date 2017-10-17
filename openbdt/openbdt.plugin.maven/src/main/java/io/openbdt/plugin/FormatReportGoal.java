package io.openbdt.plugin;

import javax.swing.Spring;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.openbdt.service.ReportService;
import io.openbdt.service.impl.ReportServiceImpl;

/**
 * Maven Plugin to generate report execution tests
 * 
 * @author regis.rocha
 *
 */
@Mojo(name = "format-report-new", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class FormatReportGoal extends AbstractMojo {
	
	
	private ReportService service = new ReportServiceImpl();

	/**
	 * 
	 */
	@Override
	public void execute() throws MojoExecutionException {
		try {
			super.getLog().info("Gerando relatorio com resultado da execucao dos testes");
			this.service.generateReport();
			
		} catch (Exception e) {
			super.getLog().error("Erro ao gerar relatorio de execucoes de testes", e);
		}
	}
}
