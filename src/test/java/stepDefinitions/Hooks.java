package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks{
	
	public WebDriver driver;
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	
//pico container helps us just to make container to give object to other file
public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	/*@Before("@ChromeBrowser")
	public void setUpDriver() {
		String chromeDriver = System.getenv("CHROME_DRIVER");
		System.setProperty("webdriver.chromedriver.whitelistedIps", chromeDriver);
		testContextSetup.driver = new ChromeDriver(); // bertindak sebagai client untuk testContext object drivernya
	}*/
	
	@After()
	public void tearDown() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	//will execute after each and every step scenario
	@AfterStep()
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			//user maven repository apache commons IO to convert a file to byte format
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);

			//to attach screenshot to scenario
			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
}
