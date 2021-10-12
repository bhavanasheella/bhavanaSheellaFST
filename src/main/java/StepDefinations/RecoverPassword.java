package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import PageObjects.Realtyregistration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecoverPassword extends Realtyregistration {
	
	WebDriver driver;
	
		 
	 @Given("User Should navigate to realty Application and Click on login or registerTab")
	 public void user_should_navigate_to_realty_application_and_click_on_login_or_register_tab() {
		 driver = Utilities.DriverFactory.openBrowser("Chrome"); 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		  driver.get("http://realty-real-estatem1.upskills.in/admin");
		  driver.findElement(Realty_loginORregistrtion_Button).click(); 
	 }
	@When("User in login page Click on Lost password")
	public void user_in_login_page_click_on_lost_password() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(Realty_login_UserName));
	    driver.findElement(Realty_LostPassword_link).click();
	}

	@When("Password page should be displayed and Enter valid {string}")
	public void password_page_should_be_displayed_and_enter_valid_email(String string) {
		driver.findElement(Realty_login_UserName).isDisplayed();
		driver.findElement(Realty_login_UserName).sendKeys(string);
	   
	}

	@When("Click on Reset Password")
	public void click_on_reset_password() {
		
		driver.findElement(Realty_registrtion_SumbitButton).click();
	}

	@Then("Click on confirmation link received from the application in the registered email")
	public void click_on_confirmation_link_received_from_the_application_in_the_registered_email() {
	   
	}

}
