package utility;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Common_Actions {
	public static WebDriver driver = null;
	Excel_Utils excel;
	public String URL, Node;
	static String workingDir = System.getProperty("user.dir");
	public static final String chromedriver_location = workingDir+"\\drivers\\chromedriver.exe";
	public static final String iedriver_location = workingDir+"\\drivers\\IEDriverServer.exe";

	public static WebDriver openBrowser(String browser_name) throws Exception {
		try {
			switch (browser_name.toLowerCase()){
			
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", chromedriver_location);
				driver = new ChromeDriver();
				break;
			default:
				System.setProperty("webdriver.ie.driver", iedriver_location);
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;

		} catch (Exception e) {
			throw (e);
		}

	}
	

	public static void launchApplication(WebDriver driver,String url) {
		try {
			
			driver.navigate().to(url);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public static void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
