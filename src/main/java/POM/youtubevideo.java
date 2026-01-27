package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class youtubevideo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {


            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.get("https://sit-foodhub-uk.stage.t2sonline.com/");

            driver.findElement(By.id("home-postcode")).sendKeys("ST66DX");
            driver.findElement(By.xpath("//*[@id='home-findtakeaway']/span")).click();
            Thread.sleep(5000);

            WebElement TA = driver.findElement(
                    By.xpath("//*[@id='Test-MaduraiTA1_takeaway_name_text']")
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", TA);


            driver.findElement(By.xpath("//img[@src='https://s3.amazonaws.com/dev-t2s-public/static/9ff9b8514b9df9a685bb2582d72999e6/img/1719554418php5ThSrn.jpg']")).click();

            //Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@testID='AK_menu_screen_youtube_video_modal_close']")).click();

            System.out.println("✅ Test completed successfully");

        }
        catch (TimeoutException | NoSuchElementException e) {
            System.out.println("❌ Element issue occurred: " + e.getMessage());
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("❌ Thread interrupted");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("❌ Unexpected error occurred");
            e.printStackTrace();

        } /*finally {
            if (driver != null) {
                driver.quit();
            }
        }*/
    }
}
