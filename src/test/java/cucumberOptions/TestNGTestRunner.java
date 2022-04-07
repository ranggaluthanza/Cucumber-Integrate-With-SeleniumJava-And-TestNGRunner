package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefinitions", tags="@ValidateProduct", monochrome=true,
		plugin = {
					"pretty","html:target/report/cucumber.html", 
					"json:target/report/cucumber.json", 
					"junit:target/report/cucumber.xml",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:target/fail_scenarios.txt" // this plugin to rerun fail scenarios when there's failure it actually not a real failure
				 }
		)
//aventstack berfungsi untuk membuat extent report berupa spark.html yang memiliki informasi detail dari test yang dijalankan
//aventstack membutuhkan maven repos extent report dari aventstack dan adapater ExtentCucumber7 Adapter dari Grasshopper
//membuat properties di resources untuk membuat properties extent reports nya
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	// to run test cases parallely
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
