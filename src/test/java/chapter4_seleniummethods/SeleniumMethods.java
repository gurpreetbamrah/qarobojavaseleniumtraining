package chapter4_seleniummethods;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * If you don't mention the priority, it will take all the test cases as "priority=0"
 * Elements Gets Cached Always Clear Cookie Before Executing the test  case
 */

public class SeleniumMethods {

   static WebDriver driver=null;

    @Before
    public void initDriver(){
       // WebDriverManager.getInstance(FIREFOX).version("2.39").setup();
       // WebDriverManager.firefoxdriver().setup();
      //  WebDriverManager.getInstance(FIREFOX).setup();
      //  FirefoxDriverManager.getInstance(FIREFOX).setup();
        ChromeDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }


    @Test
    public void getURl() {
        driver.get("http://www.google.com");
       // driver.close();
    }

//    @Test
//    public void Navigate() {
//        driver.navigate().to("http://www.google.com");
//        driver.close();
//    }
//
//    @Test
//    public void navigateForward() {
//        driver.navigate().to("http://gsbamrah.github.io");
//        driver.findElement(By.id("prac-form"));
//        driver.navigate().back();
//
//        driver.navigate().forward();
//
//        driver.navigate().refresh();
//
//
//    }
//
//    @Test
//    public void enterText() {
//        WebElement namefirst = driver.findElement(By.name("firstname"));
//        namefirst.sendKeys("gurpreet");
//        WebElement namelast = driver.findElement(By.name("lastname"));
//        namelast.sendKeys("singh");
//    }
//
//    @Test
//    public void clearText() {
//        driver.findElement(By.id("")).clear();
//    }
//
//    @Test
//    public void clickButton() throws  IOException{
//        driver.manage().window().maximize();
//        driver.get("http://gsbamrah.github.io");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        WebElement Element = driver.findElement(By.id("prac-form"));
//        Element.click();
//        WebElement Element2 = driver.findElement(By.linkText("Forms"));
//        Element2.click();
//        String verifyurl = driver.getCurrentUrl();
//        Assert.assertTrue(verifyurl.contains("form.html"));
//        enterText();
//        selectfromDropDown();
//        playwithcheck();
//        SelectMultipleCheckbox();
//        uploadImage();
//      //  driver.close();
//
//    }
//
//    @Test
//    public void elementEnabledOrNot() {
//        driver.findElement(By.id("")).isEnabled();
//    }
//
//    @Test
//    public void handlingAlert() {
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        // alert.dismiss();
//
//    }
//
//    @Test
//    public void DragAndDrop() {
//        Actions builder = new Actions(driver);
//        WebElement source = driver.findElement(By.id(""));
//        WebElement target = driver.findElement(By.id(""));
//        builder.dragAndDrop(source, target).perform();
//        // DragAndDrop(source,target);
//    }
//
//    @Test
//    public void moveToElement() {
//        driver.get("http://gsbamrah.github.io");
//        WebElement Element = driver.findElement(By.id("prac-form"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(Element).perform();
//    }
//
//    @Test
//    public void MaximizeWindow() {
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void selectfromDropDown() {
//        WebElement element = driver.findElement(By.name("Country"));
//        Select sl = new Select(element);
//        sl.selectByValue("Australia");
//
//
//
//
//    }
//        /*
//        List<WebElement> options=driver.findElements(By.tagName("Country"));
//
//        for(WebElement option:options)
//        {
//       option.click();
//    }
//*/
//
//    @Test
//    public void playwithcheck() {
//        WebElement element = driver.findElement(By.xpath("//input[@name='vehicle1']"));
//        element.click();
//
//    }
//
//    @Test
//    public void SelectMultipleCheckbox() {
//        List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        for (WebElement el : els) {
//            if (!el.isSelected()) {
//                el.click();
//            }
//        }
//    }
//
//    @Test
//    public void uploadImage() throws IOException {
//
//        WebElement element = driver.findElement(By.xpath("//input[@id='pic']"));
//        element.click();
//        Runtime.getRuntime().exec("C:/Users/gurpreetsingh/Desktop/fileupload.exe");
//    }
//
//
//
//    @org.junit.Test
//    public void HandlePopUP() throws InterruptedException {
//
//        driver.get("http://www.rediff.com/");
//        String parentWindow = driver.getWindowHandle();
//
//
//
//        Set<String> handles =  driver.getWindowHandles();
//        for(String windowHandle  : handles)
//        {
//            if(!windowHandle.equals(parentWindow))
//            {
//                driver.switchTo().window(windowHandle);
//                driver.close(); //closing child window
//                driver.switchTo().window(parentWindow); //cntrl to parent window
//            }
//        }
//        driver.close();
//        driver.quit();
//    }


 //  JavascriptExecutor jse = (JavascriptExecutor) driver;
//    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  //  jse.executeScript("scroll(0,300)");



}