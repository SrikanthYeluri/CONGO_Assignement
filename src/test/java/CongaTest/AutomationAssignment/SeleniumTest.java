package CongaTest.AutomationAssignment;

import org.jfree.util.Log;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import CongaTest.Pages.LoginPage;
import CongaTest.Pages.TShirtSelectionPage;
import CongaTest.ReusableMethods.ActionMethods;

/**
 * Unit test for simple App.
 */
public class SeleniumTest extends ActionMethods
    
{
	LoginPage loginPageObj = PageFactory.initElements(driver, LoginPage.class);	
	
	@org.testng.annotations.Test
	public void scenario1Test() {
		try {
			System.out.println("Test");
			LoginPage login_Page_Obj = PageFactory.initElements(driver, LoginPage.class);
			TShirtSelectionPage tShitPage_Section_Obj = PageFactory.initElements(driver, TShirtSelectionPage.class);
			// to login to the website
			login_Page_Obj.loginTest("jetblue@grr.la", "jetblue");
			// to add the product and checkout
			tShitPage_Section_Obj.addTshirtAndAddToCheckout();
			// to validate the "Product successfully added to your shopping cart" successMessage
			tShitPage_Section_Obj.verifySuccessMessage();
			// to validate the details of product
			tShitPage_Section_Obj.validateTheDetails();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@BeforeMethod
	public void beforeClass() {
		try {
			Log.info("Open Browser Method");
			openBrowser("chrome");
			launchURL("http://Automationpractice.com");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterClass() {
		try {
			System.out.println("Browser CLosed");
			closeBrowser();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
