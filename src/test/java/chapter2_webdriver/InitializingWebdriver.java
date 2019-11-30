package chapter2_webdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InitializingWebdriver {


    /*public interface WebDriver extends SearchContext
    The main interface to use for testing, which represents an idealised web browser.
    The methods in this class fall into three categories:
    Control of the browser itself
    Selection of WebElements
    Debugging aids
    */
    // WebDriver will wait until the page has fully loaded (that is, the onload event has fired) before returning control to your test or script. It’s worth noting that if your page uses a lot of AJAX on load then WebDriver may not know when it has completely loaded. If you need to ensure such pages are fully loaded then you can use waits.

    /*Key methods are get(String), which is used to load a new web page,
    and the various methods similar to findElement(By), which is used to find WebElements.
     */

    static WebDriver driver = null;


    //When writing tests, it is common to find that several tests need similar objects created before they can run.
// Annotating a public void method with @Before causes that method to be run before the Test method. The @Before methods of superclasses will be run before those of the current class.
    @Before
    public void initdriver() {
        String userDIR=System.getProperty("user.dir");
        System.out.println(userDIR);
        System.setProperty("webdriver.chrome.driver", userDIR+"/chromedriver");
        driver = new ChromeDriver();

    }

    // junit annotation  - Test a interface
    @Test
    public void getURL() {

     /*void get(java.lang.String url)
        Load a new web page in the current browser window. This is done using an HTTP GET operation,
        and the method will block until the load is complete. This will follow redirects issued either by the server or as a meta-redirect from within the returned HTML.
            Should a meta-redirect "rest" for any duration of time,
        it is best to wait until this timeout is over, since should the underlying page change
        whilst your test is executing the results of future calls against
        this interface will be against the freshly loaded page. Synonym for WebDriver.Navigation.to(String).*/


        driver.get("http://www.google.com");


        // maximizing a window

        driver.manage().window().maximize();


        displayTitle();
        enterText();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        closeBrowser();

    }


    //  getting title of page

    /*java.lang.String getTitle()
    The title of the current page.
    Returns:
    The title of the current page, with leading and trailing whitespace stripped, or null if one is not already set*/

    public void displayTitle() {
        System.out.println("title is " + driver.getTitle());
    }





    /*
        java.util.List<WebElement> findElements(By by)
        Find all elements within the current page using the given mechanism. This method is affected by the 'implicit wait' times in force at the time of execution. When implicitly waiting, this method will return as soon as there are more than 0 items in the found collection, or will return an empty list if the timeout is reached.
        Specified by:
        findElements in interface SearchContext
                Parameters:
        by - The locating mechanism to use
        Returns:
        A list of all WebElements, or an empty list if nothing matches
        */

    public void enterText() {

      //  WebElement element = null;

        try {
            //public interface WebElement extends SearchContext Represents an HTML element.
//            element = driver.findElement(By.name("q"));
//            element.sendKeys("Hey QA Robo!");
            driver.findElement(By.xpath("//a[text()='Gmail']")).click();

        } catch (NoSuchElementException e) {

        }
        // Enter something to search for  :void sendKeys(java.lang.CharSequence... keysToSend)
        // Use this method to simulate typing into an element, which may set its value.


    }

    // Close() - It is used to close the browser or page currently which is having the focus.

    public void closeBrowser() {
        driver.close();
    }


}







