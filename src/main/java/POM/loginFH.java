package POM;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class loginFH {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = null;
        options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // 2 = Block, 1 = Allow

        options.setExperimentalOption("prefs", prefs);

        // ✅ Launch browser with options
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://sit-foodhub-uk.stage.t2sonline.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("home-postcode")).sendKeys("AA11AA");
        driver.findElement(By.xpath("//*[@id='home-findtakeaway']/span")).click();
        driver.findElement(By.xpath("(//*[normalize-space()='Accept'])[3]")).click();

         Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@id='More']")).click();

        driver.findElement(By.xpath("//div[@class='css-146c3p1 r-2ny4f3 r-1yr78gv r-ubezar r-rjixqe r-p1pxzi r-11wrixw r-3twk1y']")).click();

        driver.findElement(By.xpath("//input[@aria-label='Email ID']")).sendKeys("yogadarshan.r@foodhub.com");

        driver.findElement(By.id("otp_login_continue_button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

// Wait for consent section
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@name='Check-Box']")
        ));

// Click using parent container (label/div)
        List<WebElement> checkBoxContainers = driver.findElements(
                    By.xpath("//*[@name='Check-Box']/parent::*")
        );

        for (WebElement box : checkBoxContainers) {
            js.executeScript("arguments[0].click();", box);
            Thread.sleep(300); // allow React state update
        }

// Wait until Agree button becomes enabled
        wait.until(driver1 ->
                driver1.findElement(By.id("agree_button")).isEnabled()
        );

// Final click
        WebElement agreeBtn = driver.findElement(By.id("agree_button"));
        js.executeScript("arguments[0].click();", agreeBtn);

    }
}
