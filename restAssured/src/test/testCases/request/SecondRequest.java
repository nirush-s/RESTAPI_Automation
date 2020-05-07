package request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Payload_Resources.Payload;
import Payload_Resources.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SecondRequest
{
	
	Properties properties = new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
				
		FileInputStream fileinputstream = new FileInputStream("/Users/300069257/Desktop/REST ASSURED/restAssured/src/main/java/properties/envy.properties");
		properties.load(fileinputstream);
		//properties.getProperty("HOST");
	}
	
	
	/*public void responceCode()
	{
		
		
		RestAssured.baseURI = "https://samples.openweathermap.org";
		
		given().
			param("q","London,uk").
			param("appid","b6907d289e10d714a6e88b30761fae22").
			
			when().
			get("data/2.5/weather").
			
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().  
			//body("weather[0].id",equalTo("300"));
			header("Server","openresty/1.9.7.1");
		
	}*/
	
	@Test
	public void postData()
	{
		
			RestAssured.baseURI = properties.getProperty("HOST");
			
			//Post
			Response res  = given().
			queryParam("key",properties.getProperty("KEY")).
			body(Payload.getPostPayload()).
			
			when().
			post(Resources.postResource()).
			
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().  
			body("status",equalTo("OK")).
			extract().response();
		
			System.out.println("Post completed");
			
			String Response = res.asString();
			System.out.println(Response);
			
			JsonPath js = new JsonPath(Response);
			String PalceID = js.get("place_id");
			System.out.println("PlaceID is -"+PalceID);
			
			
			//Delete
			given().
			queryParam("key",properties.getProperty("KEY")).
			body("{"+
					"\"place_id\":\""+PalceID+"\""  +
				"}").
			
			when().
			post(Resources.deleteResource()).
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().  
			body("status",equalTo("OK"));
			System.out.println("Delete completed");
		
	}
	
}
