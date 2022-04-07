package stepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import org.testng.Assert;

public class LandingPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;
LandingPage landingPage;

//create constructor
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	 @Given("^user is on GreenKart Landing page$")
	    public void user_is_on_greenkart_landing_page() throws Throwable {
		 Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		 
	 }

	 @When("^user searched with Shortname (.+) and extracted actual name of product$")
	    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws Throwable { 
		 landingPage.searchItem(shortName);
		 Thread.sleep(2000);
		 testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		 System.out.println(testContextSetup.landingPageProductName + "is extracted from Home page");
		 
	 }
	 
	 @When("^user add 3 items that their searched \"([^\"]*)\" to cart$")
	    public void user_add_3_items_that_their_searched_something_to_cart(String productName) throws Throwable {
		 	testContextSetup.searchProductNameByGherkin = productName;
		 	landingPage.searchItem(productName);
		 	Thread.sleep(5000);
	        landingPage.addSearchedItemstoCart(3);
	        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	        landingPage.goToCartPage();
	        Thread.sleep(1000);
	    }
}
