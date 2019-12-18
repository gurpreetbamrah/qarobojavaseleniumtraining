package chapter4_seleniummethods.advance;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class DragAndDrop {

    static WebDriver driver = null;


    public void initDriver() {
        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
    }


    public static void main(String[] args) throws Exception {
        DragAndDrop dragAndDrop = new DragAndDrop();
        dragAndDrop.initDriver();
       dragAndDrop.dragAndDropImage();
    }


    public void dragAndDropImage() throws InterruptedException {

        //Element which needs to drag.
        WebElement source = driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element on which need to drop.
        WebElement destination = driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions obj = new Actions(driver);


        //Dragged and dropped.
        obj.dragAndDrop(source, destination).build().perform();


    }
}