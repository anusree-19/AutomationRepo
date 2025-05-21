package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test(description = "Verify that user can add new category on category page.")
	public void verifyUserCanAddNewCategoryOnCategoryPage() throws IOException, AWTException
	{
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		
		ManageCategoryPage categoryPage=new ManageCategoryPage(driver);
		categoryPage.clickOnManageCategory();
		categoryPage.clickOnNewCategory();
		String  newCategory=ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		categoryPage.enterCategoryOnCategoryfield(newCategory);
		categoryPage.clickonDiscountfield();
		categoryPage.clickOnChooseFile();
		//categoryPage.clickOnShowOnTopMenuRadiobutton();
		//categoryPage.clickOnShowOnLeftMenuRadiobutton();
		categoryPage.clickOnCategorySaveButton();
		
	}
	@Test(description = "Verify whether user can sucessfully search for a added category from ManagecategoryPage")
	public void verifyUserCanSearchForaAddedCategoryfromManageCateogryPage() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameonUsernamefield(username);
		loginpage.enterPwdonPasswordfield(password);
		loginpage.clickOnSignIn();
		ManageCategoryPage categoryPage=new ManageCategoryPage(driver);
		categoryPage.clickOnManageCategory();
		categoryPage.clickOnSearchCategoryIcon();
		//String  newCategory=ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		categoryPage.enterCategoryValueIntheCategoryField();
		categoryPage.clickonsearchbutton();
		
	}
	

}
