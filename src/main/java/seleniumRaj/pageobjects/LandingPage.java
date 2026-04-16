package seleniumRaj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumRaj.AbstractReusableComponenets.AbstractReusableComponenets;
import seleniumRaj.pageobjects.ProductCatlog;

public class LandingPage extends AbstractReusableComponenets {

	WebDriver driver; // We are getting this driver form test files

	public LandingPage(WebDriver driver) {
		super(driver); // Passing the Driver object from Child To Parent Class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// Instead of writing this way we can also optimize the duplicate code by
	// PageFactory()
	// This is Just declaration, not locating.
	// Then, PageFactory will locate it automatically using INIT step.
	// To initialize the all elements we use PageFactory.initElements(driver, this);
	// in Constructor

	@FindBy(id = "userEmail") // At Runtime it will construct into -> driver.findElement(By.id("userEmail"));
	private	WebElement userEmail;

	@FindBy(id = "userPassword")
	private	WebElement password;

	@FindBy(id = "login")
	private	WebElement login;

	@FindBy(css = "[class*='flyInOut']")
	private	WebElement LoginErrormessage;

	public ProductCatlog LoginApplication(String Email, String Password) {
		userEmail.sendKeys(Email);
		password.sendKeys(Password);
		login.click();
		ProductCatlog productcatlog = new ProductCatlog(driver);
		return productcatlog;
	}

	public String getErrormessage() {
		waitForWebElementToAppear(LoginErrormessage);
		return LoginErrormessage.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
