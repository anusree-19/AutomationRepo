package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()=\"Sign In\"]")
	private WebElement signInbtn;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//child::p")
	private WebElement managenews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newnewsbtn;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newstexbox;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savenewsbtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newsalert;
	
	public void enterUsernameonUsernamefield(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPwdonPasswordfield(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSignIn() {
		signInbtn.click();
	}
	public void clickOnManageNews()
	{
		managenews.click();
	}
	public void clickOnNewNewsbutton()
	{
		newnewsbtn.click();
	}
	public void enterNewNewsOnTextbox(String newnews)
	{
		newstexbox.sendKeys(newnews);
	}
	public void clickOnSavebutton()
	{
		savenewsbtn.click();
	}
	public boolean newNewsCreationAlert() {
		return newsalert.isDisplayed();
	}
	
	
}
