package stc.b2b.c2m.msd365.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import stc.b2b.c2m.msd365.Pageobjects.HomePage;
import stc.b2b.c2m.msd365.Pageobjects.RegisteredUserAccountPage;
import stc.b2b.c2m.msd365.Pageobjects.SigninPage;

public class TC_RegisteredUserLoginTest extends BaseClassC2M {
	
	@Test
	public void verifyRegistrationAndLogin() throws IOException, InterruptedException
	{
		
		
		HomePage homepage = new HomePage(driver);
		homepage.HoverOnAccountandlists();
		logger.info("Account and List hover");
		homepage.ClickOnSigninbtn();
		logger.info("Sign in button is clicked");
		
		SigninPage signinpage = new SigninPage(driver);
		signinpage.EnterEmailOrMobilePhoneNumbertxt("Srinitest404@gmail.com");
		logger.info("Email or mobile phone number entered");
		signinpage.ClickOnSingInContinuebtn();
		logger.info("Clicked on Continue button");
		signinpage.EnterPasswordtxt("Srini@404");
		logger.info("Enetered password");
		signinpage.clickOnSignInbtn();
		logger.info("Clicked on Sign in button");
		
		RegisteredUserAccountPage reguser =new RegisteredUserAccountPage(driver);
		String registereduser = reguser.verifyRegisteredUserName();
		
		if(registereduser.equals("Hello, srinitest"))
				{
		logger.info("Logged in with registered user");
		Assert.assertTrue(true);
				}
		else
		{
			logger.info("Log in failure");
			captureScreenShot(driver,"verifyRegistrationAndLogin");
			Assert.assertTrue(false);
			
		}
	
		
		homepage.HoverOnAccountandlists();
		logger.info("Account and List hover");
		homepage.clickOnSignOutlnk();
		logger.info("Sign out button is clicked");
	}	
	
}

