package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class PageUtility {
	WebDriver driver;

	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDropdownWithIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void checkCheckbox(WebElement checkbox) {
		checkbox.click();
	}

	public boolean isCheckboxSelected(WebElement checkbox) {
		return checkbox.isSelected();
	}

	public void selectRadioButton(WebElement radioButton) {
		radioButton.click();
	}

	public boolean isRadioButtonSelected(WebElement radioButton) {
		return radioButton.isSelected();
	}

	public void jsClick(WebElement element, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", " ");
	}

	public void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-350)", " ");
	}
}
