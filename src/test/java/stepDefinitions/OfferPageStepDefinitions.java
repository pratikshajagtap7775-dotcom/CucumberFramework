package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

public class OfferPageStepDefinitions {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetUp testContextSetUp;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinitions(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp = testContextSetUp;
	}
	
	@Then("^User searched for (.+) shortname on offers page$")
	public void user_searched_for_same_shortname_on_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
	    
		switchToOffersPage();
		OffersPage offersPage = testContextSetUp.pageObjectManager.OffersPage();
		offersPage.searchItem(shortName);
	    Thread.sleep(2000);
	    offerPageProductName = offersPage.getProductName();
	    
	}
	
	public void switchToOffersPage()
	{
		//if(testContextSetUp.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/"));
		LandingPage landingPage = testContextSetUp.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetUp.genericUtils.SwitchWindowToChild();
	    
	}
	
	@Then("Validate product name in offers page matches with landing page")
		public void validate_product_name_in_offers_page() {
		
		System.out.println(offerPageProductName + testContextSetUp.landingPageProductName);
		
		Assert.assertEquals(offerPageProductName, testContextSetUp.landingPageProductName);
		
	}
	
	
	

}
