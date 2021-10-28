package com.qa.testcases;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import junit.framework.Assert;

public class TC002_Post_UserRegistration {

	
	@Test
	public void Get_SingleUserDetails() {
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/2";
		
		Response response = given().contentType(ContentType.JSON).log().all().get("data").then().extract().path("data/email");
		//System.out.println(response);
		
		response.prettyPrint();
				
		
//		RequestSpecification request = RestAssured.given();
//		request.get("https://reqres.in");
//		Response response = given().contentType(ContentType.JSON).log().all()
//				.when()
//				.get("/api/users/2")
//							
//	
//		.then().extract().path("data/email");
//		
//		int code = response.getStatusCode();
//		System.out.println(code);
//		String email =response.path("data/email");
//		System.out.println(email);
////		String body = response.jsonPath().get("data");
////		System.out.println(body);
				
		
	}
	
	
	//@Test
	public void Post_UserRegistration() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("email", "eve.holt@reqres.in");
		json.put("password", "piston");

		request.body(json.toJSONString());

		Response response = request.post("https://reqres.in/api/register");
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}

}
