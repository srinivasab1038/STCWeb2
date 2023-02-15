package stc.b2b.c2m.msd365.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Create object of webdriver
	WebDriver ldriver;

	// Create constructor
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// identify webelements
	@FindBy(xpath="//span[normalize-space()='Account & Lists']")
	WebElement accountandlists;

	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	WebElement signinbtn;

	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement hellousernamtxt;

	@FindBy(xpath="//span[normalize-space()='Sign Out']")
	WebElement signoutlnk;

	// identify action on webelement
	public void HoverOnAccountandlists()
	{
		Actions action = new Actions(ldriver);
		action.moveToElement(accountandlists).perform();
	}

	public void ClickOnSigninbtn()
	{
		signinbtn.click();
	}

	public void clickOnSignOutlnk()
	{
		signoutlnk.click();
	}

}
