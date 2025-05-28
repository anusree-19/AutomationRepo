package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	HomePage homePage;
	ManageCategoryPage categoryPage;

	@Test(description = "Verify that user can add new category on category page.",priority = 1)
	public void verifyUserCanAddNewCategoryOnCategoryPage() throws IOException, AWTException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage = loginpage.clickOnSignIn();

		String newCategory = ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		// ManageCategoryPage categoryPage=new ManageCategoryPage(driver);
		categoryPage = homePage.clickOnManageCategory();
		categoryPage.clickOnNewCategory().enterCategoryOnCategoryfield(newCategory).clickonSelectGroup()
				.clickOnChooseFile().clickOnCategorySaveButton();

		boolean categryalertmsg = categoryPage.getCateogryCreationAlert();
		Assert.assertTrue(categryalertmsg, Messages.ADDCATEGORYERROR);

	}

	@Test(description = "Verify whether user can sucessfully search for a added category from ManagecategoryPage",priority = 2)
	public void verifyUserCanSearchForaAddedCategoryfromManageCateogryPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage = loginpage.clickOnSignIn();

		categoryPage = homePage.clickOnManageCategory();
		// String newCategory=ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		categoryPage.clickOnSearchCategoryIcon().enterCategoryValueIntheCategoryField().clickonsearchbutton();

		String expected = "Shoes";
		String actual = categoryPage.getCategoryTitle();
		Assert.assertEquals(actual, expected, Messages.SEARCHCATEOGRYERROR);

	}

}
