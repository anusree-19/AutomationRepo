package testScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	HomePage homePage;
	AdminUserPage adminuserpage;

	@Test(description = "Verify whether the Admin can add New User Sucessfully On the adminUsersPage")
	public void verifyWhetherTheAdminCanAddNewUserSucessfullyOnAdminUsersPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage = loginpage.clickOnSignIn();
		RandomDataUtility randomdatautility = new RandomDataUtility();
		String newadminuser = randomdatautility.createRandomUsername();
		String newadminpwd = randomdatautility.createRandomPassword();
		// AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickOnAdminUsers().clickOnNewUser().enterUsernameOnUsrnamefield(newadminuser)
				.enterpasswordOnPwdfield(newadminpwd).clickOnUserTypefield().selectUserType().clickOnSavebutton();
		boolean useralert = adminuserpage.userCreationAlert();
		Assert.assertTrue(useralert, Messages.NEWADMINUSERERROR);
	}

	@Test(description = "verify that an admin can successfully search for a newly added user on the admin users page")
	public void verifyAdminCanSucessfullySearchForaNewlyAddedUserOnAdminUsersPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage =loginpage.clickOnSignIn();
		//AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickOnAdminUsers().clickOnSearchforanUser();
		String searchusername = ExcelUtility.readStringData(0, 0, "AdminUserPage");
		adminuserpage.enterSearchUsernameonUsernamefield(searchusername);
		adminuserpage.clickOnSearchUserTypefield().selectSearchUserType().clickOnSearchbutton();
		String expected = "Active";
		String actual = adminuserpage.searchUserStatus();
		Assert.assertEquals(actual, expected, Messages.SEARCHNEWADMINUSERERROR);

	}

}
