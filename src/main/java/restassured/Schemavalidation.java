package restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class Schemavalidation {
	
	
	@Test
	public void verifyScehema() {
		
		RestAssured.given()
		.contentType("application/json")
		.when()
		.get("https://jsonplaceholder.typicode.com/users")
		.then()
		.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/getuserschema.json"));
		
	}

}
