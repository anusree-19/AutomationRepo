package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WaitUtility wait=new WaitUtility();
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()=\"Sign In\"]")
	private WebElement signInbtn;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//child::p")
	private WebElement managecategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newcategorybtn;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefile;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	private WebElement ShowOnTopMenuRadiobutton;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	private WebElement ShowOnLeftMenuRadiobutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savecategorybutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']//child::i")
	private WebElement searchcategorybutton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement inputcategoryvalue;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchcategorybtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement categoryalert;
	@FindBy(xpath = "//tbody//tr//td[text()='Shoes']")
	private WebElement listtitle;
	
	public ManageCategoryPage clickOnManageCategory()
	{
		managecategory.click();
		return new ManageCategoryPage(driver);
	}
	public ManageCategoryPage clickOnNewCategory()
	{
		wait.waitUntilClickable(driver,newcategorybtn);
		newcategorybtn.click();
		return this;
	}
	public ManageCategoryPage enterCategoryOnCategoryfield(String newCategory)
	{
		categoryfield.sendKeys(newCategory);
		return this;
	}
	public ManageCategoryPage clickonDiscountfield()
	{
		discount.click();
		return this;
	}
	
	public ManageCategoryPage clickOnChooseFile() 
	{
		choosefile.sendKeys(Constant.ADDCATEGORYIMG);
		return this;
	}
	public ManageCategoryPage clickOnShowOnTopMenuRadiobutton()
	{
		ShowOnTopMenuRadiobutton.click();
		return this;
	}
	public ManageCategoryPage clickOnShowOnLeftMenuRadiobutton()
	{
		ShowOnLeftMenuRadiobutton.click();
		return this;
	}
	public ManageCategoryPage clickOnCategorySaveButton()
	{
		JavascriptExecutor javascript= (JavascriptExecutor) driver; 
		javascript.executeScript("window.scrollBy(0,650)",  "");
		javascript.executeScript("arguments[0].click();",savecategorybutton);
		//savecategorybutton.click();
		return this;
	}
	public ManageCategoryPage clickOnSearchCategoryIcon()
	{
		searchcategorybutton.click();
		return this;
	}
	public ManageCategoryPage enterCategoryValueIntheCategoryField()
	{
		inputcategoryvalue.sendKeys(Constant.CATEGORY1);
		return this;
	}
	public ManageCategoryPage clickonsearchbutton()
	{
		wait.waitUntilClickable(driver, searchcategorybtn);
		searchcategorybtn.click();
		return this;
	}
	public boolean getCateogryCreationAlert()
	{
		
		return categoryalert.isDisplayed();
	}
	public String getCategoryTitle()
	{
		return listtitle.getText();
	}

}
