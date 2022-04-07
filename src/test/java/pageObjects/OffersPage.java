package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestContextSetup;

public class OffersPage {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	String searchedProductName;
	
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	By searchEditBox =By.xpath("//input[@type='search']");
	By tableProduct_xpath = By.xpath("//*[@id='root']/div/div/div/div/div/div/table");
	
	public void searchItem(String name) {
		driver.findElement(searchEditBox).sendKeys(name);
	}
	
	public WebElement getTableProduct() {
		return driver.findElement(tableProduct_xpath);
	}
	
	public String searchProductNameInTable(String shortName) {
		//identify table
		 WebElement tableProduct = driver.findElement(tableProduct_xpath);
		 //count rows of table with size() method
		 List<WebElement> table_rows= tableProduct.findElements(By.tagName("tr"));
		 int table_rows_count = table_rows.size();
		 for (int i = 0; i < table_rows_count; i++) {
			 List<WebElement> table_col= table_rows.get(i).findElements(By.tagName("td"));
			 int table_col_count = table_col.size();
			 for (int j = 0; j< table_col_count; j++) {
				 String productSearchedName = table_col.get(j).getText();
				 if(productSearchedName.contains(shortName)) {
					searchedProductName = productSearchedName;
				 }
			 }
		 }
	
		return searchedProductName;
		
	}
	
}
