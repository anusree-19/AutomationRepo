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
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	WaitUtility wait = new WaitUtility();
	
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
	@FindBy(xpath="//span[text()='Active']")
	WebElement searchcategoryfoundmessage;

	public ManageCategoryPage clickOnNewCategory() {
		wait.waitUntilClickable(driver, newcategorybtn);
		newcategorybtn.click();
		return this;
	}

	public ManageCategoryPage enterCategoryOnCategoryfield(String newCategory) {
		categoryfield.sendKeys(newCategory);
		return this;
	}

	public ManageCategoryPage clickonSelectGroup() {
		discount.click();
		return this;
	}

	public ManageCategoryPage clickOnChooseFile() {
		choosefile.sendKeys(Constant.ADDCATEGORYIMG);
		return this;
	}

	public ManageCategoryPage clickOnShowOnTopMenuRadiobutton() {
		ShowOnTopMenuRadiobutton.click();
		return this;
	}

	public ManageCategoryPage clickOnShowOnLeftMenuRadiobutton() {
		ShowOnLeftMenuRadiobutton.click();
		return this;
	}

	public ManageCategoryPage clickOnCategorySaveButton() {
		PageUtility page=new PageUtility();
		page.jsClick(savecategorybutton,driver);
		return this;
	}

	public ManageCategoryPage clickOnSearchCategoryIcon() {
		searchcategorybutton.click();
		return this;
	}

	public ManageCategoryPage enterCategoryValueIntheCategoryField() {
		inputcategoryvalue.sendKeys(Constant.SEARCHCATEGORYVALUE);
		return this;
	}

	public ManageCategoryPage clickonsearchbutton() {
		wait.waitUntilClickable(driver, searchcategorybtn);
		searchcategorybtn.click();
		return this;
	}

	public boolean getCateogryCreationAlert() {

		return categoryalert.isDisplayed();
	}

	public String getSearchedCategoryMessage()
	{
		return searchcategoryfoundmessage.getText();
	}


}
