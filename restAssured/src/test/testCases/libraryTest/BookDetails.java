package libraryTest;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Excel.DataProviderClass;
import Payload_Resources.Payload;
import Payload_Resources.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookDetails 
{
	Properties properties = new Properties();

	@BeforeSuite
	public void getData() throws IOException
	{
		FileInputStream fileinputstream = new FileInputStream("/Users/300069257/git/RESTAPI_Automation/restAssured/src/main/generic/properties/envy.properties");
		properties.load(fileinputstream);
		
	}
	
	@Test(enabled=false)
	public void getMethod()
	{
		RestAssured.baseURI = properties.getProperty("Library_Host");
		
		Response res = 
		given().
		param("ID"," 16_ab  6").
		
		when().
		get("/Library/GetBook.php").

		then().assertThat().statusCode(200).contentType(ContentType.JSON).
		extract().response();
		
		String response = res.asString();
		
		System.out.println(response);
		
	}
	
	
	
	public void postMethod(Map<String,String> map)
	{
		
		RestAssured.baseURI = "http://216.10.245.166";//properties.getProperty("Library_Host");
		
		Response res = 
		given().
		body(Payload.getPostPayload_2(map.get("ISBN"),map.get("Aisle"))).

		when().
		post(Resources.postResource_libraryTest_1()).

		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().  
		extract().response();
		
		String response = res.asString();
		
		System.out.println(response);
		
	}
	
}
