package uk.brentwood.test.ganesh.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import uk.brentwood.test.ganesh.browser.DriverManager;
import uk.brentwood.test.ganesh.browser.ReusableComponentsLibrary;

/**
 * 
 * @author ganesh
 * @version 1.0
 *
 */
public class ShopPage extends ReusableComponentsLibrary {

	public ShopPage(DriverManager manager) {
		super(manager);
	}

	/**
	 * this method adds items to wish list one by one when browser is rendered with shop page
	 * 
	 * @param numberOfProductTobeAdded this is count represent number of items to be added (for current
	 *                                 testcase it is 4)
	 * @return A list of products which are added to wish list
	 */
	public Map<String, String> addItemsToWishList(int numberOfProductTobeAdded) {

		Map<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <= numberOfProductTobeAdded; i++) {
			WebElement productNameElement = findWebElementOncePresent(
					By.xpath("(//li[contains(@class,'product type-product')])[" + i + "]//h2"));
			List<WebElement> productPricesElementList = findWebElementsOncePresent(
					By.xpath("(//li[contains(@class,'product type-product')])[" + i + "]//bdi"));
			map.put(productNameElement.getText(), productPricesElementList.get(1).getText());
			WebElement addToWishList = findWebElementOncePresent(By.xpath(
					"(//li[contains(@class,'product type-product')])[" + i + "]//span[text()='Add to wishlist']"));
			addToWishList.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	/**
	 * this method goes to wish list by clicking the link after adding products to wish list F
	 * 
	 */
	public void goToWishList() {
		findWebElementOncePresent(By.xpath("(//*[@class='header-wishlist'])[1]//a")).click();
	}

}
