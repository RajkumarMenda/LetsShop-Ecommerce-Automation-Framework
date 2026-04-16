package seleniumRaj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumRaj.AbstractReusableComponenets.AbstractReusableComponenets;
import seleniumRaj.pageobjects.Confirmation;

public class Checkoutpage extends AbstractReusableComponenets{
	WebDriver driver;
	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="input[placeholder='Select Country']")
	private	WebElement county;
	
	@FindBy(css=".btnn")
	private	WebElement Submit;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	private	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(county, countryName).build()
				.perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}
	public Confirmation sumbitOrder() {
		Submit.click();
		Confirmation conformation = new Confirmation(driver);
		return conformation;
	}
}
