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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;

public class CheckoutPageStepDefinitions {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetUp testContextSetUp;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinitions(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp=testContextSetUp;
		checkoutPage = testContextSetUp.pageObjectManager.getCheckoutPage();
	}
	
	@Then("Verify user has ability to enter promo code and place order")
	public void Verify_user_has_ability_to_enter_promo_code()
	{
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	}
	
	@Then("^User proceed to checkout and validate the (.+) items in checkout page$")
	public void user_proceed_to_checkout(String name)
	{
		checkoutPage.checkoutItems();
	}

}
