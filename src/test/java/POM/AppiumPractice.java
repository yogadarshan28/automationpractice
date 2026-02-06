package POM;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumPractice {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setDeviceName("emulator-5554");
        options.setUdid("emulator-5554");

        // IMPORTANT: no space at the end
        options.setApp("/Users/yogadarshan/Downloads/1769965853303_foodhub_v2.apk");

        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                options
        );

        System.out.println("✅ App launched successfully!");

        Thread.sleep(5000);

        driver.findElement(AppiumBy.accessibilityId("AK_location_request_screen_enter_manually_text")).click();

        Thread.sleep(5000);

        driver.findElement(AppiumBy.accessibilityId("AK_search_places_screen_address_search")).sendKeys("AA11AA");

        Thread.sleep(5000);

        driver.findElement(AppiumBy.accessibilityId("AK_search_places_screen_places_item_line_one_0")).click();

        Thread.sleep(5000);

        /*try {
            driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Thread.sleep(5000);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("AK_takeaway_list_screen_search_icon")
        )).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("AK_takeaway_list_screen_search_input")
        )).sendKeys("food");


        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc,'takeaway_image')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc,'takeaway_image')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("AK_menu_screen_collection_toggle_button")
        )).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//com.horcrux.svg.SvgView[@content-desc=\"AK_menu_screen_info_icon_unfilled\"]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView"
                        )
                )
        ).click();

        String feeDescription= wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId(
                                "AK_menu_screen_fee_description_This fee is charged for delivering your order and the amount may vary based on distance, order value, or delivery conditions. This fee is charged by the store and not by Foodhub."
                        )
                )
        ).getText();

        System.out.println(feeDescription);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("AK_undefined_undefined")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Test-Foodhub's Test's TA's")
        )).click();

        Thread.sleep(5000);

       /* wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//com.horcrux.svg.SvgView[@content-desc="AK_menu_screen_youtube_video_modal_close"]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
                )
        ).click();*/





    }
}