import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

import java.net.MalformedURLException;
import java.time.Duration;

public class Base {
    public AppiumDriver driver;

    @BeforeEach
    public void setUp(){
        AppiumDriverLocalService service;
        service = new AppiumServiceBuilder()
                .withIPAddress("0.0.0.0")
//                .withArgument(() -> "--log-level", "error")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5556")
                .setPlatformName("Android")
                .setPlatformVersion("12.0")
                .setAutomationName("UiAutomator2")
                .setAvdReadyTimeout(Duration.ofSeconds(5))
                .setAvdLaunchTimeout(Duration.ofSeconds(5))
                .setAppPackage("com.lambdatest.proverbial")
                .setAppActivity("com.lambdatest.proverbial.MainActivity")
                .eventTimings();
        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("appium:platformVersion", "12.0");
//            capabilities.setCapability("appium:appPackage", "com.lambdatest.proverbial");
//            capabilities.setCapability("appium:appActivity", "com.lambdatest.proverbial.MainActivity");
//            capabilities.setCapability("appium:automationName", "UiAutomator2");
//            capabilities.setCapability("appium:udid", "emulator-5556");
//
//
//                    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }






    @AfterEach
    public void offApp(){
//        driver.quit();
    }

}
