package com.APItest.helper;
import java.util.Properties;

import org.hamcrest.Matchers;

import com.APItest.models.LoginRequestPOJO;
import com.APItest.models.LoginResponsePOJO;
import com.APItest.utils.*;
import com.testAPI.constants.Endpoints;
import com.APItest.helper.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ResuableMethods {
		
	public static String getdataFromfile(String data) {
		Utils_API UT = new Utils_API();
		Properties configfile=UT.loadFile("config");
		String info = UT.getProperty(data,configfile);
		 return info;
	}
	public static Response LoginTOApplication() {
		LoginRequestPOJO loginData=new LoginRequestPOJO();
		loginData.setUsername(getdataFromfile("username"));
		loginData.setPassword(getdataFromfile("password"));
	Response res=	RestAssured
		.given()
		.body(loginData)
		.contentType(ContentType.JSON)
		.when()
		.post(Endpoints.LOGIN);
	
		return res;
	}
	public static String getToken() {
		Response res = LoginTOApplication();
	    LoginResponsePOJO[]	list=res.as(LoginResponsePOJO[].class);
		String token=list[0].getToken();
		   System.out.println("token is :"+token);
		   return token;
	}
	public static int getStatusCode(Response res) {
		
		return res.getStatusCode();
		 
	}
	public static void verifystatuscode(Response res, int code) {
		res.then().statusCode(code);

	}
	public static String getContentType(Response res) {
		return res.getContentType();
	}
	public static void validatecontentType(Response res,String contenttype) {
		res.then().contentType(contenttype);
	}
	
	public static String GetDataFromResponse(Response res, String path) {
		String result=res.jsonPath().get(path);	
		return result;
	}
	public static void validate_equal(Response res,String path,String match) {
		res.then().body(path,Matchers.equalTo(match));

	}
	
	public static void Schemavalidation(Response res,String filename) {
		res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(filename));	

	}
	public static void ResponsePrint(Response res) {
		res.prettyPrint();
	}
}
