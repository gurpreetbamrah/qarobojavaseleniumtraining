package chapter4_seleniummethods.advance;

import chapter4_seleniummethods.basic_form.HTMLFormExample;
import org.openqa.selenium.By;

import java.util.Set;

import static chapter4_seleniummethods.basic_form.HTMLFormExample.driver;

public class HandlePopUpExample {
    public static void main(String[] args) {
        HandlePopUpExample handlePopUpExample=new HandlePopUpExample();
        HTMLFormExample htmlFormExample = new HTMLFormExample();
        htmlFormExample.initDriver();
        handlePopUpExample.handlePopUp();
    }

    private void handlePopUp() {
        driver.get("http://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                driver.findElement(By.name("emailid"))
                        .sendKeys("gaurav.3n@gmail.com");
                driver.close(); //closing child window
                driver.switchTo().window(parentWindow); //cntrl to parent window
            }
        }
        driver.close();
        driver.quit();
    }
}
