package hooks;

import org.openqa.selenium.WebDriver;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ScreenShotUtil;

public class Hooks {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
		driver.get(ConfigReader.getProperty("base.url"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ScreenShotUtil.capture(driver);
			scenario.attach(screenshot, "image/png", "Failure Screenshot");
		}
		DriverFactory.quitDriver();
	}
}
