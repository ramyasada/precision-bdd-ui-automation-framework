
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    private By cartIcon=By.xpath("//i[@class='sd-icon sd-icon-cart-icon-white-2']");
    private By productNameInCart=By.xpath("//a[@title=\"ASIAN HENRY-04cBRNBEIG Brown Boy's Sandals\"]");
    private By itemPrice=By.xpath("//span[@class='item-price']");
    private By itemQty=By.xpath("//div[@id='CS1']");
    private By cartQty=By.xpath("//span[@class='cartQuantity']");

    private int getNumericValue(String value) 
    {
        return Integer.parseInt(value.replaceAll("[^0-9]",""));
    }
    public void openCart() 
    {
        driver.findElement(cartIcon).click();
    }
    public boolean validateCorrectProduct(String expectedProduct) 
    {
        String actualProduct=driver.findElement(productNameInCart).getAttribute("title");
        return actualProduct.equalsIgnoreCase(expectedProduct);
    }
    public int getItemPrice()
    {
        String priceText=driver.findElement(itemPrice).getAttribute("textContent").trim();
        int price=getNumericValue(priceText);
        return price;
    }
   public int getItemQuantity()
   {
        String quantityText=driver.findElement(itemQty).getAttribute("textContent").trim();
        int quantity=getNumericValue(quantityText);
        return quantity;
    }
   public int validateSubTotal() 
   {
        int price=getItemPrice();
        int quantity=getItemQuantity();
        int subTotal=price*quantity;
        return subTotal;
    }
   public int validateEstimatedTotal(int subTotal) 
   {
        int discount=0;
        int deliveryCharges=0;
        int estimatedTotal=subTotal-discount+deliveryCharges;
        return estimatedTotal;
    }
   public boolean validateCartCount(int expectedQty) 
   {
        String countText=driver.findElement(cartQty).getText().trim();
        int actualCount=getNumericValue(countText);
        return expectedQty==actualCount;
    }

}
