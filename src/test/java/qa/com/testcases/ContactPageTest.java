package qa.com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import qa.com.base.BaseClass;
import qa.com.pages.ContactPage;
import qa.com.pages.LoginPage;
import qa.com.util.Utils;



public class ContactPageTest extends BaseClass {
	
	LoginPage login;
	ContactPage contactpage;

	
	String Sheetname="Sheet1";
	
	public ContactPageTest() {
		super();
	}
	
    @BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		login=new LoginPage();
		login.clickonLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		contactpage=new ContactPage();
		WebElement cntpage=contactpage.clickOnContactPageItem();
		cntpage.click();
		Thread.sleep(3000);
	}
    

   /* @Test(priority=1)
	public void verifyContactPageTitleTest() {
		String title=contactpage.verifyContactPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		System.out.println("title is verified");
	}
    
    @Test(priority=2)
    public void verifyContactPageHeadingTest() {
    	boolean headinng=contactpage.verifyContactPageHeading();
    	Assert.assertTrue(true);
    	System.out.println("heading is matched");
    }
    
    @Test(priority=3)
    public void verifyDataInContactTableTest() throws InterruptedException {
    	
    	contactpage.verifyDataInTable();
    	
    }	*/
    
    @DataProvider
    public Object getSheetData() {
    	Object[][] data=Utils.getReadData(Sheetname);
    	return data;
    }
    
    @Test(priority=4,dataProvider="getSheetData")
    public void enterDetailsTest(String FirstName,String LastName,String Category,String Status,String Source) throws InterruptedException {
    	contactpage.verifydatatable(FirstName, LastName,Category, Status,Source);
    	Thread.sleep(3000);
    }
    
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
    
    
    
	
}
