package qa.com.testcases;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import qa.com.base.BaseClass;
import qa.com.pages.HomePage;
import qa.com.pages.LoginPage;

public class HomePageTest extends BaseClass{
	
	LoginPage login;
	LoginTest logintest;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initialization();
		login=new LoginPage();
        homepage=login.clickonLoginPage(prop.getProperty("username"), prop.getProperty("password")); 
		homepage=new HomePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String title=homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		System.out.println("Homepage title is verified");
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void verifyCOGMentoLogoTest() throws InterruptedException {
		boolean logo=homepage.verifyCOGMENTO();
		Assert.assertTrue(logo);
		System.out.println("COGMentoLogo is verified");
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void verifyUserdispalyTest() throws InterruptedException {
		String username=homepage.verifyuserdisplay();
		System.out.println("the login username is:" +username);
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void verifyContactStreamTest() {
		String contactstream=homepage.verifyContactStream();
		System.out.println("the contactstream name is:"+ contactstream);
		
		if(!contactstream.isEmpty()) {
			String text=homepage.verifyTextOnContactStream();
			System.out.println("the value of text is:" +text);
		}
	}
	
	@Test(priority=5)
	public void verifyDealsTest() {
		String deals=homepage.verifyDeals();
		System.out.println("the deals name is:" + deals);
		
		if(!deals.isEmpty()) {
			String dealstext=homepage.verifyDealsText();
			System.out.println("the value of text is:"+ dealstext);
		}
	}
	
	@Test(priority=6)
	public void verifyMenuItemsInHomePageTest() throws InterruptedException {
		List<WebElement> items=homepage.verifyMenuIteminHomePage();
		int size=items.size();
		System.out.println("the menu items are:" + size);
		
		System.out.println("====the itmes present in HomePage are:===");
		for(int i=0;i<size;i++) {
			String value=items.get(i).getText();
			System.out.println(value);
			
		}
		Thread.sleep(3000);
	}
	
	/*@Test(priority=7)
	public void clickonContactPageItemTest() {
		WebElement contactpage=homepage.clickOnContactPageItem();
		contactpage.click();
	}*/

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
}
