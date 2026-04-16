package seleniumRaj.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumRaj.AbstractReusableComponenets.AbstractReusableComponenets;
import seleniumRaj.pageobjects.CartPageee;
import seleniumRaj.pageobjects.Checkoutpage;

public class CartPageee extends AbstractReusableComponenets {

	WebDriver driver; // Need Driver for this page

	public CartPageee(WebDriver driver) {
		// Initilaztion
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	private	List<WebElement> cartItems;

	@FindBy(css =".totalRow button")
	private	WebElement checkout;

	public Boolean verifyProductDisplay(String ProductName) {
		Boolean match = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	public Checkoutpage gotoCheckoutPage() {
		checkout.click(); 
		Checkoutpage checkout = new Checkoutpage(driver);
		return checkout;
	}

}
