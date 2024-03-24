package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

	public static WebDriver driver;
	
	
	@BeforeMethod 
	public void Setup() throws FileNotFoundException {
	
		FileInputStream fi = new FileInputStream("C:\\Users\\HOME\\eclipse-workspace\\myworkspace\\Assessment\\src\\test\\resources\\config\\config.properties");
		Properties prop = new Properties();
		try {
			prop.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browser = prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\eclipse-workspace\\myworkspace\\Assessment\\src\\test\\resources\\features\\chromedriver.exe");
		
		driver= new ChromeDriver();
	
		String url = prop.getProperty("url");
	
		driver.get(url);
		driver.manage().window().maximize();
		
	
	}else if(browser.equalsIgnoreCase("ff")) {
		
		System.setProperty("webdriver.gecko.driver", "");
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
		
	}
	
}
