package io.openbdt.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import io.openbdt.service.ReportService;
import io.openbdt.service.impl.ReportServiceImpl;

/**
 * Maven Plugin to generate report execution tests
 * 
 * @author regis.rocha
 *
 */
@Mojo(name = "format-report", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
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
