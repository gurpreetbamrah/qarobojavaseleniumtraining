package chapter4_seleniummethods.website_demo;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * If you don't mention the priority, it will take all the test cases as "priority=0"
 * Elements Gets Cached Always Clear Cookie Before Executing the test  case
 */

public class SeleniumMethods {

    static WebDriver driver = null;


    public void initDriver() {
        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }


    public void getURl() {
        // This method used to open browser
        driver.get("https://www.snapdeal.com/");
    }


    public static void main(String[] args) throws InterruptedException {
        SeleniumMethods seleniumMethods = new SeleniumMethods();
        seleniumMethods.initDriver();
        seleniumMethods.maximizeWindow();
        seleniumMethods.getURl();
        seleniumMethods.navigateTo();
        seleniumMethods.enterText();
        seleniumMethods.clearText();
        seleniumMethods.enterText();
        //  seleniumMethods.clickElement();
        seleniumMethods.clickElementUsingJavaScript();

        seleniumMethods.closeBrowser();

    }





    public void maximizeWindow() {
        driver.manage().window().maximize();
    }


    public void navigateTo() {
        driver.navigate().to("https://www.snapdeal.com/products/digital-entertainment?sort=plrty");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
    }

    public void enterText() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.id("inputValEnter"));
        searchTextBox.sendKeys("Watch");
        Thread.sleep(5000);
    }


    public void closeBrowser() {
        driver.close();
    }


    public void clearText() throws InterruptedException {
        driver.findElement(By.id("inputValEnter")).clear();
        Thread.sleep(5000);
    }

    public void clickElement() {
        driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
    }

    public void clickElementUsingJavaScript() {
        WebElement element = driver.findElement(By.xpath("//span[@class='searchTextSpan']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

//
//    @org.junit.Test
//    public void HandlePopUP() throws InterruptedException {
//
//        driver.get("http://www.rediff.com/");
//        String parentWindow = driver.getWindowHandle();
//
//
//
//        Set<String> handles =  driver.getWindowHandles();
//        for(String windowHandle  : handles)
//        {
//            if(!windowHandle.equals(parentWindow))
//            {
//                driver.switchTo().window(windowHandle);
//                driver.close(); //closing child window
//                driver.switchTo().window(parentWindow); //cntrl to parent window
//            }
//        }
//        driver.close();
//        driver.quit();
//    }


    //  JavascriptExecutor jse = (JavascriptExecutor) driver;
//    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    //  jse.executeScript("scroll(0,300)");


}