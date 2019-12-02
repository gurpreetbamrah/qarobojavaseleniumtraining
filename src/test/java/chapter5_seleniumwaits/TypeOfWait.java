package chapter5_seleniumwaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by gurpreet on 4/1/16.
 */


// There are two types pf Selenium Wait  :Explicit and Implicit Wait

//Explicit Wait
//This waits up to 10 seconds before throwing a TimeoutException or
// if it finds the element will return it in 0 - 10 seconds.
//WebDriverWait by default calls the ExpectedCondition every 500 milliseconds
// until it returns successfully. A successful return is for ExpectedCondition
// type is Boolean return true or not null return value for all other ExpectedCondition types


//Implicit Waits
  //      An implicit wait is to tell WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately available. The default setting is 0. Once set, the implicit wait is set for the life of the WebDriver object instance

public class TypeOfWait {


    WebDriver driver = new FirefoxDriver();

    public void explictWait() {
        driver.get("http://www.google.com");



        WebDriverWait wait = new WebDriverWait(driver, 10);
           WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        driver.close();


       // Element is Clickable - it is Displayed and Enabled.
        //WebDriverWait wait = new WebDriverWait(driver, 10);
      //  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));

    }


    public  void implicitWait(){


       // Why this does not work
        driver.get("http:www.google.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement myDynamicElement = driver.findElement(By.name("q"));
        driver.close();
    }
}