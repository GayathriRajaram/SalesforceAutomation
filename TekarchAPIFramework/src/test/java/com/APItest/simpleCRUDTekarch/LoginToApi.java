package com.APItest.simpleCRUDTekarch;


import com.APItest.helper.ServiceHelper;

import io.restassured.response.Response;

public class LoginToApi extends ServiceHelper {
	
	public static void loginToApi() {
		
		Response lres= LoginTOApplication();
		getToken();
		System.out.println(getToken());
		int statuscode = getStatusCode(lres);
		verifystatuscode(lres,statuscode);
		String token=GetDataFromResponse(lres,"[0].token");
		String userid=GetDataFromResponse(lres,"[0].userid");
		System.out.println("token="+token);
		System.out.println("user id="+userid);
		Schemavalidation(lres,"loginschema.json");
		ResponsePrint(lres);
	}

	
}
