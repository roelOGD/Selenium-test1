package Test1.Test1;

import org.testng.annotations.DataProvider;

public class FacebookData {

	@DataProvider(name = "login")
	public static Object[][] login(){
		return new Object[][] {
			{"test@hotmail.com","test", null},
			{"", "123456", "isError"}
		};
	}
}
