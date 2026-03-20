package restassured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecification {
	
	protected static io.restassured.specification.RequestSpecification  requestspec;
	protected static ResponseSpecification ressepc;
	
	static {
		requestspec =  new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.setBaseUri("https://jsonplaceholder.typicode.com")
				.setBasePath("/posts")
				 .build();
	}
	
	static {
		ressepc =  new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
	}
	

}
