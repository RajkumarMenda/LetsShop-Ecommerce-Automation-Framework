package seleniumRaj.Test_ReusableComponenets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumRaj.pageobjects.LandingPage;

public class Base_ReusableTests {
	// 1. Driver Initialization is common for all Testcases
	public WebDriver driver; // Globar Varibale
	public LandingPage loginpage;

	public WebDriver initializerDriver() throws IOException {

		// Global Properties from .properties file and util Package
		Properties property = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\seleniumRaj\\DataResources\\GlobalData.properties");
		property.load(file);
		// To Read a browser value which is coming from CMD or maven
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: property.getProperty("browser"); // Used to read system level variable
		// String browserName = property.getProperty("browser");
		if (browserName.contains("chrome")) {
			// Chrome
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
				options.addArguments("--window-size=1920,1080");
			}
			driver = new ChromeDriver(options);
			//driver.manage().window().setSize(new Dimension(1440,990));

		} else if (browserName.equalsIgnoreCase("frefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	// Login is a common Method for all Test cases
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializerDriver();
		loginpage = new LandingPage(driver);
		loginpage.goTo(); // URL Open
		return loginpage;
	}

	// Browser needs to close at the end (After test execution is completed)
	@AfterMethod(alwaysRun = true) // alwaysRun = true is used to run for every gropus
	public void teardown() {
		driver.close();
	}

	// Usable Json Data Provider
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		// Read Json String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		// String to HashMap
		ObjectMapper mapper = new ObjectMapper(); // JavaClass
		List<HashMap<String, String>> Data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return Data; // Data -> {{HashMap},{HashMap}}
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; // Cast the Driver to take a screenshot
		File src = ts.getScreenshotAs(OutputType.FILE); // Get the Screenshot as output as file
		File dest = new File(System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png"); // destination
		FileUtils.copyFile(src, dest); // Copying the file into our system
		return System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png"; // returning the path where u r
																						// screenshot is storing in
																						// local system
	}
}
