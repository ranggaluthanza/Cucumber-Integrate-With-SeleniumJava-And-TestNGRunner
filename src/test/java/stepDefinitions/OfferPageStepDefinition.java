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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;

import org.testng.Assert;

public class OfferPageStepDefinition {
public WebDriver driver;
public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;
LandingPage landingPage;
OffersPage offersPage;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offersPage = testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	 @Then("^user searched for (.+) shortname in offers page to check if product exist with same name$")
	    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		 switchToOffersPageFromLandingPage();
		 offersPage.searchItem(shortName);
		 Thread.sleep(2000);
		 offerPageProductName = offersPage.searchProductNameInTable(shortName);
		 System.out.println(offerPageProductName);
	    }
	 public void switchToOffersPageFromLandingPage() {
		landingPage.getLinkOffersPage();
		// to handle multiple windows in 1 browser
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	 
	 @And("^validate product name in offers page matches with Landing Page$")
	    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {
		 Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	    }

}
