package seleniumRaj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumRaj.AbstractReusableComponenets.AbstractReusableComponenets;

public class Confirmation extends AbstractReusableComponenets{
	WebElement driver;
	public Confirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	private	WebElement confirmsg;
	
	public String getConfirmationmessage() {
		return confirmsg.getText();
	}
}
