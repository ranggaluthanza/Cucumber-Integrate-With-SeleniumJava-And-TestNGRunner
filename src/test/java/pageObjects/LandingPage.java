package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	By searchEditBox = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By linkOffersPage = By.linkText("Top Deals");
	By productContainer_xpath = By.xpath("//div[@class='products']");
	By addToChart_button = By.xpath("//button[contains(text(),'ADD TO CART')]");
	By cartIcon = By.xpath("//a[@class='cart-icon']");
	By proceedToCheckout_button = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	
	public void searchItem(String name) {
		driver.findElement(searchEditBox).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(searchEditBox).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void getLinkOffersPage() {
		driver.findElement(linkOffersPage).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	public void addSearchedItemstoCart(int itemsCount) {
		WebElement productContainer = driver.findElement(productContainer_xpath);
		//count rows of table with size() method
		List<WebElement> table_rows= productContainer.findElements(By.xpath("//div[@class='product']"));
		int table_rows_count = table_rows.size();
		for (int i = 0; i < table_rows_count; i++) {
			WebElement table_col= table_rows.get(i).findElement(By.xpath("//a[@class='increment']"));
			for (int j = 0; j < itemsCount-1; j++) {
				table_col.click();
			}
			driver.findElement(addToChart_button).click();
		}
	}
	
	public void goToCartPage() throws InterruptedException {
		driver.findElement(cartIcon).click();;
		Thread.sleep(3000);
		driver.findElement(proceedToCheckout_button).click();;
	}
}
