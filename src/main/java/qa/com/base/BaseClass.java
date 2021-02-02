package qa.com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		
		try {
			FileInputStream file=new FileInputStream("C:\\Users\\pammi.rani\\eclipse-workspace\\MavenTest\\src\\main\\java\\qa\\com\\config\\config.properties");
			prop=new Properties();
			prop.load(file);
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pammi.rani\\Automation-Workspace\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			//System.setProperty("webdriver.gecko.driver", browser)
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}		
		
	


