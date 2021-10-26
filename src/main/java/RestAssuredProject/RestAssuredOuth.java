package RestAssuredProject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import RestAssuredPOJO.OauthPOJO;
import RestAssuredProjectPojos.LoginResponsePojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class RestAssuredOuth {

	String accessToken;
	String sRemove = "<b>Warning</b>: mysqli::mysqli(): Headers and client library minor version mismatch. Headers:100508 Library:100236 in <b>/home/u942925711/domains/upskills.in/public_html/rest-api/system/library/db/mysqli.php</b> on line <b>7</b>";
	Properties prop;
	Logger log;
	
//	@BeforeTest
//	public void loggerInitilization() {
//		PropertyConfigurator.configure("src\\main\\java\\restLoggers\\Log4j.properties");
//	    log=Logger.getLogger("devpinoyLogger");
//		
//	}
	

	
	// TC1- getAccessToken
	@Test(priority=1)
	public void getAccessToken() throws JsonParseException, JsonMappingException, IOException {
		
		int ResponseStatusCode;
		//log.info("getAccesstoken started");
		
		
		FileReader reader = new FileReader("src\\main\\java\\RestAssuredProjectPojos\\restAssured.properties");
		prop = new Properties();
		prop.load(reader); 
	
		
		Response respose = RestAssured
				// GIVEN
				.given().baseUri(prop.getProperty("BaseURL")+prop.getProperty("TokenGenerationURL"))
				.accept(ContentType.JSON)
				.header("Authorization",prop.getProperty("TokenAuthorization"))
				// WHEN
				.when().post();
	    ResponseStatusCode = respose.statusCode();
		Assert.assertEquals(200, ResponseStatusCode);

		String resposeBody = respose.body().asString();
		resposeBody = resposeBody.replace(sRemove, "");
		//log.info("TokenResponse: "+resposeBody);

		ObjectMapper obj = new ObjectMapper();
		OauthPOJO oauth = obj.readValue(resposeBody, OauthPOJO.class);
		accessToken = oauth.getData().getAccess_token();
		//log.info("Access Token : "+resposeBody);

	}
	
	// TC2- AdminLogin
    @Test(priority=2)
	public void adminLogin() throws JsonParseException, JsonMappingException, IOException {
		

		File jsonFile = new File(
				"src\\main\\java\\RestAssuredProjectPojos\\adminLoginPayload.json");
		System.out.println("started");

		Response response = RestAssured
				// GIVEN
				.given().baseUri("http://rest-api.upskills.in/api/rest_admin/login").accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(jsonFile)
				.header("Authorization", "Bearer " + accessToken)

				// WHEN
				.when()
				.post();
		int ALoginStatusCode = response.statusCode();
		Assert.assertEquals(200, ALoginStatusCode);

		String responseBody = response.body().asString();
		responseBody = responseBody.replace(sRemove, "");
		
		//log.info("LoginResponse : "+responseBody);

		ObjectMapper obj = new ObjectMapper();
		LoginResponsePojo loginPojo = obj.readValue(responseBody, LoginResponsePojo.class);
		String userName = loginPojo.getData().getUsername();

		Assert.assertEquals("upskills_admin", userName);

		// get adminUseraccount details

		Response getresponse = RestAssured
				// GIVEN
				.given().baseUri("http://rest-api.upskills.in/api/rest_admin/user")
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + accessToken)

				// WHEN
				.when()
				.get();

		String sBody2 = getresponse.body().asString();
		sBody2 = sBody2.replace(sRemove, "");
		System.out.println(sBody2);
		//log.info(" getResponse of adminAccount: "+sBody2);

		ObjectMapper obj2 = new ObjectMapper();
		LoginResponsePojo loginPojo2 = obj.readValue(sBody2, LoginResponsePojo.class);
		String userName2 = loginPojo2.getData().getUsername();

		Assert.assertEquals("upskills_admin", userName2);

		 //LogOut

		Response getlogoutresponse = RestAssured
				// GIVEN
				.given().baseUri("http://rest-api.upskills.in/api/rest_admin/logout").accept(ContentType.JSON)
				.contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken)

				// WHEN
				.when().post();
		
		int getlogoutStatus = getlogoutresponse.statusCode();
		Assert.assertEquals(200, getlogoutStatus);

	}
    
   @Test(priority=3)
    
   public void addNewCustomer() {
   	
   	File newCustomerjsonFile = new File(
			"src\\main\\java\\RestAssuredProjectPojos\\adminLoginPayload.json");
   	
    	Response getresponse = RestAssured
				// GIVEN
				.given().baseUri("http://rest-api.upskills.in/api/rest_admin/customers")
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(newCustomerjsonFile)
				.header("Authorization", "Bearer " + accessToken)

				// WHEN
				.when()
				.post();
    	
    	
    // http://rest-api.upskills.in/api/rest_admin/login

		RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/customers/limit/10/page/1";

		HashMap<String, Object> headerMap = new HashMap<String, Object>();

		headerMap.put("accept", "application/json");
		headerMap.put("Authorization", accessToken);
	
		/*
		Map<String, Object> headerMap1 = new HashMap<String, Object>();
		headerMap1.put("limit","10");
		headerMap1.put("page","1");*/
		
		
		String response=RestAssured.given().headers(headerMap).when().get().then().extract().response().asString();

		System.out.println(response);
	
	}
}


