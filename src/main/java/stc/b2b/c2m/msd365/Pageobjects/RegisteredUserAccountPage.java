package stc.b2b.c2m.msd365.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccountPage {
	// Create object of webdriver
	WebDriver ldriver;

	//Create Constructor
	public RegisteredUserAccountPage(WebDriver rdriver)
	{
		ldriver= rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//Identify webelements
	@FindBy(css="#nav-link-accountList-nav-line-1")
	WebElement registeredusername;

	//Identify action on webelement
	public String verifyRegisteredUserName()
	{
		String username = registeredusername.getText();
		return username;

	}

}
