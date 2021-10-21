package uk.brentwood.test.ganesh.pages;

import static org.testng.Assert.assertEquals;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import uk.brentwood.test.ganesh.browser.DriverManager;
import uk.brentwood.test.ganesh.browser.ReusableComponentsLibrary;
import uk.brentwood.test.ganesh.utilities.CurrencyHandler;

public class WishListPage extends ReusableComponentsLibrary {

	public WishListPage(DriverManager manager) {
		super(manager);
	}

	/**
	 * this method verifies total 4 items added to wish list one by one when browser is rendered with
	 * Wish page
	 * 
	 * @param productsFromShopPage  product list added on shop page
	 * @param numberOfAddedProducts number of products to be verified
	 */
	public void verifyWishListItems(Map<String, String> productsFromShopPage, int numberOfAddedProducts) {

		int size = findWebElementsOncePresent(By.xpath("//tbody[@class='wishlist-items-wrapper']//tr")).size();
		assertEquals(numberOfAddedProducts, size);

		Map<String, String> productsFromWishListPage = new HashMap<String, String>();
		for (int i = 1; i <= numberOfAddedProducts; i++) {
			WebElement productNameElement = findWebElementsOncePresent(
					By.xpath("(//tbody[@class='wishlist-items-wrapper']//tr)[" + i + "]//td")).get(2);
			WebElement productPriceElement = findWebElementOncePresent(
					By.xpath("(((//tbody[@class='wishlist-items-wrapper']//tr)[" + i + "]//td)[4]//bdi)[2]"));
			;
			productsFromWishListPage.put(productNameElement.getText(), productPriceElement.getText());
		}

		// verify all added items to wish list on Shop page are present on wishlist page
		for (String productName : productsFromShopPage.keySet()) {
			assertEquals(true, productsFromWishListPage.containsKey(productName));
			System.out.println("Verified added product on wishlist ProductName:" + productName + " Price:"
					+ productsFromWishListPage.get(productName));

		}

	}

	/**
	 * this method helps in searching lowest price product by fetching the product prices list by
	 * parsing price currency , sorting it in ascending order and fetching the lowest price product
	 * based on sorted list values
	 * 
	 * @param wishListMap products added to wish list
	 * @return
	 */
	public Entry<String, String> searchForLowestPriceProduct(Map<String, String> wishListMap) {

		// fetching all price values into list to sort in ascending order
		List<Double> listPrices = new ArrayList<Double>();
		for (Entry<String, String> entry : wishListMap.entrySet()) {
			double currencyValue = CurrencyHandler.parseCurrencyUK(entry.getValue());
			listPrices.add(currencyValue);

		}

		// sorting product price in ascending order using comparator lambda expression
		listPrices.sort((s1, s2) -> s1.compareTo(s2));

		// lowest price
		String lowestProdcutPrice = CurrencyHandler.formatCurrencyUK(listPrices.get(0));

		// fetching the product based on lowest price
		Entry<String, String> productEntry = null;
		for (Entry<String, String> entry : wishListMap.entrySet()) {
			if (entry.getValue().equalsIgnoreCase(lowestProdcutPrice)) {
				productEntry = entry;
				break;
			}
		}

		return productEntry;

	}

	/**
	 * adds the given product to cart
	 * 
	 * @param lowestPriceProductEntry Map Entry which has lowest price product
	 */
	public void addTheLowestPriceItemToMyCart(Entry<String, String> lowestPriceProductEntry) {
		int size = findWebElementsOncePresent(By.xpath("//tbody[@class='wishlist-items-wrapper']//tr")).size();
		Map<String, String> listFromWishListPage = new HashMap<String, String>();
		for (int i = 1; i <= size; i++) {
			WebElement productNameElementfromUI = findWebElementsOncePresent(
					By.xpath("(//tbody[@class='wishlist-items-wrapper']//tr)[" + i + "]//td")).get(2);
			WebElement addToCartElement = findWebElementOncePresent(
					By.xpath("((//tbody[@class='wishlist-items-wrapper']//tr)[" + i + "]//td)[6]//a"));

			if (productNameElementfromUI.getText().equalsIgnoreCase(lowestPriceProductEntry.getKey())) {
				addToCartElement.click();
				break;
			}
		}
		// wait for two seconds to make cart update
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * goes to cart from wish list page
	 */
	public void goToCartPage() {
		findWebElementOncePresent(By.xpath("(//*[@class='header-cart-inner'])[1]//a")).click();
	}

}
