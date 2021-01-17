package qa.com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	WebDriver driver;
	  
	@BeforeTest
		public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pammi.rani\\Automation-Workspace\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		}
		
	    
		@Test(priority=0)
		public void verifytitle() {
			
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		System.out.println("title is verified");
		
	}
	
		
	     @Test(priority=1)
	     public void verifyGoogleSearch() {
	    	WebElement value= driver.findElement(By.xpath("(//input[@value=\"Google Search\"])[2]"));
	    	value.click();
	     }

	     @AfterTest
	     public void teardown() {
	    	 driver.quit();
	     }
	     
}
