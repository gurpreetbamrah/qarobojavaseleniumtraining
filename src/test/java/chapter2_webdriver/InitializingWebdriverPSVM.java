package chapter2_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializingWebdriverPSVM {

    static WebDriver driver = null;


    public static void main(String[] args) {
        InitializingWebdriverPSVM initializingWebdriverPSVM = new InitializingWebdriverPSVM();
        initializingWebdriverPSVM.initdriver();
        initializingWebdriverPSVM.getURL();
        initializingWebdriverPSVM.displayTitle();
        initializingWebdriverPSVM.enterText();
        initializingWebdriverPSVM.closeBrowser();

    }

    public void initdriver() {
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);
        System.setProperty("webdriver.chrome.driver", userDIR + "/chromedriver");
        driver = new ChromeDriver();
    }

    // junit annotation  - Te
    // st a interface
    public void getURL() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    public void displayTitle() {
        System.out.println("title is " + driver.getTitle());
    }


    public void enterText() {
        try {
            driver.findElement(By.name("q")).sendKeys("Gurpreet");
        } catch (NoSuchElementException e) {

        }
    }

    public void closeBrowser() {
        driver.close();
    }
}

