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

public class ManageCategoryTest extends Base{
	HomePage homePage;
	ManageCategoryPage categoryPage;
	@Test(description = "Verify that user can add new category on category page.")
	public void verifyUserCanAddNewCategoryOnCategoryPage() throws IOException, AWTException
	{
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage=loginpage.clickOnSignIn();
		
		//ManageCategoryPage categoryPage=new ManageCategoryPage(driver);
		categoryPage.clickOnManageCategory().clickOnNewCategory();
		String  newCategory=ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		categoryPage.enterCategoryOnCategoryfield(newCategory);
		categoryPage.clickonDiscountfield();
		categoryPage.clickOnChooseFile();
		//categoryPage.clickOnShowOnTopMenuRadiobutton();
		//categoryPage.clickOnShowOnLeftMenuRadiobutton();
		categoryPage.clickOnCategorySaveButton();
		boolean categryalertmsg=categoryPage.getCateogryCreationAlert();
		Assert.assertTrue(categryalertmsg,Messages.ADDCATEGORYERROR);
		
	}
	@Test(description = "Verify whether user can sucessfully search for a added category from ManagecategoryPage")
	public void verifyUserCanSearchForaAddedCategoryfromManageCateogryPage() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username).enterPwdonPasswordfield(password);
		homePage=loginpage.clickOnSignIn();
		//ManageCategoryPage categoryPage=new ManageCategoryPage(driver);
		categoryPage.clickOnManageCategory().clickOnSearchCategoryIcon();
		//String  newCategory=ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		categoryPage.enterCategoryValueIntheCategoryField();
		categoryPage.clickonsearchbutton();
		String expected="Shoes";
		String actual=categoryPage.getCategoryTitle();
		Assert.assertEquals(actual, expected,Messages.SEARCHCATEOGRYERROR);
		
	}
	

}
