package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;



import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Homepage  {
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

            WebElement TA = driver.findElement(By.xpath("(//*[normalize-space()='Test - Ashwin UK'])[2]"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", TA);

            driver.findElement(By.xpath("//h4[@id='item_name_textHot deal 1']")).click();

            Thread.sleep(5000);

            driver.findElement(By.xpath("//div[@id='add_instruction']")).click();

            driver.findElement(By.xpath("//textarea[@data-class='instruction_text_input']")).sendKeys("cook not spicy");

            driver.findElement(By.xpath("(//div[normalize-space()='ADD'])[4]")).click();

            WebElement addbtn = driver.findElement(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-18u37iz r-1777fci']"));
            addbtn.click();



             WebElement pizzacat=driver.findElement(By.xpath("//div[@id='categoryPizzas']"));
        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", pizzacat);

Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-testid='AK_menu_screen_view_cart_btn']")).click();




    }
    }



