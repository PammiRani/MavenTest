package qa.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import qa.com.base.BaseClass;

public class ContactPage extends BaseClass {
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
    public WebElement clickOnContactPageItem() {
		   WebElement contactpage=driver.findElement(By.xpath(prop.getProperty("ContactPageItem_xpath")));
		   return contactpage;
	   }
    
	public String verifyContactPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public boolean verifyContactPageHeading() {
		WebElement contacthead=driver.findElement(By.xpath(prop.getProperty("ContacttHead_xpath")));
		boolean headingname=contacthead.isDisplayed();
		return headingname;
	}
	
	public  void verifyDataInTable() throws InterruptedException {
		//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[1]/td[2]
		//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[3]/td[2]

		String beforexpath="//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[";
		String xpath="]/td[";
		String afterxpath="]";
		
		Thread.sleep(3000);
		int row=driver.findElements(By.xpath(prop.getProperty("row_xpath"))).size();
		int col=driver.findElements(By.xpath(prop.getProperty("col_xpath"))).size();
		
		System.out.println("the size of row is" + row);
		System.out.println("the size of col is"+ col);
	   // String completexpath = " ";
		
	    for(int r=1;r<=row;r++) {
			for(int c=1;c<=col;c++) {
				 String exactxpath=beforexpath + r + xpath + c + afterxpath;
				// System.out.println(exactxpath);
				String completexpath=driver.findElement(By.xpath(exactxpath)).getText(); 
				System.out.print(completexpath+ "|");
			}
			
				System.out.println(" ");
		}
		
	}
	
	
	public void verifydatatable(String fname,String lastn,String catgry,String Status,String Source) throws InterruptedException {
	
	WebElement newbtn=driver.findElement(By.xpath(prop.getProperty("newIcon_xpath")));
	newbtn.click();
	Thread.sleep(3000);
	WebElement firstname=driver.findElement(By.xpath(prop.getProperty("firstname_xpath")));
	firstname.sendKeys(fname);
	Thread.sleep(3000);
	WebElement lastname=driver.findElement(By.xpath(prop.getProperty("lastname_xpath")));
	lastname.sendKeys(lastn);
	Thread.sleep(3000);
/*	WebElement company=driver.findElement(By.xpath(prop.getProperty("companyname_xpath")));
	company.sendKeys(cmpny);
	Thread.sleep(3000);*/
	
	
	List<WebElement> options=driver.findElements(By.xpath(prop.getProperty("categorydrop_xpath")));
	for(int i=0;i<options.size();i++) {
		if(options.get(i).equals(catgry)) {
			options.get(i).click();
			Thread.sleep(3000);
		}
	}
	
	List<WebElement> options1=driver.findElements(By.xpath(prop.getProperty("statusdrop_xpath")));
	for(int i=0;i<options1.size();i++) {
		if(options1.get(i).equals(Status)) {
			options1.get(i).click();
			Thread.sleep(3000);
		}
	}
		
	List<WebElement> options2=driver.findElements(By.xpath(prop.getProperty("sourcename_xpath")));
	for(int i=0;i<options2.size();i++) {
		if(options2.get(i).equals(Source)) {
			options2.get(i).click();
			Thread.sleep(3000);
		}
	}
	
	WebElement savebtn=driver.findElement(By.xpath(prop.getProperty("savebtn_xpath")));
	savebtn.click();
	}
	
	

}
