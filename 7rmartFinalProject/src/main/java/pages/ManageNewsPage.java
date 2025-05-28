package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newnewsbtn;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newstexbox;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savenewsbtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newsalert;

	public ManageNewsPage clickOnNewNewsbutton() {
		newnewsbtn.click();
		return this;
	}

	public ManageNewsPage enterNewNewsOnTextbox(String newnews) {
		newstexbox.sendKeys(newnews);
		return this;
	}

	public ManageNewsPage clickOnSavebutton() {
		wait.waitUntilClickable(driver, savenewsbtn);
		savenewsbtn.click();
		return this;
	}

	public boolean newNewsCreationAlert() {
		return newsalert.isDisplayed();
	}

}
