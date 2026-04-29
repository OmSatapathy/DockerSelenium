package reqres_test;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAPI {

	@Test
	public void getCall() {
		Response res = RestAssured.given().contentType("application/json").when()
				.get("https://jsonplaceholder.typicode.com/todos/1").then().extract().response();

		System.out.println(res.asPrettyString());

		JsonPath path = res.jsonPath();
		String value = path.getString("title");
		System.out.println(value);
	}

	@Test
	public void getCallById() {

		Response res = RestAssured.given().contentType("application/json").queryParam("postId", 1).when()
				.get("https://jsonplaceholder.typicode.com/comments").then().extract().response();

		System.out.println(res.asPrettyString());
		JsonPath path = res.jsonPath();

		List<String> lst = path.getList("email");

		for (int i = 0; i < lst.size(); i++) {

			System.out.println(lst.get(i).toString());
		}

	}

	@Test
	public void getComment() {
		Response res = RestAssured.given().contentType("application/json").when()
				.get("https://fake-json-api.mock.beeceptor.com/companies").then().extract().response();

		List<String> lst = res.jsonPath().getList("ceoName");

		for (String obj : lst) {
			System.out.println(obj);
			
		}

	}

}
