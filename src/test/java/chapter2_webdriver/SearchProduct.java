package chapter2_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchProduct {
    static WebDriver driver = null;

    public static void main(String[] args) {
        SearchProduct snapdealFunctionality = new SearchProduct();
        snapdealFunctionality.setupDriver();
        snapdealFunctionality.geturl();
        snapdealFunctionality.searchText();
        snapdealFunctionality.clickSearch();
        snapdealFunctionality.verifysearchResult();
        snapdealFunctionality.closeBrowser();

    }

    private void closeBrowser() {
        driver.close();
    }

    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/gurpreetsingh/Desktop/workspace/qaroboseleniumtraining/chromedriver");
        driver = new ChromeDriver();

    }

    public void geturl() {
        driver.get(" https://www.snapdeal.com/");
    }

    public void searchText() {
        driver.findElement(By.id("inputValEnter")).sendKeys("watch");
    }

    public void clickSearch() {
        driver.findElement(By.className("searchTextSpan")).click();
    }


    public void verifysearchResult() {
//        String str = driver.findElement(By.xpath("//section[1]/div[1]/div[3]/div[1]/a[1]/p[1]")).getText();
//        System.out.println("Text is ->"+str);
//        if (!str.contains("Watch")) {
//            try {
//                throw new Exception("Watch is not present");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
      //  List list = driver.findElements(By.xpath("//section/div"));

        for (int i = 1; i <= 4; i++) {
            String string = "//section[1]" + "/div[" + i + "]" + "/div[3]/div[1]/a[1]/p[1]";
            String getText = driver.findElement(By.xpath(string)).getText();
            System.out.println(getText);

            if (!getText.contains("Watch")) {
                try {
                    throw new Exception("Watch is not present");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
