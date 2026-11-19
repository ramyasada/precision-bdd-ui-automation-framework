package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ProductPage;
import utils.LogsFactory;

public class ProductSteps {
	private WebDriver driver;
	private ProductPage p;
	private CartPage c;
	private Logger logger=LogsFactory.getLogger(ProductSteps.class);

	@Given("Navigate to snapdeal homepage")
	public void navigateToPage() {
	    logger.info("navigating to the homepage of snapdeal");
	    driver=DriverFactory.getDriver();
	    p=new ProductPage(driver);
	    c=new CartPage(driver);
	}

	@When("Hover kids fashion")
	public void hoverKidsFashion() {
	    logger.info("selecting the kids fashion icon");
	    p.selectDrpDwn();
	}

	@When("Select kids fashion")
	public void selectKidsfashionBtn() {
	    logger.info("select footwear for kids");
	    p.slctFootwearHeader();
	}

	@When("user Select any product")
	public void userSelectAnyProduct() {
	    logger.info("user selects kids slippers for validation");
	    p.slctproduct();
	}

	@Then("Ensure that we are on correct product details page")
	public void ensureCorrectPageDisplayed() {
		
	    Assert.assertTrue(p.validatePageDisplayed());
	}

	@When("Click on Add to cart")
	public void addProduct() {
	    logger.info("adding product to cart");
	    p.addProdToCart();
	}

	@Then("Ensure the correct product is added to cart")
	public void correctProductAddedcart() {
	    logger.info("validate correct product is added to cart");
	    c.openCart();
	    String actualProduct=p.getProductName();
	    c.validateCorrectProduct(actualProduct);
	}

	@Then("validate sub total")
	public void validateSubTotal() {
		logger.info("validating the sub total");
	    c.validateSubTotal();
	}

	@Then("validate estimated total")
	public void validateEstimatedTotal() {
	    logger.info("validating the estimated total");
	    c.validateEstimatedTotal(c.validateSubTotal());
	}

	@Then("Validate the cart count that displayed on cart icon in header")
	public void validateCartCount() {
	    logger.info("validating the cart count");
	    Assert.assertTrue(c.validateCartCount(c.getItemQuantity()));
	 
	}

	
}
