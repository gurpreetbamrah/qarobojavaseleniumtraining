package chapter4_seleniummethods.advance;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class UploadImageInSelenium {

    static WebDriver driver = null;


    public static void main(String[] args) throws InterruptedException, AWTException {
        UploadImageInSelenium uploadImageInSelenium=new UploadImageInSelenium();
        uploadImageInSelenium.Fileupload();
    }

    public void Fileupload() throws AWTException, InterruptedException {

        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();

// maximize browser
        driver.manage().window().maximize();

        // Specify the file location with extension
        StringSelection sel = new StringSelection("/Users/gurpreetsingh/Desktop/workspace/qaroboseleniumtraining/selenium_logo.png");

        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        System.out.println("selection" + sel);


// Open Monster.com
        driver.get("https://www.monsterindia.com/seeker/v2/registration?newreg=1&utm_expid=.0W0_e-wdTaiIw26sya1HDQ.1&utm_referrer=");
        Thread.sleep(2000);

        // This will scroll down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,350)");

// Wait for 5 seconds
        Thread.sleep(5000);

// This will click on Browse button
        driver.findElement(By.xpath("//span[@class='browse-text']")).click();


        System.out.println("Browse button clicked");

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

}
