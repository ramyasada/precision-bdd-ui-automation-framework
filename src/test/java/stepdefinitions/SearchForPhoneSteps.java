package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchMobilePage;
import utils.ConfigReader;
import utils.LogsFactory;

public class SearchForPhoneSteps {
	private Logger logger = LogsFactory.getLogger(SearchForPhoneSteps.class);
	private SearchMobilePage s;
	private WebDriver driver;
		@Given("User Navigate to Walmart homepage")
		public void navigateToPage() {
			
		    logger.info("navigating to the webpage");
		    driver=DriverFactory.getDriver();
		    s=new SearchMobilePage(driver);
		}

		@When("Search for iPhone in the search bar")
		public void clickSearch() throws InterruptedException {
		    logger.info("user click on the search button");
		    s.searchForphone(ConfigReader.getProperty("mobile_name"));
		}

		@When("Click on first suggestion")
		public void click1stuggestion() throws InterruptedException {
		    logger.info("clicking on the 1st suggestion");
		    s.clickOnFirstSuggestion();
		}

		@When("Ensure results page is displayed")
		public void isResultsDisplayed() {
		    logger.info("checking results are displayed or not");
		    Assert.assertTrue(s.checkPageDisplayed(),"empty results");
		}

		@Then("Validate that product results are relevant to iPhone")
		public void validateTheDisplayedProducts() {
		    logger.info("validating the results");
		    Assert.assertTrue(s.validateResults(), "invalid results");
		}


}
