package restassured;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetmoreDetatils {

	@Test
	public void getMoreList() {
		Response res = RestAssured.given().contentType("application/json").baseUri("https://api.restful-api.dev/")
				.get("objects?id=3&id=5&id=10").andReturn();
		
		System.out.println(res.asPrettyString());

		String idvalue = res.jsonPath().getString("id");
		System.out.println(idvalue);

		String name = res.jsonPath().getString("name[1]");
		System.out.println(name);
		System.out.println("*****************");
		// Parse the response as JSONArray
		JSONArray arr = new JSONArray(res.asString());

		// Loop through each object in the array
		for (int i = 0; i < arr.length(); i++) {
			JSONObject product = arr.getJSONObject(i);
			System.out.println("Product Name: " + product.getString("name"));

			// Check if 'data' exists and is not null
			if (product.has("data") && !product.isNull("data")) {
				JSONObject data = product.getJSONObject("data");

				// Loop through each key in the 'data' object
				for (String key : data.keySet()) {
					Object value = data.get(key);

					// Handle different value types
					if (value instanceof String) {
						System.out.println("  " + key + ": " + value);
					} else if (value instanceof Number) {
						System.out.println("  " + key + ": " + value);
					} else {
						System.out.println("  " + key + ": " + value.toString());
					}
				}
			} else {
				System.out.println("  No data for this product.");
			}
		}
	}
}
