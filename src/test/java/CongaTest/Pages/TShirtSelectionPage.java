package CongaTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import CongaTest.ReusableMethods.ActionMethods;

public class TShirtSelectionPage extends ActionMethods{

	@FindBy(xpath="(//*[@title='T-shirts' and text()='T-shirts'])[last()]") WebElement tShirtLink;
	@FindBy(xpath="(//*[@title='Faded Short Sleeve T-shirts'])[last()]") WebElement selectTshirt;
	@FindBy(xpath="//*[text()='Add to cart']") WebElement addToCart;
	@FindBy(xpath="//*[@id='layer_cart']//*[@title='Proceed to checkout']/span") WebElement proceedToCheckout;
	@FindBy(xpath="//*[@class='icon-ok']/..") WebElement successMessageVerification;
	
	// to click on the tshirt section and adding the product into cart.
	public void addTshirtAndAddToCheckout() {
		try {
			tShirtLink.click();
			waitForElementToLoad(selectTshirt);
			selectTshirt.click();
			waitForElementToLoad(addToCart);
			addToCart.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// to assert the success message by adding the product
	public void verifySuccessMessage() {
		try {
			waitForElementToLoad(successMessageVerification);
			String successMsg = successMessageVerification.getText();
			// to assert the successfully adding the product.
			Assert.assertEquals(successMsg, "Product successfully added to your shopping cart");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// to validate the details
	public void validateTheDetails() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
