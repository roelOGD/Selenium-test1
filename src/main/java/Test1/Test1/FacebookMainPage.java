package Test1.Test1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class FacebookMainPage {
	
	public static final String PAGE_TITLE = "Welkom bij Facebook - Meld je aan, registreer je of ontdek meer";
	public static final String PAGE_URL = "http://www.facebook.com";
	
	@FindBy(id="email")	WebElement field_emailLogin;	
	@FindBy(id="pass")	WebElement field_passwordLogin;
	@FindBy(id="loginbutton")	WebElement btn_login;
	
	WebDriver driver;
	public FacebookMainPage (WebDriver driver){
		this.driver = driver;		
	}
	
	public void setText_EmailLogin(String text){
		field_emailLogin.sendKeys(text);
		Assert.assertEquals(field_emailLogin.getAttribute("value"), text);
	}
	
	public void setText_PasswordLogin(String text){
		field_passwordLogin.sendKeys(text);
		Assert.assertEquals(field_passwordLogin.getAttribute("value"), text);
	}
	
	public void clickLogin(){
		btn_login.click();
	}
}
