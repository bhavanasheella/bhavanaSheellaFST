package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver openBrowser(String browserType) {
		if (browserType.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\002G4Q744\\Eclipse\\FST\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\002G4Q744\\Eclipse\\FST\\drivers\\chromedriver.exe");
			driver = new InternetExplorerDriver();

		} else if (browserType.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\002G4Q744\\Eclipse\\FST\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		return driver;

	}
	
	public static void closingBrowser(){
		driver.close();
	}

	

	/*
	 * public static void takeScreenshort(WebDriver driver) throws IOException {
	 * Screenshot fpScreenshot = new AShot().takeScreenshot(driver);
	 * ImageIO.write(fpScreenshot.getImage(), "PNG", new
	 * File("C:\\Users\\002G4Q744\\Desktop\\sCreenshort.jpg"));
	 * 
	 * } // public static void takeScreenshort1(WebDriver driver) throws IOException
	 * {
	 *///	
//	File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    FileUtils.copyFile(s, new File("C:\\Users\\002G4Q744\\Desktoptutorialpoint.png"));
//    }

}
