package chapter4_seleniummethods;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class HTMLFormExample {

    private ChromeDriver driver;

    public static void main(String[] args) throws Exception {
        HTMLFormExample htmlFormExample = new HTMLFormExample();
        htmlFormExample.initDriver();
        htmlFormExample.getURL("http://gurpreetbamrah.github.io/");
        htmlFormExample.clickElement("prac-form");
        htmlFormExample.clickElementUsingLinkText("Forms");
        htmlFormExample.waitforTimePeroid();
        htmlFormExample.getcurrentUrl("form");
        htmlFormExample.verifyHeader("TEST FORM");
        htmlFormExample.enterFirstAndLastName();
        htmlFormExample.clickRadioButton();
        htmlFormExample.clickCheckBox();
    }

    private void clickCheckBox() {
        driver.findElement(By.name("Java")).click();

    }

    private void clickRadioButton() {
        driver.findElement(By.xpath("//input[@value='male']")).click();
    }

    private void enterFirstAndLastName() {
        driver.findElement(By.id("namefirst")).sendKeys("QA");
        driver.findElement(By.name("lastname")).sendKeys("Robo");
    }

    private void verifyHeader(String header) throws Exception {
         // Way 1
          driver.findElement(By.xpath("//legend[contains(text(),'"+header+"')]"));

          // Way 2
        String element= driver.findElement(By.xpath("//legend[1]")).getText();
        if(!element.contains(header)){
            throw new Exception("header not present");
        }
    }

    private void getcurrentUrl(String expectedURL) throws Exception {
        String getCurrentURL = driver.getCurrentUrl();
        if (!getCurrentURL.contains(expectedURL)) {
            throw new Exception("Expected URL not opened");
        }

    }

    private void initDriver() {
        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }

    private void getURL(String url) {
        driver.get(url);
    }

    private void clickElement(String element) {
        driver.findElement(By.id(element)).click();
    }

    private void clickElementUsingLinkText(String href) {
        driver.findElement(By.linkText(href)).click();
    }

    private void waitforTimePeroid() throws InterruptedException {
        Thread.sleep(5000);
    }




}
