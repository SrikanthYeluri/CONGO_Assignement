package CongaTest.AutomationAssignment;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import CongaTest.ReusableMethods.ActionMethods;

public class APITest {

	@Test
	public static void test1() {
		
		//API : api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		RestAssured.baseURI="https://openweathermap.org";
		// to register the Weather station with out API KEY
		String response = given().queryParam("q", "Delhi").when().log().all().post("//data/2.5/weather").then().assertThat().statusCode(401)
			.extract().response().asString();
		// to convert the response string to Json formate
		JsonPath json = new JsonPath(response);
		// Asserting the Message
		System.out.println("Invalid Message formate: "+json.get("message"));
		Assert.assertEquals(json.get("message"), "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");
		
	}
	@Test
	public void test2() {
		RestAssured.baseURI="https://openweathermap.org";
		given().header("Content-Type", "text/plain").queryParam("q", "Delhi").queryParam("appid", "4e446be311435b106121bccdbe864ae5").
		body("\"external_id\": \"Interview15675675676767675 \",\"name\": \"Interview Station12121\", \"latitude\": 33.44,\"longitude\": -12.44,\"altitude\": 444").when().post("//data/2.5/weather").then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		// second request
		
		
		  given().queryParam("q", "India").queryParam("appid",
		  "87253b5f3d777fee874368bc3daf10a6").
		  body("\"external_id\": \"Interview1 "+"\",\r\n" +
		  "\"name\": \"Interview Station"+"\", \"latitude\": 33.33,\r\n" +
		  "\"longitude\": -111.43,\r\n" + "\"altitude\": 444 \r\n" +
		  "").when().post("//data/2.5/weather").then().assertThat().log().all().
		  statusCode(200).extract().response().asString();
		 
	}
}
