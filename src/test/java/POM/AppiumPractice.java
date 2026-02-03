package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;import java.time.Duration;

public class AppiumPractice {

AndroidDriver driver;
    public AppiumPractice() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");
        options.setUdid("emulator-5554");
        options.setAppPackage("com.t2s.foodhub");
        options.setAppActivity("com.t2s.foodhub");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"),
                options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void main(String[] args) throws MalformedURLException {
        // Trigger the constructor → launches the app
        new AppiumPractice();
    }
    }
