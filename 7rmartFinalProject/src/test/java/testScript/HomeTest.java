package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homePage;

	@Test(description = "Verifying whether the user is able to Logout from homepage")
	public void verifyWhetherTheUserIsAbleToLogoutFromHomePage() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage = loginpage.clickOnSignIn();
		homePage.clickOnAdminLink();
		loginpage = homePage.clickOnLogout();
		boolean loginpageheader = homePage.loginpageHeaderDisplayed();
		Assert.assertTrue(loginpageheader, Messages.LOGOUTERROR);

	}

}
