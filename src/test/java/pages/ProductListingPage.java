package pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class ProductListingPage extends TestBase {
	
	
public 	ProductListingPage(final WebDriver driver) {
	
	this.driver= driver;
	
	PageFactory.initElements(driver, this);

}	


private String ActlpgTitle = "//span[@id='productTitle']";
private String Prdtitle ="//span[@id='productTitle']";
private String Prdctprc ="#corePriceDisplay_desktop_feature_div > div.a-section.a-spacing-none.aok-align-center.aok-relative > span.a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay > span:nth-child(2) > span.a-price-whole";
private String AddtoCart = "//*[@title='Add to Shopping Cart']";
private String NavEle = "(//span[@class='a-price-whole'])[1]";
private String subttl ="//span[@id='sc-subtotal-amount-buybox']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']";


	@FindBy(css = "#title")
	private WebElement ProductTitle;
	
	//@FindBy(css = "#title")
//	@CacheLookup
//	private WebElement ActlpgTitle;
	
//	@FindBy(css ="//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[3]")
//	private String Prdctprc;
	
	@FindBy(xpath="//*[@title='Add to Shopping Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath ="//*[@class='a-button a-button-span11 a-button-base a-button-small']")
	private WebElement GotoCart;
	
	@FindBy(css ="#vatMessage_feature_div > span")
	private WebElement Offers;
	
	@FindBy(css ="#attach-desktop-sideSheet")
	private WebElement confirmbox;
	
	@FindBy(xpath="//span[@id='sc-subtotal-amount-buybox']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	private WebElement sbttl;
	
	@FindBy(css="#a-autoid-0-announce")
	private WebElement SideSheet;


	
	public void ListofProducts() {

		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    	if(products.size() != 0) 
 	   {
		
		System.out.println(" Products Found" +products.size());		
	
}

	}
	
	public void Click_on_FirstProduct () {		
		
		
		List<WebElement> products1 = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		products1.get(0).click();
		System.out.println("Successfully clicked on an Item");
		
		String windowHandle = driver.getWindowHandle();
    	//Get the list of window handles
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
    	System.out.println(tabs.size());
    	//Use the list of window handles to switch between windows
    	driver.switchTo().window((String) tabs.get(1));
	
	}
	
	
	@SuppressWarnings("unchecked")
	public void  Verify_PLP_price() {
		
		

		String title = driver.getCurrentUrl();
    	
    	String ProductTitle= driver.findElement(By.xpath(Prdtitle)).getText();
    	
    	System.out.println(ProductTitle);
    	
    	System.out.println(title);
    	
    	String ActualPageTitle= driver.findElement(By.xpath(ActlpgTitle)).getText();
    	
    	Assert.assertEquals(ProductTitle,ActualPageTitle );
 	
    	String Productprice = driver.findElement(By.cssSelector(Prdctprc)).getText();
 
    	System.out.println("The Product Price is :"+Productprice);
		
	}

	public void addToCart(String ActualPageTitle) {
		
		
		WebElement scroll = driver.findElement(By.xpath(NavEle));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", scroll);
    	
    
    	driver.findElement(By.xpath(AddtoCart)).click();
    	
    	//	this.addToCart.click();
    	
    	//this code is for sideview- Add to cart
    	
    	if(ActualPageTitle.contains("BenQ")|| ActualPageTitle.contains("Lenovo L-Series")||ActualPageTitle.contains("Samsung 24-Inc")||ActualPageTitle.contains("ZEBRONICS Zeb")){
			this.SideSheet.click();
	    	String Subtotal = this.sbttl.getText();
	    	System.out.println("The Subtotal is : "+Subtotal);		
		}else {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#attach-close_sideSheet-link")));
	
	
	driver.findElement(By.cssSelector("#attach-close_sideSheet-link")).click();
	
	
	WebDriverWait waitele = new WebDriverWait(driver, 30);
	WebElement elementele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-cart-icon nav-sprite']")));
	
	
	
	Actions act = new Actions(driver);

	//Double click on element
	WebElement ele = driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")); 
	act.doubleClick(ele).perform();
	
		}
    	
    	
	}
		public void Verify_Sub_total(String Productprice) {
		
			String Subtotal = driver.findElement(By.xpath(subttl)).getText();
	
			System.out.println("The Subtotal is : "+Subtotal);

			
		
		}

}

   
    	
    	

