package com.APItest.simpleCRUDTekarch;

import com.APItest.helper.ServiceHelper;

import io.restassured.response.Response;

public class AddUserDataTest extends ServiceHelper {
	public static void createUserData() {
		Response Cres = createuser();
		Cres.prettyPrint();
		int statuscode = getStatusCode(Cres);
		verifystatuscode(Cres,statuscode);
		GetDataFromResponse(Cres,"status");
		validate_equal(Cres, "status", "success");
		
	}
}
