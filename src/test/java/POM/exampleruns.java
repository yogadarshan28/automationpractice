package POM;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class exampleruns {
    public static void main(String[] args) {

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

            driver.findElement(By.id("home-postcode")).sendKeys("AA11AA");
            driver.findElement(By.xpath("//*[@id='home-findtakeaway']/span")).click();

            WebElement TA = driver.findElement(
                    By.xpath("(//*[normalize-space()='Test - Ashwin UK'])[2]")
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", TA);

            driver.findElement(By.xpath("(//*[normalize-space()='Accept'])[3]")).click();

            driver.findElement(By.xpath("//h4[@id='item_name_textHot deal 2']")).click();

            Thread.sleep(5000);

            driver.findElement(By.xpath("//div[@id='add_instruction']")).click();
            driver.findElement(By.xpath("//textarea[@data-class='instruction_text_input']"))
                    .sendKeys("cook not spicy");

            driver.findElement(By.xpath("(//div[normalize-space()='ADD'])[4]")).click();

            WebElement addbtn = driver.findElement(By.xpath(
                    "//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-18u37iz r-1777fci']"
            ));
            addbtn.click();

            WebElement pizzacat = driver.findElement(By.xpath("//div[@id='categoryPizzas']"));
            js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", pizzacat);



            Thread.sleep(5000);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            By basketBtn = By.xpath("//div[@data-testid='AK_menu_screen_view_cart']");

            wait.until(ExpectedConditions.visibilityOfElementLocated(basketBtn));

            driver.findElement(basketBtn).click();


            By basketBtn2 = By.xpath("//*[@class='css-146c3p1 r-jwli3a r-1yr78gv r-ubezar r-rjixqe r-p1pxzi r-11wrixw r-tsynxw']");

            wait.until(ExpectedConditions.visibilityOfElementLocated(basketBtn));

            driver.findElement(basketBtn2).click();

            Thread.sleep(5000);


            By pickuptoggle = By.xpath("(//*[@id='collection_text,'])[3]");

            wait.until(ExpectedConditions.visibilityOfElementLocated(pickuptoggle));

            driver.findElement(pickuptoggle).click();

            By tipLocator = By.xpath("//*[@id='estimate_tip_view']");

            int tipCount = driver.findElements(tipLocator).size();

            for (int i = 0; i < tipCount; i++) {

                WebElement tip = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(driver.findElements(tipLocator).get(i)));



                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", tip);

                Thread.sleep(300); // small UI settle time
            }

            driver.findElement(By.xpath("(//*[@testID='AK_driver_tip_screen_delete_icon'])")).click();

            driver.findElement(By.xpath("//span[@class='css-1jxf684 r-2ny4f3']")).click();

            Thread.sleep(5000);

           String description =  driver.findElement(By.xpath("//span[@id='description_text_view']")).getText();
              System.out.println("Description: " + description);

              driver.findElement(By.xpath("//*[text()='OKAY']")).click();







            System.out.println("✅ Test executed successfully");

        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("❌ Element issue occurred: " + e.getMessage());
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("❌ Thread interrupted");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("❌ Unexpected error occurred");
            e.printStackTrace();

        }
       /* finally {
            if (driver != null) {
                driver.quit();
                System.out.println("🧹 Browser closed");
            }
        }*/
    }
}

