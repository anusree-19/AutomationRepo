package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homePage;
	@Test(description = "Verifying User is able to login with Valid credentials",priority = 1,groups = {"smoke"}, retryAnalyzer =retry.Retry.class)
	public void verifyUserCanSucessfullyLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage=loginpage.clickOnSignIn();
		String expected="Dashboard";
		String actual=loginpage.getDashboardText();
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);
	}

	@Test(description="Verifying user is able to login with valid username and invalid password",priority = 3)
	public void verifyUserCanSucessfullyLoginWithValidUsernameInvalidpwd() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password).clickOnSignIn();
		boolean isalertdisplayed=loginpage.alertVisibility();
		Assert.assertTrue(isalertdisplayed,Messages.VALIDUSERNAMEINVALIDPASSWORDERROR);
	}

	@Test(description="Verifying user is able to login with Invalid username and Valid password" , priority = 4,groups = {"smoke"})
	public void verifyUserCanSucessfullyLoginWithInvalidUsernameValidpwd() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password).clickOnSignIn();
		boolean isalertdisplayed=loginpage.alertVisibility();
		Assert.assertTrue(isalertdisplayed,Messages.INVALIDUSERNAMEVALIDPASSWORDERROR);
	}

	@Test(description = "Verifying User is able to login with Invalid credentials", priority = 2, dataProvider ="loginProvider" )
	public void verifyUserCanSucessfullyLoginWithInvalidUsernameInvalidpwd(String username,String password) throws IOException {
		//String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password).clickOnSignIn();
		boolean isalertdisplayed=loginpage.alertVisibility();
		Assert.assertTrue(isalertdisplayed,Messages.INVALIDCREDENTIALERROR);
	}
	
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin","admin"},
			new Object[] {"admin123","123"}
		//	new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
