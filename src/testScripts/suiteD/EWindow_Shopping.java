package testScripts.suiteD;

import org.openqa.selenium.WebDriver;

import projectModule.Walmart_Actions;
import runManager.Testcase;
import utility.Excel_Utils;
import utility.TestData_Loader;
import utility.Common_Actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class EWindow_Shopping extends Testcase {
	
	//Instance variable driver created to use this across all methods
	public WebDriver driver;
	public Excel_Utils data;
	
	@BeforeMethod
	public void preScript() throws Exception {
		
		data = TestData_Loader.loadTestData(this);
		String url = data.getCellData(this, "URL");
		String browser = data.getCellData(this, "Browser");

		driver = Common_Actions.openBrowser(browser);
		driver.get(url);
	}
	
	@Test
	public void main() throws Exception {
		String search_item = data.getCellData(this, "Search_Item");
		Walmart_Actions.searchItem(driver, search_item);
		Walmart_Actions.addItemToCart(driver);
		Walmart_Actions.proceedToCheckout(driver);
		String username = data.getCellData(this, "Username");
		String password = data.getCellData(this, "Password");
		Walmart_Actions.login(driver, username, password);
		Walmart_Actions.verifyPaymentDetails(driver);
		Walmart_Actions.removeItemFromCart(driver);
		Walmart_Actions.logout(driver);
	}
	
	@AfterMethod
	public void postScript() throws Exception {
		//Add any post conditions here
		
	}
	
}
