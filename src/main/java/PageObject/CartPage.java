package PageObject;

import AbstractComonents.AbstractComponentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponentsPage {
    WebDriver driver;

    @FindBy(css = ".cart h3")
    WebElement match;

    @FindBy(css = ".subtotal button")
    WebElement checkOutcss;

    By appearBy =By.cssSelector(".cart h3");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PlaceOrderPage checkingTheCartProducts(String productName){
        WaitForElementToAppear(appearBy);
//        //Checking if the selected item matches expected item
//        Boolean match = driver.findElement(By.cssSelector(".cart h3")).getText().equalsIgnoreCase(productName);
//        Assert.assertTrue(match, "Its what it is expected");

        Boolean matchString  = match.getText().equalsIgnoreCase(productName);
        //Checking if the selected item matches expected item
        // Clicking Checkout button
        checkOutcss.click();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        return placeOrderPage;
    }



}
