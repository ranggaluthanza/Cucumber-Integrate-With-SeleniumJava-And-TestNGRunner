package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
public WebDriver driver;
String searchedProductName;

	By tableListProduct = By.xpath("//*[@id=\"productCartTables\"]");
	By promoButton = By.xpath("//button[@class='promoBtn']");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	By countrySelectBox = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select");
	By agreementCheckbox = By.xpath("//input[@class='chkAgree']");
	By proceedbutton = By.xpath("//button[contains(text(),'Proceed')]");
	

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkSearchProductNameInTable(String shortName) {
		//identify table
		 WebElement tableProduct = driver.findElement(tableListProduct);
		 //count rows of table with size() method
		 List<WebElement> table_rows= tableProduct.findElements(By.tagName("tr"));
		 int table_rows_count = table_rows.size();
		 for (int i = 0; i < table_rows_count; i++) {
			 List<WebElement> table_col= table_rows.get(i).findElements(By.tagName("td"));
			 int table_col_count = table_col.size();
			 for (int j = 0; j< table_col_count; j++) {
				 String productSearchedName = table_col.get(j).getText();
				 if(productSearchedName.contains(shortName)) {
					searchedProductName = shortName;
				 }
			 }
		 };
		return searchedProductName;
		
	}
	
	public Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public void placeConfirmationOrder() throws InterruptedException
	{
		driver.findElement(placeOrder).click();
		Thread.sleep(2000);
		WebElement selectBoxCountry =  driver.findElement(countrySelectBox);
		Select dropdown = new Select(selectBoxCountry);
		dropdown.selectByValue("Indonesia");
		driver.findElement(agreementCheckbox).click();
		driver.findElement(proceedbutton).click();
	}
	
}
