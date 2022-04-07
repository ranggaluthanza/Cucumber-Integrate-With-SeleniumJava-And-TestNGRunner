package utils;
import java.io.IOException;

//fungsi class ini untuk menyimpan variable yang dapat diambil oleh class lainnya
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.PageObjectManager;


public class TestContextSetup {
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public String searchProductNameByGherkin;
	
	//to create construct when other class need pageObjectManager (depedency injection from pageobjectmanager)
	public TestContextSetup() throws IOException {
		testBase = new TestBase(); // to create object to access webdriver manager
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
}
