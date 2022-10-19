package com.APItest.simpleCRUDTekarch;

import java.util.List;

import com.APItest.helper.*;
import com.APItest.models.GetDataPOJO;

import io.restassured.response.Response;

public class GetUserDataTest extends ServiceHelper {
	public static GetDataPOJO[] getData() {
		Response Gres = getuser();
		GetDataPOJO[] GList = Gres.as(GetDataPOJO[].class);
		System.out.println(GList);
		ResponsePrint(Gres);
		int statuscode = getStatusCode(Gres);
		verifystatuscode(Gres,statuscode);
		String userid = GetDataFromResponse(Gres,"[0].userid");
		String id = GetDataFromResponse(Gres,"[0].id");
		String acno = GetDataFromResponse(Gres,"[0].accountno");
		String salary = GetDataFromResponse(Gres,"[0].salary");
		String deptnum = GetDataFromResponse(Gres,"[0].departmentno");
		System.out.println("First user details are : "+ userid +" , "+id+" , "+ acno+" , "+salary);
		validate_equal(Gres,"[0].departmentno",deptnum);
		return GList;
	}

}
