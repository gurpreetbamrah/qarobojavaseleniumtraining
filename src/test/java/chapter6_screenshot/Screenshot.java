package chapter6_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import java.io.File;
import java.io.IOException;

/**
 * Created by gurpreetsingh on 2/14/2016.
 *
 public interface TakesScreenshot
 Indicates a driver that can capture a screenshot and store it in different ways.
 Method Detail :
 getScreenshotAs
 <X> X getScreenshotAs(OutputType<X> target)
 throws WebDriverException
 Capture the screenshot and store it in the specified location.
 For WebDriver extending TakesScreenshot, this makes a best effort depending on the browser to return the following in order of preference:

 Entire page
 Current window
 Visible portion of the current frame
 The screenshot of the entire display containing the browser
 For WebElement extending TakesScreenshot, this makes a best effort depending on the browser to return the following in order of preference: - The entire content of the HTML element - The visisble portion of the HTML element

 Type Parameters:
 X - Return type for getScreenshotAs.
 Parameters:
 target - target type, @see OutputType
 Returns:
 Object in which is stored information about the screenshot.

 Interface OutputType<T>

 public interface OutputType<T>
 Defines the output type for a screenshot.

 Modifier and Type	Field and Description
 static OutputType<java.lang.String>	BASE64
 Obtain the screenshot as base64 data.
 static OutputType<byte[]>	BYTES
 Obtain the screenshot as raw bytes.
 static OutputType<java.io.File>	FILE
 Obtain the screenshot into a temporary file that will be deleted once the JVM exits until you copy that.


 */
public class Screenshot {

    WebDriver driver=new FirefoxDriver();


    @Test
    public  void takeScreenshot() throws IOException {
   //driver.get("http://www.google.com");
        driver.get("http://stackoverflow.com/");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));

    }



    @Test
    public void  takescreenShotThroughRemoteAugmentor() throws IOException {
        /*
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.firefox());
                */
        driver.get("http:www.google.com");
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).
                getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("c:\\tmp\\screenshot2.png"));


    }


}

