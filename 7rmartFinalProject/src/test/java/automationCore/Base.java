package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;

	@BeforeMethod
	//@Parameters("browser")
	public void initializeBrowser()	{	/*if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			throw new Exception("Invalid Browser");
		}*/
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();
	}

}
