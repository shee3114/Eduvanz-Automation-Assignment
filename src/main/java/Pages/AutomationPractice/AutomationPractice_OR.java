package Pages.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPractice_OR {

	private static WebDriver driver;

	static By signInButton = By.xpath("//a[contains(text(),'Sign in')]");

	static By userNameField = By.xpath("//input[@id='email']");

	static By passwordField = By.xpath("//input[@id='passwd']");

	static By loginButton = By.xpath("//button[@id='SubmitLogin']");

	static By womenTab = By.xpath("//a[contains(text(),'Women')]");

	static By dressSubCategory = By.xpath("//div/a[@title='Dresses']");

	static By productImage = By.xpath("//*[@id='center_column']//a[@class='product_img_link']//img");

	static By quickView = By.xpath("(//a[@class='quick-view'])");

	static By productImg = By.xpath("(//a[@class='product_img_link']/img)");

	static By productDetailSection = By.xpath("//div[@id='center_column']/div[@itemscope]");

	static By productDescription = By.xpath("//div[@itemprop='description']/p");

	static By productPrice = By.id("our_price_display");

	static By productSize = By.xpath("//fieldSet//span");

	static By productColor = By.xpath("(//fieldSet//a)");

	static By addToCardButton = By.xpath("//p[@id='add_to_cart']/button");

	static By addToCartBtn = By.xpath("//p//button[@type='submit']");

	static By getTotalAmt = By.xpath("(//span[contains(@class,'ajax_block_cart_total')])[2]");

	static By proceedToCheckOutBtn = By.xpath("//a[@title='Proceed to checkout']");

	static By summaryCheckOutBtn = By.xpath("//p/a[@title='Proceed to checkout']");

	static By addressField = By.xpath("(//ul[@id='address_invoice']/li)[3]");

	static By addressCheckOutBtn = By.xpath("//*[@id='center_column']/form/p/button/span");

	static By acceptTermsandCondition = By.xpath("//*[@id='cgv']");

	static By shippingCheckOutBtn = By.xpath("//*[@id='form']/p/button/span");

	static By getPaymentTotalAmt = By.xpath("//*[@id='total_price']");

	static By paymentMethod = By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a/span");

	static By confirmOrder = By.xpath("//*[@id='cart_navigation']/button/span");

	static By orderConfMsg = By.xpath("//*[@id='center_column']/div/p/strong");

	static By iframe = By.className("fancybox-iframe");

	static By continueShoppingBtn = By.xpath("//span[@title='Continue shopping']/span");

	static By productDetailsCloseBtn = By.xpath("//a[@title='Close']");

	static By cartButton = By.xpath("//a[@title='View my shopping cart']");
}
