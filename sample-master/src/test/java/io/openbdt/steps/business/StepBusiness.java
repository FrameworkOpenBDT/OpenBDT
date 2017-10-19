package io.openbdt.steps.business;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import io.openbdt.pages.PageObjectClass;
import net.serenity_bdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@ContextConfiguration("/appcontext.xml")
public class StepBusiness {

	PageObjectClass page;

	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS PRÓPRIOS DO FRAMEWORK

	@Step
	public void openHome(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
	}

	public void clicarSignIn() {
		viewElement.clickAndWait(page.getBotaoSignIn(), 15);
	}

	public void validarTelaDeCadastro() {
		viewElement.waitForElementIsPresent(20, page.getTituloCreateAnAccount());
		System.out.println(">> " + page.getTituloCreateAnAccount().getText());
		Assert.assertEquals("CREATE AN ACCOUNT", page.getTituloCreateAnAccount().getText());
	}

	public void preencherEmailAddress(String emailAddress) {
		viewElement.sendText(page.getCampoEmailCreate(), emailAddress);
	}

	public void clicarBotaoCreateAnAccount() {
		viewElement.clickAndWait(page.getBotaoCreateAnAccount(),20);

	}

	public void validarTelaPersonalInformation() {
		viewElement.waitForElementIsPresent(20, page.getTituloYourPersonalInformation());
		System.out.println(">> " + page.getTituloYourPersonalInformation().getText());
		Assert.assertEquals("YOUR PERSONAL INFORMATION", page.getTituloYourPersonalInformation().getText());
	}

	public void preencherRadioButtonTitle(String radioButtonTitle) {
		try {
			if (radioButtonTitle.equalsIgnoreCase("mr.")) {
				viewElement.click(viewElement.findElement(page.getXpathMr()));
			}
			if (radioButtonTitle.equalsIgnoreCase("mrs.")) {
				viewElement.click(viewElement.findElement(page.getXpathMrs()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void preencherFirstName(String firstName) {
		viewElement.sendText(page.getCampoFirstName(), firstName);
		viewElement.sendText(page.getCampoFirstName(), Keys.TAB.toString());
	}

	public void preencherLastName(String lastName) {
		viewElement.sendText(page.getCampoLastName(), lastName);
		viewElement.sendText(page.getCampoLastName(), Keys.TAB.toString());
	}

	public void preencherEmailTelaDeCadastro(String emailTelaCadastro) {
		viewElement.sendText(page.getCampoEmail(), emailTelaCadastro);
		viewElement.sendText(page.getCampoEmail(), Keys.TAB.toString());
	}

	public void preencherPassword(String password) {
		viewElement.sendText(page.getCampoPassword(), password);
		viewElement.sendText(page.getCampoPassword(), Keys.TAB.toString());
	}

	public void selecionarDiaDateOfBirth(String dayDateOfBirth) {
		new Select(viewElement.findElement(By.name("days"))).selectByVisibleText("6  ");
		// viewElement.selectByVisibleText(page.getSelectDayOfBirth(), "6 ");
	}

	public void selecionarMesDateOfBirth(String monthDateOfBirth) {
		new Select(viewElement.findElement(By.name("months"))).selectByVisibleText("November ");
//		viewElement.selectByVisibleText(page.getSelectMonthOfBirth(), "November ");
	}

	public void selecionarAnoDateOfBirth(String yearDateOfBirth) {
		new Select(viewElement.findElement(By.name("years"))).selectByVisibleText("1996  ");
//		viewElement.selectByVisibleText(page.getSelectYearOfBirth(), "1996 ");
	}

	public void preencherCheckBoxNewsletter(String newsletter) {
		if (newsletter.equalsIgnoreCase("sim")) {
			viewElement.findElement(By.xpath("//div[@id='uniform-newsletter']/span/input[@id='newsletter']")).click();
			;
		}
		// viewElement.click(page.getCheckBoxNewsletter());
	}

	public void preencherCheckBoxOffersPartners(String partners) {
		if (partners.equalsIgnoreCase("sim")) {
			viewElement.findElement(By.xpath("//div[@id='uniform-optin']/span/input[@id='optin']")).click();
			;
		}
		// viewElement.click(page.getCheckBoxPartners());
	}

	public void preencherAddress(String address) {
		viewElement.sendText(page.getCampoAddress(), address);
	}

	public void preencherCity(String city) {
		viewElement.sendText(page.getCampoCity(), city);
	}

	public void selecionarState(String state) {
		new Select(viewElement.findElement(By.name("id_state"))).selectByVisibleText(state);
//		viewElement.selectByVisibleText(page.getSelectState(), state);
	}

	public void preencherZipCode(String zipCode) {
		viewElement.sendText(page.getCampoZipCode(), zipCode);
	}

	public void selecionarCountry(String country) {
		new Select(viewElement.findElement(By.name("id_country"))).selectByVisibleText(country);
//		viewElement.selectByVisibleText(page.getSelectCountry(), country);
	}

	public void preencherAdditionalInformation(String information) {
		viewElement.sendText(page.getCampoAdditionalInformation(), information);
	}

	public void preencherMobilePhone(String mobilePhone) {
		viewElement.sendText(page.getCampoMobilePhone(), mobilePhone);
	}

	public void preencherAssignAddressAlias(String addressAlias) {
		viewElement.clear(page.getCampoAssingAlias());
		viewElement.sendText(page.getCampoAssingAlias(), addressAlias);
	}

	public void clicarBotaoRegister() {
		viewElement.clickAndWait(page.getBotaoRegister(), 15);
	}

	public void validarTelaMyAccount() {
		viewElement.waitForElementIsPresent(20, page.getTituloMyAccount());
		System.out.println(">> " + page.getTituloMyAccount().getText());
		Assert.assertEquals("MY ACCOUNT", page.getTituloMyAccount().getText());
		
	}

	public void validarTelaMyAccount(String arg1) {
		viewElement.waitForElementIsPresent(20, page.getTituloMyAccount());
		System.out.println(">> " + page.getTituloMyAccount().getText());
		Assert.assertEquals(arg1, page.getTituloMyAccount().getText());
	}

}
