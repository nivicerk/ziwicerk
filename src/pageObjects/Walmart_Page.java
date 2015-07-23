package pageObjects;

import utility.Element_Not_Found_Exception;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Walmart_Page {

	static WebElement element = null;
	public static WebDriverWait myWait;
	
	public static WebElement textfield_Search(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt20")));
		try
		{
			element = driver.findElement(By.id("txt20"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Search text field on Walmart page", e);
		}
		
		return element;
	}
	
	public static WebElement button_Go(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		try
		{
			element = driver.findElement(By.xpath("//button[@type='submit']"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Go button on Walmart page", e);
		}
		
		return element;
	}
	
	public static WebElement image_FirstTV(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 60);
		
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[3]")));
		try
		{
			element = driver.findElement(By.xpath("//div[2]/div[3]"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate any TV in Walmart search results", e);
		}
		
		return element;
	}
	
	
	public static WebElement button_AddToCart(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[6]")));
		try
		{
			element = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Add to Cart button", e);
		}
		
		return element;
	}
	
	public static WebElement button_Checkout(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/button")));
		try
		{
			element = driver.findElement(By.xpath("//div[2]/button"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Add to Cart button", e);
		}
		
		return element;
	}
	
	public static WebElement textfield_Username(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		try
		{
			element = driver.findElement(By.name("email"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Username text field", e);
		}
		
		return element;
	}
	
	public static WebElement textfield_Password(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		try
		{
			element = driver.findElement(By.name("password"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Password text field", e);
		}
		
		return element;
	}
	
	public static WebElement button_SignIn(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/form/button")));
		try
		{
			element = driver.findElement(By.xpath("//div[2]/div/form/button"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Sign In button", e);
		}
		
		return element;
	}
	
	public static WebElement button_Continue(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/form/div[2]/div/button")));
		try
		{
			element = driver.findElement(By.xpath("//div[2]/div/form/div[2]/div/button"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Continue button", e);
		}
		
		return element;
	}
	
	public static WebElement body_PaymentPage(WebDriver driver){
		element = driver.findElement(By.cssSelector("body"));
		return element;
	}
	
	public static WebElement link_Cart(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
		try
		{
			element = driver.findElement(By.linkText("Cart"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Cart link", e);
		}
		
		return element;
	}
	
	public static WebElement button_RemoveFromCart(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/button[2]")));
		try
		{
			element = driver.findElement(By.xpath("//div[2]/button[2]"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Remove From Cart button", e);
		}
		
		return element;
	}
	
	public static WebElement body_CartPage(WebDriver driver){
		element = driver.findElement(By.cssSelector("body"));
		return element;
	}
	
	public static WebElement button_SignOut(WebDriver driver) throws Exception{
		myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer/div/button")));
		try
		{
			element = driver.findElement(By.xpath("//footer/div/button"));
		}
		catch (NoSuchElementException e) 
		{
			throw new Element_Not_Found_Exception("Unable to locate Sign Out button", e);
		}
		
		return element;
	}
	
}
