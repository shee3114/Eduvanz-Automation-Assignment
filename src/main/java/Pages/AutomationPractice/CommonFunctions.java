package Pages.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonFunctions {

	public WebDriver driver;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get the WebElement
	 * 
	 * @param locator
	 *            Locator of webElement
	 * 
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			// get the webElement of locator
			element = driver.findElement(locator);

		} catch (NoSuchElementException e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
		return element;
	}

	/**
	 * click on WebElement
	 * 
	 * @param locator
	 *            Locator of webElement
	 * 
	 */
	public void click(By locator) {
		// set the Element Name
		WebElement element = getElement(locator);
		try {
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println(("Failed to click element - '" + locator.toString() + "'"));
		}
	}

	/**
	 * Enter Data on WebElement
	 * 
	 * @param locator
	 *            Locator of webElement
	 * @param data
	 *            that need to enter
	 * 
	 */

	public void enterData(By locator, String data) {
		WebElement element = getElement(locator);
		try {
			element.sendKeys(data);
		} catch (NoSuchElementException e) {
			System.out.println(("Failed to enter data in - '" + locator.toString() + "'"));
		}
	}

	/**
	 * Move to Element by using actions class
	 * 
	 * @param locator
	 *            Locator of webElement
	 * 
	 */
	public void moveToElement(By locator) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);

		try {
			actions.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
	}

	public boolean isElmentDisplayed(By locator) {

		boolean flag = false;
		WebElement element = getElement(locator);
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
		return flag;
	}
}
