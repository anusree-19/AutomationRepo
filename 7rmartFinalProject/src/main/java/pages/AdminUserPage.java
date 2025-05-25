package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()=\"Sign In\"]")
	private WebElement signInbtn;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminuser;
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
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement newusercreationalert;
	@FindBy(xpath = "//span[text()='Active']")
	private WebElement status;
	
	public void enterUsernameonUsernamefield(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPwdonPasswordfield(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSignIn() {
		signInbtn.click();
	}

	public void clickOnAdminUsers()
	{
		adminuser.click();
	}
	public void clickOnNewUser()
	{
		newuser.click();
	}
	public void enterUsernameOnUsrnamefield(String newadminuser)
	{
		username.sendKeys(newadminuser);
	}
	public void enterpasswordOnPwdfield(String newadminpwd)
	{
		password.sendKeys(newadminpwd);
	}
	public void clickOnUserTypefield()
	{
		usertype.click();
	}
	public void selectUserType()
	{
		Select select=new Select(usertype);
		select.selectByIndex(1);
	}
	public void clickOnSavebutton()
	{
		savebtn.click();
	}
	public void clickOnSearchforanUser()
	{
		search.click();
	}
	public void enterSearchUsernameonUsernamefield(String searchusername)
	{
		searchusernamefield.sendKeys(searchusername);
	}
	public void clickOnSearchUserTypefield()
	{
		searchusertype.click();
	}
	public void selectSearchUserType()
	{
		Select select=new Select(searchusertype);
		select.selectByIndex(1);
	}
	public void clickOnSearchbutton()
	{
		searchbtn.click();
	}
	public boolean userCreationAlert()
	{
		return newusercreationalert.isDisplayed();
	}
	public String searchUserStatus()
	{
		return status.getText();
	}
}
