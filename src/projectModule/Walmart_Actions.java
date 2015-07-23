package projectModule;

import org.testng.Assert;
import pageObjects.Walmart_Page;
import org.openqa.selenium.WebDriver;

public class Walmart_Actions {
	
	public static void searchItem(WebDriver driver, String search_str) throws Exception {			
		Walmart_Page.textfield_Search(driver).sendKeys(search_str);
		Walmart_Page.button_Go(driver).click();
	}
	
	public static void addItemToCart(WebDriver driver) throws Exception {
		Walmart_Page.image_FirstTV(driver).click();
		
		Walmart_Page.button_AddToCart(driver).click();
		String body_text = Walmart_Page.body_CartPage(driver).getText();
		
		Assert.assertTrue(body_text.contains("Items in cart (1)"));		
	}
	
	public static void login(WebDriver driver, String username, String password) throws Exception {		
		Walmart_Page.textfield_Username(driver).sendKeys(username);
		Walmart_Page.textfield_Password(driver).sendKeys(password);
		Walmart_Page.button_SignIn(driver).click();
	}
	
	public static void proceedToCheckout(WebDriver driver) throws Exception {		
		Walmart_Page.button_Checkout(driver).click();
	}
	
	public static void verifyPaymentDetails(WebDriver driver) throws Exception {		
		Walmart_Page.button_Continue(driver).click();
		String body_text = Walmart_Page.body_PaymentPage(driver).getText();
		Assert.assertTrue(body_text.contains("Enter Credit Card"));	
	}
	
	public static void removeItemFromCart(WebDriver driver) throws Exception {		
		Walmart_Page.link_Cart(driver).click();
		Walmart_Page.button_RemoveFromCart(driver).click();
		String body_text = Walmart_Page.body_CartPage(driver).getText();
		Assert.assertTrue(body_text.contains("Your cart is empty"));
	}
	
	public static void logout(WebDriver driver) throws Exception {		
		Walmart_Page.button_SignOut(driver).click();
	}
	
}
