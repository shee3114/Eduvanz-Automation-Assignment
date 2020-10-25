package Scenarios.Suite.appSuite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.AutomationPractice.AutomationPraticePage;
import Scenarios.Suite.baseSuite.BaseSuite;

public class AutomationPraticeSuite extends BaseSuite {

	// Navigate to Automation Practice page
	@Test(priority = 0)
	public void navivateToAutoamationPracticePageAndClickonSignIn() {
		AutomationPraticePage pageComponentObj = new AutomationPraticePage(driver);
		pageComponentObj.navivateToAutoamationPracticePageAndClickonSignIn();
	}

	// Method for Login
	@Test(priority = 1)
	@Parameters({ "userName", "password" })
	public void login(String userName, String password) {
		AutomationPraticePage pageComponentObj = new AutomationPraticePage(driver);
		pageComponentObj.login(userName, password);
	}

	// Method to go to product details and product details matched then add to
	// cart
	@Test(priority = 3)
	public void verifyProductDetailsAndAddToCart() {
		AutomationPraticePage pageComponentObj = new AutomationPraticePage(driver);
		pageComponentObj.verifyProductDetailsAndPurchase();
	}

	// Method to checkout product
	@Test(priority = 4)
	@Parameters("address")
	public void checkoutProductAndVerifyAddress(String address) {
		AutomationPraticePage pageComponentObj = new AutomationPraticePage(driver);
		pageComponentObj.checkoutProductAndVerifyAddress(address);
	}
}
