import com.google.common.base.Strings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.FileAssert;

import java.io.File;
import java.io.IOException;

public class ChromeBrowserTest {

    public static void main(String[] args) throws InterruptedException {

        /*//Creating a driver object referencing WebDriver interface*/
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\IdeaProjects\\Assessment-One\\Drivers\\chromedriver.exe");

        //starts the brower
        driver= new ChromeDriver();

        driver.manage().window().maximize();

        //launch URL
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        driver.findElement(By.name("firstName")).sendKeys("Londiwe");
        driver.findElement(By.name("lastName")).sendKeys("Maseko");
        driver.findElement(By.name("phone")).sendKeys("0734257495");
        driver.findElement(By.name("userName")).sendKeys("Masekolg@gmail.com");
        driver.findElement(By.name("address1")).sendKeys("1751 Uhuru Peak rd");
        driver.findElement(By.name("city")).sendKeys("Benoni");
        driver.findElement(By.name("state")).sendKeys("Gauteng");
        driver.findElement(By.name("postalCode")).sendKeys("1501");
        driver.findElement(By.name("country")).sendKeys("Austria");
        driver.findElement(By.name("email")).sendKeys("MasekoLg");
        driver.findElement(By.name("password")).sendKeys("Londy");
        getScreenshot(driver);
        driver.findElement(By.name("confirmPassword")).sendKeys("Londy");
        driver.findElement(By.name("submit")).click();
        WebElement register_success= driver.findElement(By.xpath("xpath=//input[@id='email']"));
        Assert.assertEquals(register_success.getText(),"Note: Your user name is MasekoLg");
        driver.findElement(By.xpath("xpath=//a[contains(text(),'sign-in')]")).click();
        Thread.sleep(2000);
        getScreenshot(driver);
        driver.findElement(By.name("userName")).sendKeys("MasekoLg");
        driver.findElement(By.xpath("xpath=//input[@name='password']")).sendKeys("Londy");
        driver.findElement(By.name("submit")).click();
        WebElement login_success= driver.findElement(By.xpath("xpath=//h3[contains(.,'Login Successfully')]"));
        Assert.assertEquals(login_success.getText(),"Login Successfully");
    }

    WebDriver driver; {
    }

    public static String getScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";

        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);

        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }
}

//Run Tests with Testng

//Londiwe updated something here, I want to see it on bitbucket

