package StepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.Realtyregistration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginstepdefination extends Realtyregistration {
	WebDriver driver;

	
	
	  
	  @Given("User Should navigate to Realty admin Application and Click on login or registerTab")
	  public void user_should_navigate_to_realty_admin_application_and_click_on_login_or_register_tab() {
		  driver = Utilities.DriverFactory.openBrowser("Chrome"); 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		  driver.get("http://realty-real-estatem1.upskills.in/admin");
		  driver.findElement(Realty_loginORregistrtion_Button).click();  
	  }
	 
	@When("User in login page Enter valid cradentials in {string} {string}")
	public void user_in_login_page_enter_valid_cradentials_in(String string, String string2) {
		driver.findElement(Realty_login_UserName).sendKeys(string);
		driver.findElement(Realty_login_password).sendKeys(string2);

	}

	@When("Click on Signin")
	public void click_on_signin() {
		driver.findElement(Realty_login_SignButton).click();

	}

	@Then("User Should landed to Dashboard page")
	public void user_should_landed_to_Dashboard_page(DataTable dataTable) {
		List<String> data = dataTable.asList(String.class);
		String ExpectedTitle = data.get(0);

		String titileofDashboard = driver.getTitle();
		Assert.assertEquals(titileofDashboard, ExpectedTitle, "User landed to dashboard");

	}
	
	


}
