package CongaTest.ReusableMethods;

import java.time.Duration;

import org.jfree.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.path.json.JsonPath;

public class ActionMethods {
	
	public static WebDriver driver;

	public static WebDriver openBrowser(String browser) {
		// Selecting the browser based on the Driver that you have passed in the Excel
		try {
			switch(browser.toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\POMFrameWork\\Chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				Log.info("@@@@@@@@@@@@@--------------Launching Chrome Browser----------@@@@@@@@@@@@@@");
				break;
			case "IE":
				driver = new InternetExplorerDriver();
				Log.info("@@@@@@@@@@@@@--------------Launching IE Browser----------@@@@@@@@@@@@@@");
				break;
			case "SAFARI":
				driver = new SafariDriver();
				Log.info("@@@@@@@@@@@@@--------------Launching SAFARI Browser----------@@@@@@@@@@@@@@");
				break;
			}
			return driver;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static void launchURL(String URL) {
		try {
			driver.get(URL);
			System.out.println("----------------Launching URL----------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeBrowser() {
		try {
			System.out.println("----------------Closing the driver----------------");
			driver.close();
			System.out.println("----------------Driver closedL----------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clickAndSendKeys() {
		try {
			driver.findElement(By.xpath("")).click();
			driver.findElement(By.xpath("")).sendKeys("");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForElementToLoad(WebElement emailAddress) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
			wait.until(ExpectedConditions.visibilityOf(emailAddress));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JsonPath stringToJsonFormate(String response) {
		JsonPath jsonObj=null;
		try {
			 jsonObj =new JsonPath(response);
		}catch(Exception e) {
			e.printStackTrace();
		}return jsonObj;
	}
}
