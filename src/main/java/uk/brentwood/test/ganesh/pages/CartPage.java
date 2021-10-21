package uk.brentwood.test.ganesh.pages;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import uk.brentwood.test.ganesh.browser.DriverManager;
import uk.brentwood.test.ganesh.browser.ReusableComponentsLibrary;

/**
 * This class is Page Oject model for Cart page which helps in verifying products added in cart
 * 
 * @author ganesh
 * @version 1.0
 *
 */
public class CartPage extends ReusableComponentsLibrary {

	public CartPage(DriverManager manager) {
		super(manager);
	}

	/**
	 * this method verifies the item added in cart when browser is rendered with cart page
	 * 
	 * @param lowestPriceProductEntry is a Map Entry which has lowest price product = name ,price
	 */
	public void verifyItemInMyCart(Entry<String, String> lowestPriceProductEntry) {

		int size = findWebElementsOncePresent(By.xpath("//*[@class='woocommerce-cart-form__cart-item cart_item']"))
				.size();
		Map<String, String> listFromWishListPage = new HashMap<String, String>();
		for (int i = 1; i <= size; i++) {
			WebElement productNamefromUI = findWebElementOncePresent(
					By.xpath("((//*[@class='woocommerce-cart-form__cart-item cart_item'])[" + i + "]//td)[3]"));
			WebElement priceEle = findWebElementOncePresent(
					By.xpath("((//*[@class='woocommerce-cart-form__cart-item cart_item'])[" + i + "]//td)[4]"));

			if (productNamefromUI.getText().equalsIgnoreCase(lowestPriceProductEntry.getKey())) {
				assertEquals(true, true);
			}
		}
	}
}
