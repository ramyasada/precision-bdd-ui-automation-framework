package pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;
public class SearchMobilePage {
	private WebDriver driver;
	
	public SearchMobilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By searchInput=By.xpath("//input[@id='search-box-input']");
	private By firstSuggestion=By.xpath("//div[contains(@class,'AutoSuggestionsEle') and normalize-space()='iphone 17 pro']");
	private By results=By.cssSelector("div.product-tuple-listing");
	private By products=By.cssSelector("div.product-tuple-listing");
	public void searchForphone(String s) 
	{
		WebElement searchBox=WaitUtil.getWebDriverWait(20).until(ExpectedConditions.elementToBeClickable(searchInput));
		searchBox.sendKeys(s);
	}
	public void clickOnFirstSuggestion() 
	{
		  WaitUtil.getWebDriverWait(10).until(ExpectedConditions.visibilityOfElementLocated(firstSuggestion));
		 driver.findElement(firstSuggestion).click();   
		
	}
	public boolean checkPageDisplayed()
	{
		WebElement res=driver.findElement(results);
		return res.isDisplayed();
	}
	public boolean validateResults()
	{
		List<WebElement>prod=driver.findElements(products);
		for(WebElement p:prod)
		{
			if(p.getText().toLowerCase().contains("iphone"))
				return true;
		}
		return false;
	}
}
