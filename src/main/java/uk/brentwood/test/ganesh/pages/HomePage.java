package uk.brentwood.test.ganesh.pages;

import org.openqa.selenium.By;

import uk.brentwood.test.ganesh.browser.DriverManager;
import uk.brentwood.test.ganesh.browser.ReusableComponentsLibrary;

/**
 * 
 * @author ganesh
 * @version 1.0
 * This class is Page obect model for Home page 
 *
 */
public class HomePage extends ReusableComponentsLibrary {

	public HomePage(DriverManager manager) {
		super(manager);
	}

	/**
	 * this method clicks on shop link/tab when browser is rendered with home page
	 */
	public void clickOnShop() {
		findWebElementOncePresent(By.xpath("//li[@id='menu-item-310']//a[@title='Shop']")).click();
	}

	/**
	 * this method closes cookie banner if present  when browser is rendered with home page
	 */
	public void closeCookieBannerIfPresent() {
		try {
			findWebElementOncePresent(By.xpath("//*[@class='cc-btn cc-accept-all cc-btn-no-href']")).click();
		} catch (Exception e) {
			// do nothing if exception is thrown as the cookie banner is not appeared
		}
	}
}
