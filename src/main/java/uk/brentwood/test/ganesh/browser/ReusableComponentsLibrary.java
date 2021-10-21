package uk.brentwood.test.ganesh.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

import java.util.List;
/**
 * 
 * @author ganesh
 *
 */
public class ReusableComponentsLibrary {

   protected WebDriver driver;
   protected Scenario scenario;
    public ReusableComponentsLibrary(DriverManager manager){
        this.driver = manager.getDriver();
    }

    public WebElement findWebElementOncePresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findWebElementsOncePresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
   
    
}
