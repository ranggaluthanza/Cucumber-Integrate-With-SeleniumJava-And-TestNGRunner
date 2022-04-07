package pageObjects;

import org.openqa.selenium.WebDriver;

//to create object for all page object files (untuk membuat object dari setiap page untuk digunakan di class lainnya)
public class PageObjectManager {
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CartPage cartPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CartPage getCartPage() {
		cartPage = new CartPage(driver);
		return cartPage;
	}
}
