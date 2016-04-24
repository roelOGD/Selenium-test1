package Test1.Test1;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.FsResourceLocator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bsh.StringUtil;
import junit.framework.Assert;

public class LoginTest {
	
	public WebDriver driver;
	FacebookMainPage fMainPage;
	FacebookLoginPage fbLoginPage;
	
	@BeforeClass(alwaysRun = true)
	public void setup(){
		this.driver = new FirefoxDriver();
		fMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		//this.driver.quit();		
	}
	
	@Test(groups={"p1", "pageLoads"})
	public void loadPage(){
		driver.get(fMainPage.PAGE_URL);
	}
	
	@Test(groups={"p2", "field"}, dependsOnMethods="loadPage")
	public void filloutEmailFId(){
		fMainPage.setText_EmailLogin("r_den_blanken@hotmail.com");
	}
	
	@Test(groups={"p2", "field"}, dependsOnMethods="filloutEmailFId")
	public void filloutPassFId(){
		fMainPage.setText_PasswordLogin("123456");
	}
	
	@Test(groups={"p1"}, dataProviderClass = FacebookData.class, dataProvider = "login")
	public void testLoginMainpage(String email, String password, String errorType){
		driver.get(fMainPage.PAGE_URL);
		Assert.assertEquals(driver.getTitle(), fMainPage.PAGE_TITLE);
		System.out.println("dit was de titel: " + driver.getTitle());
		fMainPage.setText_EmailLogin(email);
		fMainPage.setText_PasswordLogin(password);
		fMainPage.clickLogin();
		
		if(StringUtils.isBlank(errorType)){
			boolean result = fbLoginPage.checkErrorHeader(errorType);
			Assert.assertEquals(result, ("Expected error: " +errorType));
		}else{
			Assert.assertEquals(driver.getTitle(), "Facebook");
		}
	}	
}
