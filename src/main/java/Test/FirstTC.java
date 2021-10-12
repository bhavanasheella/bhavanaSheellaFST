package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FirstTC {
	public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	driver = Utilities.DriverFactory.openBrowser("Chrome");
	driver.get("https://artoftesting.com/samplesiteforselenium");
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	WebElement drpElement = driver.findElement(By.id("testingDropdown"));
	
	Select dropDown = new Select(drpElement);
	dropDown.selectByIndex(2);
	
	Thread.sleep(10);
	
	/* Utilities.DriverFactory.takeScreenshort(driver); */
	
	}

}
