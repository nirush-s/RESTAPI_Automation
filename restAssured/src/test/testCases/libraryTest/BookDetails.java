package libraryTest;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DataProviders.Library_DataProvider;
import Payload_Resources.Payload;
import Payload_Resources.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookDetails extends Library_DataProvider
{
	Properties properties = new Properties();

	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fileinputstream = new FileInputStream("/Users/300069257/Desktop/REST ASSURED/restAssured/src/main/generic/properties/envy.properties");
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
	
	
	@Test(dataProvider = "postMethod_DataProvider")
	public void postMethod(String isbn, String aisle)
	{
		
		RestAssured.baseURI = properties.getProperty("Library_Host");
		
		Response res = 
		given().
		body(Payload.getPostPayload_2(isbn,aisle)).

		when().
		post(Resources.postResource_libraryTest_1()).

		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().  
		extract().response();
		
		String response = res.asString();
		
		System.out.println(response);
		
	}
	
}
