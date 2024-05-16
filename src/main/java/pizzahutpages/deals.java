package pizzahutpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.GenericUtilities;

public class deals extends GenericUtilities {

	public static WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div/span[2]")
	WebElement vegetarian;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]")
	WebElement pizza;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[1]/div[3]/div/button")
	WebElement addpizza;
	

	@FindBy(xpath = "//*[@id=\"basket\"]/div[3]/div/div[1]/div[1]")
	WebElement pizzainbasket;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/span[2]")
	WebElement pizzaprice;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div/span[2]")
	WebElement GST;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[3]/span[2]")
	WebElement checkoutprice;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[1]/span")
	WebElement checkoutitemcount;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span")
	WebElement checkoutpricecount;
	
	
	
	@FindBy(xpath = "//*[@id=\"basket\"]/div[@class='mb-20 px-20']")
	List<WebElement> verifyitemcount;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a")
	WebElement checkout;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[7]")
	WebElement drinksmenu;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[1]/div[3]/div/button")
	WebElement drink1;
	
	@FindBy(xpath = "//*[@id=\"basket\"]/div[3]/div/div[1]/button[2]")
	WebElement removepizza;
	
	

	
	public deals(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean vegetarianoff() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(vegetarian));
		boolean state= vegetarian.isSelected();
		return state;

	}

	public void clickPizza() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pizza));
		click(pizza);

	}

	public void addPizza() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addpizza));
		click(addpizza);
	}
	
	public String checkPizza() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pizzainbasket));
		String pizzaname=pizzainbasket.getText();
		return pizzaname;
	}
	
	public float validate_prize() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pizzaprice));
		
		float price1=Float.parseFloat((pizzaprice.getText()).substring(1));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(GST));
		float price2=Float.parseFloat((GST.getText()).substring(1));
		
		return (price1+price2);
	}
	
	public float checkout_prize() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(checkoutprice));
		
		float checkoutprice1=Float.parseFloat((checkoutprice.getText()).substring(1));
		return checkoutprice1;
	}
	
	public String checkoutItemCount()
	{
		String checkitemcount=checkoutitemcount.getText();
		return checkitemcount;
	}
	
	public String checkoutpriceCount()
	{
		String checkpricecount=checkoutpricecount.getText();
		return checkpricecount;
	}
	
	public void clickDrinksMenu() {

		click(drinksmenu);
	}

	public void clickDrinks() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(drink1));
		click(drink1);
		}
	
	public void removePizza() {

		click(removepizza);
	}
	
	public void clickCheckout() {

		click(checkout);

	}


	
}
