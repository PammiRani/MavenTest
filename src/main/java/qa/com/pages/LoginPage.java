package qa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFreeCRMLogo() {
		WebElement freecrm=driver.findElement(By.xpath(prop.getProperty("freecmlogo_xpath")));
		boolean logo=freecrm.isDisplayed();
		return logo;
	}

	
	public HomePage clickonLoginPage(String usern,String pwd) {
		WebElement email=driver.findElement(By.xpath(prop.getProperty("login_xpath")));
		email.click();
		
		WebElement user=driver.findElement(By.xpath(prop.getProperty("username_xpath")));
		user.sendKeys(usern);

		WebElement pass=driver.findElement(By.xpath(prop.getProperty("password_xapth")));
		pass.sendKeys(pwd);
		
		WebElement loginbtn=driver.findElement(By.xpath(prop.getProperty("loginbtn_xpath")));
		loginbtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
}
