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

public class LandingPageStepDefinitions {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetUp testContextSetUp;
	LandingPage landingPage;
	
	public LandingPageStepDefinitions(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp=testContextSetUp;
		this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
	}
	
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetUp.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetUp.landingPageProductName +" is extracted from homepage");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	

}
