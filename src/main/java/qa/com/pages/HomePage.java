package qa.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import qa.com.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String verifyHomePageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public boolean verifyCOGMENTO() {
		WebElement logo=driver.findElement(By.xpath(prop.getProperty("COGMento_xpath")));
		boolean COGlogo=logo.isDisplayed();
		return COGlogo;
	}
	
	public String verifyuserdisplay() {
		WebElement userdis=driver.findElement(By.xpath(prop.getProperty("Userdisplay_xpath")));
		String username=userdis.getText();
		return username;
	}
	
	
	public String verifyContactStream() {
		WebElement contactstream=driver.findElement(By.xpath(prop.getProperty("ContactStream_xpath")));
		String contactStream=contactstream.getText();
		return contactStream;
	}
	
   public String verifyTextOnContactStream() {
	   WebElement ContactText= driver.findElement(By.xpath(prop.getProperty("ContactStream_Text_xpath")));
	   String text=ContactText.getText();
	   return text;
   }
   
   public String verifyDeals() {
	   WebElement deals=driver.findElement(By.xpath(prop.getProperty("DealsContent_xpath")));
	   String dealsname=deals.getText();
	   return dealsname;
   }
   
   public String verifyDealsText() {
	   WebElement dealstxt=driver.findElement(By.xpath(prop.getProperty("DealsContent_Text_xpath")));
	   String dealstext=dealstxt.getText();
	   return dealstext;
   }
   
   public List<WebElement> verifyMenuIteminHomePage() {
	   List<WebElement> items=driver.findElements(By.xpath(prop.getProperty("menuItem_xpath")));
	   return items;
	   
   }
   
   public WebElement clickOnContactPageItem() {
	   WebElement contactpage=driver.findElement(By.xpath(prop.getProperty("ContactPageItem_xpath")));
	   return contactpage;
   }
}
