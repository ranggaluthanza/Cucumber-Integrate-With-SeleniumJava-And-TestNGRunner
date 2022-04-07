package utils;

//package untuk membuat reusable utilities ( reusable action )
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SwitchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
		 //Untuk melakukan perulangan arraylist dari s1 tanpa menggunakan foreach
		 Iterator<String> i1 = s1.iterator();
		 
		 //mengambil nilai selanjutnya 
		 String parentWindow = i1.next();
		 String childWindow = i1.next();
		 driver.switchTo().window(childWindow);
	}
}
