package chapter4_seleniummethods.basic_form;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class HTMLFormExample {

    public static ChromeDriver driver;

    public static void main(String[] args) throws Exception {
        HTMLFormExample htmlFormExample = new HTMLFormExample();
        htmlFormExample.initDriver();
        htmlFormExample.getURL("http://gurpreetbamrah.github.io/");
        htmlFormExample.clickElement("prac-basic_form");
        htmlFormExample.clickElementUsingLinkText("Forms");
        htmlFormExample.waitforTimePeroid();
        htmlFormExample.getcurrentUrl("basic_form");
        htmlFormExample.verifyHeader("TEST FORM");
        htmlFormExample.enterFirstAndLastName();
        htmlFormExample.clickRadioButton();
        //htmlFormExample.clickCheckBox();
        htmlFormExample.clickMultipleCheckBox();
        // htmlFormExample.uploadImage();
        // htmlFormExample.dragAndDrop();
        htmlFormExample.handleAlertInSelenium();
        htmlFormExample.submit();
        htmlFormExample.verifyFormSubmittedSuccessfully();
        htmlFormExample.closeBrowser();
    }

    private void closeBrowser() {
        driver.close();
    }

    private void submit() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    private void verifyFormSubmittedSuccessfully() throws Exception {
        String text = driver.findElement(By.id("demo")).getText();
        if (!text.equals("QA Robo Thank You for Your Submission")) {
            throw new Exception("basic_form not submitted successfully");
        }
    }

    private void handleAlertInSelenium() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='I am Alert']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        // driver.switchTo().alert().dismiss();
        //driver.switchTo().alert().getText();
        // driver.switchTo().alert().sendKeys("Text");
    }


    private void uploadImage() throws AWTException, InterruptedException {
// Way 1
// driver.findElement(By.id("pic")).sendKeys("/Users/gurpreetsingh/Desktop/workspace/qaroboseleniumtraining/selenium_logo.png");

// driver.findElement(By.id("pic")).click();

        WebElement element = driver.findElement(By.id("pic"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

//put path to your image in a clipboard
        StringSelection ss = new StringSelection("/Users/gurpreetsingh/Desktop/workspace/qaroboseleniumtraining/selenium_logo.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,350)");

// Wait for 5 seconds
        Thread.sleep(5000);

// Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);

// Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);

// Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

// Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

// Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


    private void clickMultipleCheckBox() {
        List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement el : els) {
            if (!el.isSelected()) {
                el.click();
            }
        }

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
        driver.findElement(By.xpath("//legend[contains(text(),'" + header + "')]"));

        // Way 2
        String element = driver.findElement(By.xpath("//legend[1]")).getText();
        if (!element.contains(header)) {
            throw new Exception("header not present");
        }
    }

    private void getcurrentUrl(String expectedURL) throws Exception {
        String getCurrentURL = driver.getCurrentUrl();
        if (!getCurrentURL.contains(expectedURL)) {
            throw new Exception("Expected URL not opened");
        }

    }

    public void initDriver() {
        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }

    public void getURL(String url) {
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


    private void dragAndDrop() {
        WebElement drag = driver.findElement(By.xpath("//img[@id='drag1']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='div1']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(drag, drop).build().perform();
    }


}
