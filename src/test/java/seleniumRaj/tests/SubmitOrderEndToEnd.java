package seleniumRaj.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumRaj.Test_ReusableComponenets.Base_ReusableTests;
import seleniumRaj.pageobjects.CartPageee;
import seleniumRaj.pageobjects.Checkoutpage;
import seleniumRaj.pageobjects.Confirmation;
import seleniumRaj.pageobjects.LandingPage;
import seleniumRaj.pageobjects.OrderPageee;
import seleniumRaj.pageobjects.ProductCatlog;

public class SubmitOrderEndToEnd extends Base_ReusableTests {
	String ProductName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void submitOrderEndToEnd(HashMap<String, String> Input) throws IOException {

		ProductCatlog productcatlog = loginpage.LoginApplication(Input.get("email"), Input.get("Password")); // Credentials
		// input
		List<WebElement> products = productcatlog.getProductList();
		productcatlog.addProductToCart(Input.get("ProductName"));

		CartPageee cart = productcatlog.goToCartPage(); // take u to Cart Page
		Boolean match = cart.verifyProductDisplay(Input.get("ProductName")); // Verify our selected product is display
																				// or not
		Assert.assertTrue(match); // validation in Test Case Only

		Checkoutpage checkout = cart.gotoCheckoutPage();
		checkout.selectCountry("india");
		Confirmation confirmation = checkout.sumbitOrder();

		String confirmsg = confirmation.getConfirmationmessage();
		System.out.println(confirmsg);
		Assert.assertTrue(confirmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = "submitOrderEndToEnd") // depends on sumbit order test
	// Test-2 To Verify ZARA Coat 3 is Displaying in orders page
	public void orderHistoryTest() {
		ProductCatlog productcatlog = loginpage.LoginApplication("Seleniumtestng@gmail.com", "Rajkumar@2818"); // Credentials
																												// input
		OrderPageee orderpage = productcatlog.goToOrdersPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(ProductName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> Data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\selenumRaj\\DataJson\\PurchaseOrder.json");

		return new Object[][] { { Data.get(0) }, { Data.get(1) } }; //Returning 2 HashMaps from Json File
	}

//	HashMap<String, String> Ds1 = new HashMap<>();
//	Ds1.put("email", "Seleniumtestng@gmail.com");
//	Ds1.put("Password", "Rajkumar@2818");
//	Ds1.put("ProductName", "ZARA COAT 3");
//
//	HashMap<String, String> Ds2 = new HashMap<>();
//	Ds2.put("email", "Seleniumtestng@gmail.com");
//	Ds2.put("Password", "Rajkumar@2818");
//	Ds2.put("ProductName", "ADIDAS ORIGINAL");

}
