package request;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstRequest 
{
	@Test
	public void testResponceCode()
	{
		//Response res = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22"); -> Conventional
		//Response res = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22"); -> After making the import static
		//int code = res.getStatusCode(); -> Elaborated code
		
		int code = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		
		System.out.println("Status code" +code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test(enabled=false)
	public void testBody()
	{
		Response res = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		String data = res.asString();
		
		System.out.println("Status code" +data);
		System.out.println("Status response time" +res.getTime());
		
		//Assert.assertEquals(code, 200);
		
	}
	
	
	
}
