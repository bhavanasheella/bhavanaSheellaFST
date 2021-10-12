package PageObjects;

import org.openqa.selenium.By;

public class Realtyregistration {
	
	public By Realty_loginORregistrtion_Button = By.xpath("//ul[@id='responsive']//li[@class='right-side-menu-item']");
	public By Realty_registrtion_Tab = By.xpath("//a[text()='Register']");
	public By Realty_login_Tab = By.xpath("//*[@class='active']/a[text()='Log In']");
	public By Realty_registrtion_Email = By.id("email");
	public By Realty_registrtion_FirstName = By.id("first-name");
	public By Realty_registrtion_LastName = By.id("last-name");
	public By Realty_registrtion_SumbitButton = By.name("submit");
	public By Realty_registrtion_SuccessNotifcation = By.xpath("//*[@class='notification success closeable']");
	
	
	
	//Login page  Objects
	
	public By Realty_login_UserName = By.id("user_login");
	public By Realty_login_password = By.id("user_pass");
	public By Realty_login_SignButton = By.name("login");
	
	//recover password Objects
	
	public By Realty_LostPassword_link = By.xpath("//P[@class = 'lost_password']/a");

	
	
	
	
			
	
	
	
	

}
