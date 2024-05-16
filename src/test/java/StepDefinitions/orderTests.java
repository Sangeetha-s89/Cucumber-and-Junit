package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.*;


import Utils.GenericUtilities;
import pizzahutpages.*;

public class orderTests {
	public GenericUtilities genUtil;
	public WebDriverWait wait;
	home hm = new home(GenericUtilities.getDriver());
	deals d = new deals(GenericUtilities.getDriver());
	String text;
	float checkoutprice1;
	float checkoutprice2;

	@Given("User launch Pizzahut application with {string}")
	public void launchURL(String url) throws IOException {
		GenericUtilities.navigateTo(url);
	}

	@And("User see pop up for delivery asking for enter location")
	public void location() {

		hm.checkVisibility();

	}

	@Then("User type address as {string}")
	public void screen(String Location) {
		hm.enterLocation(Location);

	}

	@And("User select first auto populate drop down option")
	public void autopopulate() {
		hm.selectLocation();

	}

	@When("User navigate to details page")
	public void detailspage() {
		hm.confirmLocation();
		try {
			hm.selectTime();
		} catch (Exception e) {
		} finally {
			wait = new WebDriverWait(GenericUtilities.getDriver(), Duration.ofSeconds(50));
			wait.until(ExpectedConditions.titleContains("Deals"));
			text = GenericUtilities.getDriver().getCurrentUrl();
			assertTrue("Error User not in 'Deals' screen", text.contains("deals"));
		}

	}

	@Then("User validate vegetarian radio button flag is off")
	public void vegetarianoff() {
		boolean flag = d.vegetarianoff();
		assertTrue("Vegeterian radio is ON", flag == false);

	}

	@And("User clicks on Pizzas menu bar option")
	public void clickPizza() {
		d.clickPizza();

	}

	@When("User select add button of any pizza from Recommended")
	public void addPizza() {
		d.addPizza();

	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void verifybasket() {
		text = d.checkPizza();
		assertTrue("Pizza not added", text.contains("Personal Margherita"));

	}

	@And("User validate pizza price plus Tax is checkout price")
	public void checkoutprice() {
		float finalprice = d.validate_prize();
		checkoutprice1 = d.checkout_prize();
		assertTrue("incorrect price at checkout", finalprice == checkoutprice1);

	}

	@Then("User validate checkout button contains Item count")
	public void validatecount() {
		String itemcount = d.checkoutItemCount();
		assertTrue("Checkout item count", itemcount.equals("1 item"));

	}

	@And("User validate checkout button contains total price count")
	public void checkoutpricecount() {
		String pricecount = d.checkoutpriceCount();
		assertTrue("Checkout price count", pricecount.equals("₹145.96"));

	}

	@Then("User clicks on Drinks option")
	public void clickDrinks() {
		d.clickDrinksMenu();

	}

	@And("User select Pepsi option to add into the Basket")
	public void selectpepsi() {
		d.clickDrinks();

	}

	@Then("User see 2 items are showing under checkout button")
	public void countas2() {
		String itemcount = d.checkoutItemCount();
		assertTrue("Checkout item count", itemcount.equals("2 items"));

	}

	@And("User see total price is now more than before")
	public void validatetotalprice() {
		checkoutprice2 = d.checkout_prize();
		assertTrue("incorrect price at checkout", checkoutprice2 > checkoutprice1);

	}

	@Then("User remove the Pizza item from Basket")
	public void removePizza() {
		d.removePizza();

	}

	@And("see Price tag got removed from the checkout button")
	public void pricetagremoved() {
		String pricecount = d.checkoutpriceCount();
		assertTrue("Checkout price count", pricecount.equals("₹59.86"));

	}

	@And("User see 1 item showing in checkout button")
	public void oneitem() {
		String itemcount = d.checkoutItemCount();
		assertTrue("Checkout item count", itemcount.equals("1 item"));

	}

	@Then("User Clicks on Checkout button")
	public void clickCheckout() {
		d.clickCheckout();

	}

	@And("User see minimum order required pop up is getting displayed")
	public void viewpopup() {
		
		text = GenericUtilities.getDriver().getCurrentUrl();
		assertTrue("Error User not in 'checkout' screen",text.contains("checkout"));
		

	}

}
