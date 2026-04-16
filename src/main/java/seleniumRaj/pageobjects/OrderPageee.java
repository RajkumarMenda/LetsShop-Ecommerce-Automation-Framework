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

public class OrderPageee extends AbstractReusableComponenets {

	WebDriver driver; // Need Driver for this page

	public OrderPageee(WebDriver driver) {
		// Initilaztion
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[2]")
	private	List<WebElement> Orderdeditems;

	public Boolean verifyOrderDisplay(String ProductName) {
		Boolean match = Orderdeditems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
}
