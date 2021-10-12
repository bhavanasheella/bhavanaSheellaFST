package StepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.Realtyregistration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RealtyRegistration extends Realtyregistration {
	WebDriver driver;

	@Given("User Should navigate to Realty Application and Click on login or registerTab")
	public void user_should_navigate_to_realty_application_and_click_on_login_or_register_tab() {
		driver = Utilities.DriverFactory.openBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://realty-real-estatem1.upskills.in/");
		driver.findElement(Realty_loginORregistrtion_Button).click();

	}

	@When("Click on register tab and Enter valid cradentials in {string} {string} {string}")
	public void click_on_register_tab_and_enter_valid_cradentials_in(String string, String string2, String string3) {
		driver.findElement(Realty_login_Tab).isDisplayed();
		driver.findElement(Realty_registrtion_Tab).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,500)");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(Realty_registrtion_SumbitButton));
		driver.findElement(Realty_registrtion_Email).sendKeys(string);
		driver.findElement(Realty_registrtion_FirstName).sendKeys(string2);
		driver.findElement(Realty_registrtion_LastName).sendKeys(string3);

	}

	@When("Click on register button")
	public void click_on_register_button() {
		driver.findElement(Realty_registrtion_SumbitButton).click();
	}

	@Then("User should successfully registered to real estate")
	public void user_should_successfully_registered_to_real_estate(DataTable dataTable) {
		List<String> data = dataTable.asList(String.class);
		String ExpectedMsg = data.get(0);
		String RegistrtionSuccessMSG = driver.findElement(Realty_registrtion_SuccessNotifcation).getText();
		Assert.assertEquals(RegistrtionSuccessMSG, ExpectedMsg);
	}

	@Then("User close the browser")
	public void user_close_the_browser() {
	  Utilities.DriverFactory.closingBrowser();
	}

}
