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

public class ProductCatlog extends AbstractReusableComponenets {

	WebDriver driver; // Need Driver for this page

	public ProductCatlog(WebDriver driver) {
		// Initilaztion
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3") // At Runtime it will construct into -> driver.findElement(By.id("userEmail"));
	private	List<WebElement> products; // List of WebElemets -> driver.findElements();
	@FindBy(css = ".ng-animating")
	private	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductName(String productName) {

		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click(); // This is WebElement.findElement (we can't apply pageFactory)
		waitForElementToAppear(toastmessage);
		waitForElementToDisapper(spinner);
	}

}
