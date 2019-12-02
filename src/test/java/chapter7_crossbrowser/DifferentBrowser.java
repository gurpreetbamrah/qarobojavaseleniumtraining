package chapter7_crossbrowser;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by gurpreetsingh on 2/14/2016.
 *
 * Running Test Case on Chrome,Firefox,Safari,InternetExplorer
 */

public class DifferentBrowser {

    public void runOnFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        driver.close();

    }

    @Test
    public void runOnChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/gurpreetsingh/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.close();
    }

    @Test
    public void runOnSafari() {
        WebDriver driver = new SafariDriver();
        driver.get("http://www.google.com");
        driver.close();
    }

    @Test
    public void runOnInternetExplorer()
    {
        System.setProperty("webdriver.ie.driver","C:/Users/gurpreetsingh/Downloads/IEDriverServer_x64_2.52.0/IEDriverServer.exe");
    WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.google.com");
        driver.close();
}
}
