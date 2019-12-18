package chapter4_seleniummethods.advance;
import chapter4_seleniummethods.basic_form.HTMLFormExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static chapter4_seleniummethods.basic_form.HTMLFormExample.driver;


class MoveToElementExample {


    public static void main(String[] args) {
        MoveToElementExample moveToElementExample = new MoveToElementExample();
        HTMLFormExample htmlFormExample = new HTMLFormExample();
        htmlFormExample.initDriver();
        htmlFormExample.getURL("https://www.guru99.com/");
        moveToElementExample.moveToElement();
    }

    private void moveToElement() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[text()='Testing']"));
        actions.moveToElement(element).build().perform();
    }
}
