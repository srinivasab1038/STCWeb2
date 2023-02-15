package stc.b2b.c2m.msd365.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	// Create object of webdriver
	WebDriver ldriver;

	// Create constructor
	public SigninPage(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// identify webelements
	@FindBy(xpath="(//input[@id='ap_email'])[1]")
	WebElement Emailormobilephonenumbertxt;

	@FindBy(xpath="//input[@id='continue']")
	WebElement singincontinuebtn;

	@FindBy(xpath="(//input[@id='ap_password'])[1]")
	WebElement passwordtxt;

	@FindBy(id="signInSubmit")
	WebElement signInbtn;

	// identify action on webelement
	public void EnterEmailOrMobilePhoneNumbertxt(String email)
	{
		Emailormobilephonenumbertxt.sendKeys(email);
	}

	public void ClickOnSingInContinuebtn()
	{
		singincontinuebtn.click();
	}

	public void EnterPasswordtxt(String password)
	{
		passwordtxt.sendKeys(password);
	}

	public void clickOnSignInbtn()
	{
		signInbtn.click();
	}

}
