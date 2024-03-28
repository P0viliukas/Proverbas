import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

public class HomepageTest extends Base{

    @Test
    public void testAppOpen(){
        driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/color"))
                .isDisplayed();

    }
}
