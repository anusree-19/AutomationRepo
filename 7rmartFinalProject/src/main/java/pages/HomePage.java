package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()=\"Sign In\"]")
	private WebElement signInbtn;

	@FindBy(xpath = "//a[@class='nav-link']//img")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//parent::div")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginheader;

	public void enterUsernameonUsernamefield(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPwdonPasswordfield(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSignIn() {
		signInbtn.click();
	}

	public void clickOnAdminLink() {
		admin.click();
	}

	public void clickOnLogout() {
		logout.click();
	}
	
	public boolean loginpageHeaderDisplayed() {
		return loginheader.isDisplayed();
	}

}
