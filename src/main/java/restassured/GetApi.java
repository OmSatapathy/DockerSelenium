package restassured;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApi {

	@Test
	public void getDetails() {
		Response res = RestAssured.given().contentType("application/json").when()
				.get("https://api.restful-api.dev/objects").andReturn();

	//	System.out.println(res.asString());

		JSONArray json = new JSONArray(res.asString());

		for (int i = 0; i < json.length(); i++) {
			JSONObject obj = json.getJSONObject(i);
			
			if(obj.has("data")&& !obj.isNull("data")) {
				JSONObject data = obj.getJSONObject("data");
				
				for(String key : data.keySet()) {
					System.out.println(data.get(key));
				}
			}
			
		}
	}
}
