package CongaTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import CongaTest.ReusableMethods.ActionMethods;

public class LoginPage extends ActionMethods{
	
	// writing the Page Factory settings
	
	@FindBy(xpath="//*[@title='Log in to your customer account']")
	public WebElement signIn;
	
	@FindBy(xpath="//*[text()='Already registered?']/following::div//*[@id='email']")
	public WebElement emailAddress;

	@FindBy(xpath="//*[text()='Already registered?']/following::div//*[@id='passwd']")
	public WebElement pwd;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	public WebElement clickLogin;
	
	
 // get text to validate the successfull product validation
	
	public void loginTest(String userEmail,String passWord) {
		try {
			signIn.click();
			waitForElementToLoad(emailAddress);
			emailAddress.sendKeys(userEmail);
			pwd.sendKeys(passWord);
			clickLogin.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
