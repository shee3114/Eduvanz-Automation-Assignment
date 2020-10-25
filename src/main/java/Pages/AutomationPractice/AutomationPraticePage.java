package Pages.AutomationPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPraticePage {

	public WebDriver driver;
	public WebDriverWait wait;

	public AutomationPraticePage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method to navigate to 'automation Practice' page and click on 'Sign
	 * In' button
	 */
	public void navivateToAutoamationPracticePageAndClickonSignIn() {
		driver.get("http://automationpractice.com/index.php");
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationPractice_OR.signInButton));

		// Click on 'Sign In' button
		commonFunctions.click(AutomationPractice_OR.signInButton);

	}

	/*
	 * The method for login
	 */
	public void login(String userName, String password) {
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationPractice_OR.userNameField));

		// Enter the data in 'UserName', 'Password' and click on sign in button
		commonFunctions.enterData(AutomationPractice_OR.userNameField, userName);
		commonFunctions.enterData(AutomationPractice_OR.passwordField, password);
		commonFunctions.click(AutomationPractice_OR.loginButton);
	}

	/*
	 * This method to select product and verify product details and add to cart
	 */
	public void verifyProductDetailsAndPurchase() {

		AutomationPraticePage automationPraticePage = new AutomationPraticePage(driver);
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationPractice_OR.womenTab));

		// Select Category
		commonFunctions.click(AutomationPractice_OR.womenTab);

		commonFunctions.click(AutomationPractice_OR.dressSubCategory);

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(AutomationPractice_OR.productImage));

		commonFunctions.moveToElement(AutomationPractice_OR.productImage);

		List<WebElement> products = driver.findElements(By.xpath("//a[@class='quick-view']"));

		for (int i = 1; i <= products.size(); i++) {

			String product = (AutomationPractice_OR.productImg).toString().replaceAll("By.xpath: ", "");//

			By productImg = By.xpath(product + "[" + i + "]");

			commonFunctions.moveToElement(productImg);

			WebElement element = commonFunctions.getElement(productImg);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationPractice_OR.productDetailSection));

			// Verify if the 'Product Details' page is getting opened or not
			boolean flag = commonFunctions.isElmentDisplayed(AutomationPractice_OR.productDetailSection);
			if (flag) {
				System.out.println("Product " + i + " Details:");

				// Get the description
				String description = commonFunctions.getElement(AutomationPractice_OR.productDescription).getText();
				System.out.println("Description: " + description);
				String price = commonFunctions.getElement(AutomationPractice_OR.productPrice).getText();
				System.out.println("Price: " + price);
				String newPrice = price.replace("$", "");

				double cost = Double.parseDouble(newPrice);

				String size = commonFunctions.getElement(AutomationPractice_OR.productSize).getText();
				System.out.println("Size: " + size);

				ArrayList<String> colorList = automationPraticePage.getColorList();
				System.out.print("Color: ");
				for (String str : colorList) {
					System.out.print(str + " ");
				}
				System.out.println();
				Double productCost = 50.0;

				if (description.contains("100% cotton") && (colorList.contains("Orange") || colorList.equals("Blue"))
						&& (size.equals("S") || size.equals("M")) && (cost < productCost)) {

					// Click on Add To cart button
					commonFunctions.click(AutomationPractice_OR.addToCardButton);

					// Switch to default content
					driver.switchTo().defaultContent();

					// Click on 'Continue Shopping'
					commonFunctions.click(AutomationPractice_OR.continueShoppingBtn);

					driver.navigate().back();

				} else {
					driver.navigate().back();
					System.out.println("Fail!! Prdocut details are not matched with expected criteria.");
				}

			} else {
				System.out.println("Fail! because product details page is not getting opened.");
			}
		}
		// Purchase product

	}

	/*
	 * Checkout product and also verify address
	 */
	public void checkoutProductAndVerifyAddress(String address) {
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		// Click on 'Cart'
		commonFunctions.click(AutomationPractice_OR.cartButton);

		// Wait till display of 'Summary checkout button'
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationPractice_OR.summaryCheckOutBtn));

		// Click on Proceed to checkout button In Summary
		commonFunctions.click(AutomationPractice_OR.summaryCheckOutBtn);

		// Verify address
		String addressFrontEnd = commonFunctions.getElement(AutomationPractice_OR.addressField).getText();

		if (addressFrontEnd.equals(address)) {
			System.out.println("Successfully checked that address is matched with registeration address");
		} else {
			System.out.println("Failed to match with regersteration address");
		}

		commonFunctions.click(AutomationPractice_OR.addressCheckOutBtn);

		commonFunctions.click(AutomationPractice_OR.acceptTermsandCondition);

		commonFunctions.click(AutomationPractice_OR.shippingCheckOutBtn);

		commonFunctions.click(AutomationPractice_OR.paymentMethod);

		commonFunctions.click(AutomationPractice_OR.confirmOrder);

		System.out.println(commonFunctions.getElement(AutomationPractice_OR.orderConfMsg).getText());
	}

	// This method will return the arraylist of the product's color
	public ArrayList<String> getColorList() {
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		List<WebElement> totalColors = driver.findElements(AutomationPractice_OR.productColor);
		ArrayList<String> colorList = new ArrayList<String>();
		for (int j = 0; j <= totalColors.size() - 1; j++) {
			j = j + 1;

			String colorLocator = (AutomationPractice_OR.productColor).toString().replaceAll("By.xpath: ", "");

			By colorByLocator = By.xpath(colorLocator + "[" + j + "]");

			String color = commonFunctions.getElement(colorByLocator).getAttribute("title");

			colorList.add(color);
			j = j - 1;
		}
		return colorList;
	}
}
