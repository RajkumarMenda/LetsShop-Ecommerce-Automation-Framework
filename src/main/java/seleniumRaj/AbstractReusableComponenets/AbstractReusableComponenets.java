package seleniumRaj.AbstractReusableComponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumRaj.pageobjects.CartPageee;
import seleniumRaj.pageobjects.OrderPageee;

public class AbstractReusableComponenets {
	WebDriver driver;

	public AbstractReusableComponenets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderheader;

	// Reusbale Explicit wait
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

		// By.cssSelector(".mb-3") This is By Locator not WebElement and return type is
		// Locator
	}
	public void waitForWebElementToAppear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));

		// By.cssSelector(".mb-3") This is By Locator not WebElement and return type is
		// Locator
	}

	public void waitForElementToDisapper(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele)); // wait for 4 seconds to load the invisible spinner in
															// backend
	}

	public CartPageee goToCartPage() {
		cart.click(); // Take you to cart page
		CartPageee cart = new CartPageee(driver);
		return cart;
	}
	public OrderPageee goToOrdersPage() {
		orderheader.click(); // Take you to cart page
		OrderPageee Orderpage = new OrderPageee(driver);
		return Orderpage;
	}
}
