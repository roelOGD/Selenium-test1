package Test1.Test1;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage {
	
	public static final String PAGE_TITLE = "Facebook";
	public static final String PAGE_URL = "http://www.facebook.com/login.php";
	
	@FindBy(css=".pam.login_error_box.uiBoxRed>div:first-child") WebElement errorHeader;
	public boolean checkErrorHeader(String text){
		try {
			return errorHeader.equals(text);
		}catch(NoSuchElementException e){
			return false;
		}
	}
}
