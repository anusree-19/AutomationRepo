package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	@Test(description = "Verify whether the Admin can add New User Sucessfully On the adminUsersPage")
	public void verifyWhetherTheAdminCanAddNewUserSucessfullyOnAdminUsersPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		RandomDataUtility randomdatautility=new RandomDataUtility();
		String newadminuser=randomdatautility.createRandomUsername();
		String newadminpwd=randomdatautility.createRandomPassword();
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickOnAdminUsers();
		adminuserpage.clickOnNewUser();
		adminuserpage.enterUsernameOnUsrnamefield(newadminuser);
		adminuserpage.enterpasswordOnPwdfield( newadminpwd);
		adminuserpage.clickOnUserTypefield();
		adminuserpage.selectUserType();
		adminuserpage.clickOnSavebutton();
	}

	@Test(description = "verify that an admin can successfully search for a newly added user on the admin users page")
	public void verifyAdminCanSucessfullySearchForaNewlyAddedUserOnAdminUsersPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickOnAdminUsers();
		adminuserpage.clickOnSearchforanUser();
		String searchusername=ExcelUtility.readStringData(0, 0, "AdminUserPage");
		adminuserpage.enterSearchUsernameonUsernamefield(searchusername);
		adminuserpage.clickOnSearchUserTypefield();
		adminuserpage.selectSearchUserType();
		adminuserpage.clickOnSearchbutton();
		
	}

}
