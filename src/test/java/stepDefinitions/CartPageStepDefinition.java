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
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;

import org.testng.Assert;

public class CartPageStepDefinition {
	public WebDriver driver;
	public String cartProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	OffersPage offersPage;
	CartPage cartPage;

		public CartPageStepDefinition(TestContextSetup testContextSetup) {
			this.testContextSetup = testContextSetup;
			this.cartPage = testContextSetup.pageObjectManager.getCartPage();
		}
		
		@And("^apply promo code in cart page$")
	    public void apply_promo_code_in_cart_page() throws Throwable {
	        cartProductName = cartPage.checkSearchProductNameInTable(testContextSetup.searchProductNameByGherkin);
	        Assert.assertEquals(testContextSetup.landingPageProductName, cartProductName);
	        Assert.assertTrue(cartPage.VerifyPromoBtn());
	        Assert.assertTrue(cartPage.VerifyPlaceOrder());
	    }
		
		@Then("^Place order$")
	    public void place_order() throws Throwable {
	        cartPage.placeConfirmationOrder();
	        
	    }
		
		
	
}
