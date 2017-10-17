package io.openbdt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClass extends PageObject{

	@FindBy(xpath = "//div[@class='header_user_info']/a[contains(text(),'Sign in')]")
	private WebElement botaoSignIn;
	
	@FindBy(xpath = "//form[@id='create-account_form']/h3")
	private WebElement tituloCreateAnAccount;
	
	@FindBy(name = "email_create")
	private WebElement campoEmailCreate;
	
	@FindBy(name = "SubmitCreate")
	private WebElement botaoCreateAnAccount;
	
	@FindBy(xpath = "//div[@id='noSlide']/form/div[1][@class='account_creation']/h3[@class='page-subheading']")
	private WebElement tituloYourPersonalInformation;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement radioButtonMr;
	
	private By xpathMr = By.xpath("//div[1]/label/div[1]/span[1]/input[@name='id_gender']");
	
	
	public By getXpathMr() {
		return xpathMr;
	}

	@FindBy(xpath = "//div[1]/label/div[1]/span[1]/input[@name='id_gender']")
	private WebElement radioButtonMrs;
	
	private By xpathMrs = By.xpath("//div[2]/label/div[1]/span[1]/input[@name='id_gender']");
	
	public By getXpathMrs() {
		return xpathMrs;
	}

	@FindBy(name = "customer_firstname")
	private WebElement campoFirstName;
	
	@FindBy(name = "customer_lastname")
	private WebElement campoLastName;
	
	@FindBy(name = "email")
	private WebElement campoEmail;
	
	@FindBy(name = "passwd")
	private WebElement campoPassword;
	
	@FindBy(name = "days")
	private WebElement selectDayOfBirth;
	
	@FindBy(name = "months")
	private WebElement selectMonthOfBirth;
	
	@FindBy(name = "years")
	private WebElement selectYearOfBirth;
	
	@FindBy(name = "newsletter")
	private WebElement checkBoxNewsletter;
	
	@FindBy(name = "optin")
	private WebElement checkBoxPartners;
	
	@FindBy(name = "address1")
	private WebElement campoAddress;
	
	@FindBy(name = "city")
	private WebElement campoCity;
	
	@FindBy(name = "id_state")
	private WebElement selectState;
	
	@FindBy(name = "postcode")
	private WebElement campoZipCode;
	
	@FindBy(name = "id_country")
	private WebElement selectCountry;
	
	@FindBy(name = "other")
	private WebElement campoAdditionalInformation;
	
	@FindBy(name = "phone_mobile")
	private WebElement campoMobilePhone;
	
	@FindBy(name = "alias")
	private WebElement campoAssingAlias;
	
	@FindBy(name = "submitAccount")
	private WebElement botaoRegister;
	
	@FindBy(xpath = "//div[@id='center_column']/h1")
	private WebElement tituloMyAccount;
	

	public WebElement getTituloMyAccount() {
		return tituloMyAccount;
	}

	public WebElement getBotaoSignIn() {
		return botaoSignIn;
	}

	public WebElement getTituloCreateAnAccount() {
		return tituloCreateAnAccount;
	}

	public WebElement getCampoEmailCreate() {
		return campoEmailCreate;
	}

	public WebElement getBotaoCreateAnAccount() {
		return botaoCreateAnAccount;
	}

	public WebElement getTituloYourPersonalInformation() {
		return tituloYourPersonalInformation;
	}

	public WebElement getRadioButtonMr() {
		return radioButtonMr;
	}

	public WebElement getRadioButtonMrs() {
		return radioButtonMrs;
	}

	public WebElement getCampoFirstName() {
		return campoFirstName;
	}

	public WebElement getCampoLastName() {
		return campoLastName;
	}

	public WebElement getCampoEmail() {
		return campoEmail;
	}

	public WebElement getCampoPassword() {
		return campoPassword;
	}

	public WebElement getSelectDayOfBirth() {
		return selectDayOfBirth;
	}

	public WebElement getSelectMonthOfBirth() {
		return selectMonthOfBirth;
	}

	public WebElement getSelectYearOfBirth() {
		return selectYearOfBirth;
	}

	public WebElement getCheckBoxNewsletter() {
		return checkBoxNewsletter;
	}

	public WebElement getCheckBoxPartners() {
		return checkBoxPartners;
	}

	public WebElement getCampoAddress() {
		return campoAddress;
	}

	public WebElement getCampoCity() {
		return campoCity;
	}

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getCampoZipCode() {
		return campoZipCode;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public WebElement getCampoAdditionalInformation() {
		return campoAdditionalInformation;
	}

	public WebElement getCampoMobilePhone() {
		return campoMobilePhone;
	}

	public WebElement getCampoAssingAlias() {
		return campoAssingAlias;
	}

	public WebElement getBotaoRegister() {
		return botaoRegister;
	}
	
	
	
}
