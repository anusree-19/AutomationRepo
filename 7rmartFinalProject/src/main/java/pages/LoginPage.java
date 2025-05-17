package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

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

	public void enterUsernameonUsernamefield(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPwdonPasswordfield(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSignIn() {
		signInbtn.click();
	}

}
