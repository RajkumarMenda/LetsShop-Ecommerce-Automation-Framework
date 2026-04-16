package seleniumRaj.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumRaj.Test_ReusableComponenets.Base_ReusableTests;
import seleniumRaj.pageobjects.CartPageee;
import seleniumRaj.pageobjects.Checkoutpage;
import seleniumRaj.pageobjects.Confirmation;
import seleniumRaj.pageobjects.LandingPage;
import seleniumRaj.pageobjects.ProductCatlog;

public class StepDefinitionImplementations extends Base_ReusableTests {
	LandingPage landingpage;
	ProductCatlog productcatlog;
	Confirmation confirmation;

	@Given("I Landed on Ecommerce Page") // Background - same @Test in TestNg
	public void I_Landed_on_Ecommerce_Page() throws IOException {
		landingpage = launchApplication();
	}

	@Given("User Logged in with Username {string} and Password {string}")
	public void Logged_in_with_username_and_password(String Username, String Password) {
		productcatlog = landingpage.LoginApplication(Username, Password);
	}

	@When("User add the product {string} to cart")
	public void User_add_the_product_to_cart(String ProductName) {
		List<WebElement> products = productcatlog.getProductList();
		productcatlog.addProductToCart(ProductName);
	}

	@And("Checkout the product {string} and sumbit the order")
	public void Checkout_the_product_and_sumbit_the_order(String ProductName) {
		CartPageee cart = productcatlog.goToCartPage(); // take u to Cart Page
		Boolean match = cart.verifyProductDisplay(ProductName); // Verify our selected product is display
																// or not
		Assert.assertTrue(match); // validation in Test Case Only

		Checkoutpage checkout = cart.gotoCheckoutPage();
		checkout.selectCountry("india");
		confirmation = checkout.sumbitOrder();
	}

	@Then("{string} message is Displayed on ConfirmationPage")
	public void message_is_Displayed_on_ConfirmationPage(String msg) {
		String confirmsg = confirmation.getConfirmationmessage();
		System.out.println(confirmsg);
		Assert.assertTrue(confirmsg.equalsIgnoreCase(msg));
		driver.close();
	}

	@Then("{string} message is Displayed on LoginPage")
	public void message_is_Displayed_on_LoginPage(String message) {
		Assert.assertEquals(message, loginpage.getErrormessage());
		driver.close();
	}

}
