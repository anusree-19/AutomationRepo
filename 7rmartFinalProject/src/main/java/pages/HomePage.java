package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link']//img")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//parent::div")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginheader;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminuser;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//child::p")
	private WebElement managenews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//child::p")
	private WebElement managecategory;

	public HomePage clickOnAdminLink() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		wait.waitUntilElementVisible(driver, logout);
		logout.click();
		return new LoginPage(driver);
	}

	public boolean loginpageHeaderDisplayed() {
		return loginheader.isDisplayed();
	}

	public AdminUserPage clickOnAdminUsers() {
		wait.waitUntilClickable(driver, adminuser);
		adminuser.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);
	}

	public ManageCategoryPage clickOnManageCategory() {
		managecategory.click();
		return new ManageCategoryPage(driver);
	}

}
