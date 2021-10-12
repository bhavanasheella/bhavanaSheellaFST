package Test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class frameTest {
	
	
    @Test
	public static void login() {
		System.out.println("bhavana");
	}
    
    @BeforeSuite
    public static void login1() {
		System.out.println("bhavana1");
	}

}
