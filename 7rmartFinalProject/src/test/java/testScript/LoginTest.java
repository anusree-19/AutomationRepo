package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description = "Verifying User is able to login with Valid credentials")
	public void verifyUserCanSucessfullyLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		String expected="Dashboard";
		String actual=loginpage.getDashboardText();
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);
	}

	@Test(description="Verifying user is able to login with valid username and invalid password")
	public void verifyUserCanSucessfullyLoginWithValidUsernameInvalidpwd() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		boolean isalertdisplayed=loginpage.alertVisibility();
		Assert.assertTrue(isalertdisplayed,Messages.VALIDUSERNAMEINVALIDPASSWORDERROR);
	}

	@Test(description="Verifying user is able to login with Invalid username and Valid password")
	public void verifyUserCanSucessfullyLoginWithInvalidUsernameValidpwd() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		boolean isalertdisplayed=loginpage.alertVisibility();
		Assert.assertTrue(isalertdisplayed,Messages.INVALIDUSERNAMEVALIDPASSWORDERROR);
	}

	@Test(description = "Verifying User is able to login with Invalid credentials")
	public void verifyUserCanSucessfullyLoginWithInvalidUsernameInvalidpwd() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		boolean isalertdisplayed=loginpage.alertVisibility();
		Assert.assertTrue(isalertdisplayed,Messages.INVALIDCREDENTIALERROR);
	}

}
