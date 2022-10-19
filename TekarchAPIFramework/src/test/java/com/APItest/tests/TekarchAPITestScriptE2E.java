package com.APItest.tests;
import com.APItest.helper.ServiceHelper;
import com.APItest.models.GetDataPOJO;
import com.APItest.simpleCRUDTekarch.*;

import org.testng.annotations.*;

@Listeners(com.APItest.utils.Listerners_API.class)
public class TekarchAPITestScriptE2E extends ServiceHelper{
 
	@Test(priority = 1)
	public static void Tekarchlogin_testAPI() {
		
		LoginToApi.loginToApi();
	}
	@Test(priority = 2)
	public static void Tekarchgetdata_testAPI() {
		GetDataPOJO[] UserList = GetUserDataTest.getData();
		System.out.println("First user data is :"+ UserList[0].getAccountno()+"  , "+UserList[0].getId());
	}	
	@Test(priority = 3)
	public static void tekarchadd_testAPI()  {
		
	AddUserDataTest.createUserData();
	
	}
	@Test(priority = 4)
	public static void tekarchupdate_testAPI() {
		
		UpdateUserDataTest.updateUserData();
	}
	@Test(priority = 5)
	public static void tekarchdelete_testAPI() {
		
		DeleteUserDataTest.deleteUserData();
	}
	
}
