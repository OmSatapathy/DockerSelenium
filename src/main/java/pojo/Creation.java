package pojo;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Creation {

	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		String json = "{ \"id\": 101, \"name\": \"John Doe\", \"email\": \"john@example.com\" }";

		ObjectMapper omp = new ObjectMapper();

		Student stu = omp.readValue(json, Student.class);
		System.out.println(stu);
		
		omp.writerWithDefaultPrettyPrinter().writeValueAsString(omp);
		

	}
	
	@Test
	public void verifyResponse() {
		Response res = RestAssured.given().accept(ContentType.JSON).contentType("application/json").when()
				.get("https://api.restful-api.dev/objects?id=3&id=5&id=10").andReturn();

		JsonPath value = res.body().jsonPath();
		List<String> list = value.getList("data");

		System.out.println(list);
	}

}
