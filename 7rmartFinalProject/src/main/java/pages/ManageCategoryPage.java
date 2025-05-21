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

public class ManageCategoryPage {
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
	//@FindBy(xpath = "//input[@name='top_menu' and @value='no']//parent::label")
	private WebElement ShowOnTopMenuRadiobutton;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	//@FindBy(xpath = "//input[@name='show_home' and @value='no']//parent::label")
	private WebElement ShowOnLeftMenuRadiobutton;
	//@FindBy(xpath = "//button[@type='submit']//parent::div")
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savecategorybutton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']//child::i")
	private WebElement searchcategorybutton;
	
	//@FindBy(xpath = "//input[@type='text' and @class='form-control']")
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement inputcategoryvalue;
	
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchcategorybtn;
	
	public void clickOnManageCategory()
	{
		managecategory.click();
	}
	public void clickOnNewCategory()
	{
		newcategorybtn.click();
	}
	public void enterCategoryOnCategoryfield(String newCategory)
	{
		categoryfield.sendKeys(newCategory);
	}
	public void clickonDiscountfield()
	{
		discount.click();
	}
	
	public void clickOnChooseFile() 
	{
		choosefile.sendKeys(Constant.ADDCATEGORYIMG);
	}
	public void clickOnShowOnTopMenuRadiobutton()
	{
		ShowOnTopMenuRadiobutton.click();
	}
	public void clickOnShowOnLeftMenuRadiobutton()
	{
		ShowOnLeftMenuRadiobutton.click();
	}
	public void clickOnCategorySaveButton()
	{
		JavascriptExecutor javascript= (JavascriptExecutor) driver; 
		javascript.executeScript("window.scrollBy(0,650)",  "");
		javascript.executeScript("arguments[0].click();",savecategorybutton);
		
		//savecategorybutton.click();
	}
	public void clickOnSearchCategoryIcon()
	{
		searchcategorybutton.click();
	}
	public void enterCategoryValueIntheCategoryField()
	{
		//JavascriptExecutor javascript= (JavascriptExecutor) driver; 
		//javascript.executeScript("arguments[0].value= 'Shoes';",inputcategoryvalue);
		inputcategoryvalue.sendKeys(Constant.CATEGORY1);
	}
	public void clickonsearchbutton()
	{
		searchcategorybtn.click();
	}

}
