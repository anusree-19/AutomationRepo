package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUserPage {
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newuser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebtn;

	@FindBy(xpath = "//a[text()=' Search']")
	private WebElement search;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchusernamefield;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchusertype;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchbtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newusercreationalert;
	@FindBy(xpath = "//span[text()='Active']")
	private WebElement status;

	public AdminUserPage clickOnNewUser() {
		newuser.click();
		return this;
	}

	public AdminUserPage enterUsernameOnUsrnamefield(String newadminuser) {
		username.sendKeys(newadminuser);
		return this;
	}

	public AdminUserPage enterpasswordOnPwdfield(String newadminpwd) {
		password.sendKeys(newadminpwd);
		return this;
	}

	public AdminUserPage clickOnUserTypefield() {
		usertype.click();
		return this;
	}

	public AdminUserPage selectUserType() {
		Select select = new Select(usertype);
		select.selectByIndex(1);
		return this;
	}

	public AdminUserPage clickOnSavebutton() {
		savebtn.click();
		return this;
	}

	public AdminUserPage clickOnSearchforanUser() {
		search.click();
		return this;
	}

	public AdminUserPage enterSearchUsernameonUsernamefield(String searchusername) {
		searchusernamefield.sendKeys(searchusername);
		return this;
	}

	public AdminUserPage clickOnSearchUserTypefield() {
		searchusertype.click();
		return this;
	}

	public AdminUserPage selectSearchUserType() {
		Select select = new Select(searchusertype);
		select.selectByIndex(1);
		return this;
	}

	public AdminUserPage clickOnSearchbutton() {
		searchbtn.click();
		return this;
	}

	public boolean userCreationAlert() {
		return newusercreationalert.isDisplayed();
	}

	public String searchUserStatus() {
		return status.getText();
	}
}
