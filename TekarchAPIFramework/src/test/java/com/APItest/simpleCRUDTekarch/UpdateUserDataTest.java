package com.APItest.simpleCRUDTekarch;


import com.APItest.helper.ServiceHelper;

import io.restassured.response.Response;

public class UpdateUserDataTest extends ServiceHelper {
	public static void updateUserData() {
		Response Ures = updateuser();
		ResponsePrint(Ures);
		int statuscode = getStatusCode(Ures);
		verifystatuscode(Ures,statuscode);
		validate_equal(Ures,"status","success");
		
	}
}
