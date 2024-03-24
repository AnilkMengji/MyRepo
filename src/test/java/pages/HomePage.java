package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase {
	
	
	
	By SearchField =By.xpath("//input[@id='twotabsearchtextbox']");
	
	
	private String ExpectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	//private String SearchField = "";

	public void GetTitle() {
	
		String ActualTitle =	driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);	
}
	

	
	
	public void enterSearchCriteria (String String){
		
		driver.findElement(SearchField).sendKeys(String);	
    }
		
	public void PressEnterBtn() {
		driver.findElement(SearchField).sendKeys(Keys.ENTER);
		
	}
	
	
		
		
		
	}
	
	

