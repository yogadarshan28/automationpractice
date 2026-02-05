package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumPractice {

    public static void main(String[] args) throws MalformedURLException {

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
    }
}