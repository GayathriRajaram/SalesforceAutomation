package com.APItest.simpleCRUDTekarch;


import com.APItest.helper.ServiceHelper;

import io.restassured.response.Response;

public class DeleteUserDataTest extends ServiceHelper {
	
	public static void deleteUserData()  {
		Response Dres = deleteuser();
		ResponsePrint(Dres);
		int statuscode = getStatusCode(Dres);
		verifystatuscode(Dres,statuscode);
		validate_equal(Dres,"status","success");
		
		
	}

}
