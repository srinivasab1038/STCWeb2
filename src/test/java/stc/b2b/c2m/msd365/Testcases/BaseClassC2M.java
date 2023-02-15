package stc.b2b.c2m.msd365.Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import io.github.bonigarcia.wdm.WebDriverManager;
import stc.b2b.c2m.msd365.Utilities.ReadConfig;

public class BaseClassC2M {
ReadConfig readconfig = new ReadConfig();
	
	String url = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
	
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default :
			driver =null;
			break;
		}
		
		//Maximize window
		driver.manage().window().maximize();
		//implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger = LogManager.getLogger("BaseClassC2M");
		
		//open url
		driver.get(url);
		logger.info("Url Opened successfully");
		
	}
		
		@AfterClass
		public void tearDown()
		{
			driver.close();
			driver.quit();
		}
		
		//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
		

		/*//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			//File dest = new File(System.getProperty("user.dir") + "//Screenshots// " + testName + timestamp +".png");
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots// " + testName +".png");
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}*/

}
