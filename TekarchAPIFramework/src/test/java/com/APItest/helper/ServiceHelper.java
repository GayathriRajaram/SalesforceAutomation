package com.APItest.helper;

import org.testng.annotations.*;

import com.APItest.models.AdduserPOJO;
import com.APItest.models.DeleteUserPOJO;
import com.APItest.models.UpdateUserPOJO;
import com.testAPI.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class ServiceHelper extends ResuableMethods{

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = getdataFromfile("baseuri");
	}
	public static Response getuser() {
	Header header = new Header("token",getToken());
	System.out.println(header);
	Response res = RestAssured
	.given()
	.header(header)
	.when()
	.get(Endpoints.GET_DATA);
	return res;
	}
	
	public static Response createuser() {
		AdduserPOJO createuserdetails = new AdduserPOJO();
		createuserdetails.setAccountno(getdataFromfile("accountno"));
		createuserdetails.setDepartmentno(Integer.parseInt(getdataFromfile("departmentno")));
		createuserdetails.setSalary(Integer.parseInt(getdataFromfile("salary")));
		createuserdetails.setPincode(Integer.parseInt(getdataFromfile("pincode")));
		Header header = new Header("token",getToken());
		Response res = RestAssured
						.given()
						.header(header)
						.contentType(ContentType.JSON)
						.body(createuserdetails)
						.when()
						.post(Endpoints.CREATE_DATA);
		return res;
	}
	public static Response updateuser() {
		
		UpdateUserPOJO updateuser = new UpdateUserPOJO();
		updateuser.setAccountno(getdataFromfile("accountno"));
		updateuser.setDepartmentno(getdataFromfile("newdepartmentno"));
		updateuser.setId((getdataFromfile("id")));
		updateuser.setUserid(getdataFromfile("userid"));
		
		Header header = new Header("token",getToken());
		Response res = RestAssured
					.given()
					.header(header)
					.contentType(ContentType.JSON)
					.body(updateuser)
					.when()
					.put(Endpoints.UPDATE_DATA);
		return res;
	}
	public static Response deleteuser() {
		DeleteUserPOJO deleteuser = new DeleteUserPOJO();
		deleteuser.setId(getdataFromfile("id"));
		deleteuser.setUserid(getdataFromfile("userid"));
		Header header = new Header("token",getToken());
		Response res = RestAssured
						.given()
						.header(header)
						.contentType(ContentType.JSON)
						.body(deleteuser)
						.when()
						.delete(Endpoints.DELETE_DATA);
		return res;
	}
}
