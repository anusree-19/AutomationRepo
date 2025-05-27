package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	WaitUtility wait=new WaitUtility();
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()=\"Sign In\"]")
	private WebElement signInbtn;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement visiblealert;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;

	public LoginPage enterUsernameonUsernamefield(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPwdonPasswordfield(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickOnSignIn() {
		wait.waitUntilClickable(driver,signInbtn);
		signInbtn.click();
		return new HomePage(driver);
	}
	
	public boolean alertVisibility() {
		wait.waitUntilAlertIsPresent(driver);
		return visiblealert.isDisplayed();
	}
	
	public String getDashboardText() {

		return dashboard.getText();
	}
	


}
