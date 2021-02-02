package qa.com.testcases;

import org.testng.Assert;
import org.testng.annotations.*;


import qa.com.base.BaseClass;
import qa.com.pages.HomePage;
import qa.com.pages.LoginPage;

public class LoginTest extends BaseClass{

	LoginPage login;
	HomePage homepage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login=new LoginPage();
		homepage=new HomePage();
	}
	
	@Test(priority=1)
	public void verifyFreeCRMLogoTest() {
		boolean logo=login.verifyFreeCRMLogo();
		Assert.assertTrue(logo);	
		System.out.println("logo is verified");
	}
	
	@Test(priority=2)
	public void clickonLoginPageTest() {
		homepage=login.clickonLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login page is clicked");
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
