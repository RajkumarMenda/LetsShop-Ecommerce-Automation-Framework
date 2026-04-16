package seleniumRaj.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import seleniumRaj.Test_ReusableComponenets.Base_ReusableTests;
import seleniumRaj.pageobjects.CartPageee;
import seleniumRaj.pageobjects.Checkoutpage;
import seleniumRaj.pageobjects.Confirmation;
import seleniumRaj.pageobjects.ProductCatlog;

public class ErrorValidationsTest extends Base_ReusableTests {

	@Test(groups = { "ErrorHandling" },retryAnalyzer = seleniumRaj.Test_ReusableComponenets.RetryRerun.class)
	public void LoginErrorValdation() throws IOException {
	
		
		String ProductName = "ZARA COAT 3";
		ProductCatlog productcatlog = loginpage.LoginApplication("Seleniumtestng@gmail.com", "Rajkr@2818"); // Credentials
																											// input
		// div[@aria-label='Incorrect email or password.'] or password
		Assert.assertEquals("Incorrect email or password.", loginpage.getErrormessage());

	}

	@Test
	public void ProductErrorValidation() throws IOException {

		String ProductName = "ZARA COAT 3";
		ProductCatlog productcatlog = loginpage.LoginApplication("Seleniumtestng@gmail.com", "Rajkumar@2818"); // Credentials
																												// input
		List<WebElement> products = productcatlog.getProductList();
		productcatlog.addProductToCart(ProductName);

		CartPageee cart = productcatlog.goToCartPage(); // take u to Cart Page
		Boolean match = cart.verifyProductDisplay("ZARA COAT 3333"); // Verify our selected product is display or not
		Assert.assertFalse(match); // validation in Test Case Only
	}

}
