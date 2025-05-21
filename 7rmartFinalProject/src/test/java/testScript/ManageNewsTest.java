package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	@Test(description = "Verify that whether the User can add new news in ManageNews page")
	public void verifyUserCanAddNewNewsSucessfullyInManageNewsPage() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickOnManageNews();
		managenewspage.clickOnNewNewsbutton();
		String newnews=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenewspage.enterNewNewsOnTextbox(newnews);
		managenewspage.clickOnSavebutton();
	}

}
