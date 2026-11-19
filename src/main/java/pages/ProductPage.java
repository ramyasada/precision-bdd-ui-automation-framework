package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtil;

public class ProductPage {
	private WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By kidsfshndrpdwn=By.xpath("//div[@id='tab-category-3']");
	private By kidsfootwear=By.xpath("//div[normalize-space()='Boys Footwear']");
	private By boyShoe=By.xpath("//img[@title=\"ASIAN HENRY-04cTBLURED Blue Boy's Sandals\"]");
	private By checkPage=By.xpath("//h1");
	private By productName = By.xpath("//span[@class='mess-text']");
	private By productCart=By.xpath("//span[normalize-space()='add to cart']");
	private By validateProduct=By.xpath("//span[@class='mess-text']");
	
	public void selectDrpDwn()
	{
		driver.findElement(kidsfshndrpdwn).click();
	}
	public void slctFootwearHeader()
	{
		driver.findElement(kidsfootwear).click();
	}
	public void slctproduct()
	{
		String parentWindow=driver.getWindowHandle();
		driver.findElement(boyShoe).click();
		for(String window:driver.getWindowHandles())
		{
		    if(!window.equals(parentWindow))
		    {
		        driver.switchTo().window(window);
		        break;
		    }
		}
	}
	public boolean validatePageDisplayed()
	{
		WebElement product=WaitUtil.getWebDriverWait(20).until(ExpectedConditions.visibilityOfElementLocated(checkPage));
	    return product.isDisplayed();
	}
	public String getProductName()
	{
	    return driver.findElement(productName).getText().trim();
	}
	public void addProdToCart()
	{
		driver.findElement(productCart).click();
	}
	
}
