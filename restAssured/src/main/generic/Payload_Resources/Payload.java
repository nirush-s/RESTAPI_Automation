package Payload_Resources;

public class Payload 
{

	public static String getPostPayload()
	{
		
		String payLoad = "{"+

			"\"location\": {"+

		    "\"lat\": -33.8669710,"+
		
		    "\"lng\": 151.1958750"+
		
		  "},"+
		
		  "\"accuracy\": 50,"+
		
		  "\"name\": \"Google Shoes!\","+
		
		  "\"phone_number\": \"(02) 9374 4000\","+
		
		  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
		
		  "\"types\": [\"shoe_store\"],"+
		
		  "\"website\": \"http://www.google.com.au/\","+
		
		  "\"language\": \"en-AU\""+
		
		"}";
		
		return payLoad;
	}
	
	
	public static String getPostPayload_2(String isbn, String aisle)
	{
		
		String payLoad = "{\n" + 
				"\n" + 
				"\"name\":\"Nir_2\",\n" + 
				"\"isbn\":\""+isbn+"\",\n" + 
				"\"aisle\":\""+aisle+"\",\n" + 
				"\"author\":\"Nirush\"\n" + 
				"}"
				;
		
		return payLoad;
	}
	
	
}
