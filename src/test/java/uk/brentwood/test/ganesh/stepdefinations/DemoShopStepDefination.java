package uk.brentwood.test.ganesh.stepdefinations;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.brentwood.test.ganesh.browser.DriverManager;
import uk.brentwood.test.ganesh.browser.ReusableComponentsLibrary;
import uk.brentwood.test.ganesh.pages.CartPage;
import uk.brentwood.test.ganesh.pages.HomePage;
import uk.brentwood.test.ganesh.pages.ShopPage;
import uk.brentwood.test.ganesh.pages.WishListPage;

/**
 * 
 * @author ganesh
 * @version 1.0 This is Step definition class for Demo stop web sites
 */
public class DemoShopStepDefination extends ReusableComponentsLibrary {

	DriverManager driverManager;
	HomePage homePage;
	ShopPage shopPage;
	CartPage cartPage;
	WishListPage wishListPage;

	// stores products added to wishlist
	private Map<String, String> productWishList = new HashMap<String, String>();
	private Entry<String, String> lowestPriceProductEntry;

	public DemoShopStepDefination(DriverManager driverManager) {
		super(driverManager);
		this.driverManager = driverManager;
	}

	/**
	 * adds four different products to wish list
	 */
	@Given("I add four different products to my wish list")
	public void addFourDifferentProductToMyWishList() {
		driver.get("https://testscriptdemo.com/");
		homePage = new HomePage(driverManager);
		shopPage = new ShopPage(driverManager);
		cartPage = new CartPage(driverManager);
		wishListPage = new WishListPage(driverManager);
		takeScreenshot();

		homePage.clickOnShop();
		takeScreenshot();

		homePage.closeCookieBannerIfPresent();

		productWishList = shopPage.addItemsToWishList(4);
		takeScreenshot();
	}

	@When("I view my wishlist table")
	public void viewMyWishListTable() {
		shopPage.goToWishList();
		takeScreenshot();
	}

	@Then("I find total four selected items in my Wishlist")
	public void findTotalFourSelectedItemsInWishList() {
		wishListPage.verifyWishListItems(productWishList, 4);
		takeScreenshot();
	}

	@When("I search for lowest price product")
	public void searchForLowestPriceProduct() {
		lowestPriceProductEntry = wishListPage.searchForLowestPriceProduct(productWishList);
		takeScreenshot();
	}

	@And("I am able to add the lowest price item to my cart")
	public void addTheLowestPriceItemToMyCart() {
		wishListPage.addTheLowestPriceItemToMyCart(lowestPriceProductEntry);
		takeScreenshot();
	}

	@Then("I am able to verify the item in my cart")
	public void verifyItemInMyCart() {
		wishListPage.goToCartPage();
		cartPage.verifyItemInMyCart(lowestPriceProductEntry);
		takeScreenshot();
	}

	public void takeScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", "");
	}

	@After
	public void closeDriver() {
		driver.quit();
	}

	@Before
	public void setUpScenario(Scenario scenario) {
		this.scenario = scenario;
	}
}
