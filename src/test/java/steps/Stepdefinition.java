package steps;

import java.io.FileNotFoundException;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductListingPage;

public class Stepdefinition extends TestBase{


	TestBase base = new TestBase();
	HomePage home = new HomePage();
	ProductListingPage plp = new ProductListingPage(driver);
	

	
	
	@Given("the user navigates to Amazon India Portal")
	public void the_user_navigates_to_amazon_india_portal()  throws FileNotFoundException {
	
		base.Setup();	
	}
	@Then("Verify the title of the Home Page")
	public void verify_the_title_of_the_home_page() {
		home.GetTitle();
	}

	@When("I type {string} in the Search field and press Enter")
	//public void i_type_in_the_search_field_and_press_enter(String string) {
		public void SearchPrd(String string) {
		home.enterSearchCriteria(string);
		home.PressEnterBtn();
		}
	

	@Then("List of searched product  should be displayed")
	public void list_of_searched_product_should_be_displayed() {
	    
		plp.ListofProducts();
		
		
	}

	@Then("I select the first item")
	public void i_select_the_first_item()  {
	    plp.Click_on_FirstProduct();
	}

	@Then("I add the item to the cart by clicking on Add to Cart")
	public void i_add_the_item_to_the_cart_by_clicking_on_add_to_cart() {
	  
	plp.Verify_PLP_price();
	plp.addToCart("");
	
	
	}

	@Then("Verify the sub-total")
	public void verify_the_sub_total() {
			
	System.out.println("test");	
	}


}

