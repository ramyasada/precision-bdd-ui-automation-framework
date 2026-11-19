package utils;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import drivers.DriverFactory;
public class WaitUtil 
{
    public static WebDriverWait getWebDriverWait(int seconds) 
    {
        return new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(seconds));
    }
}
