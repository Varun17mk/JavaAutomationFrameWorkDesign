package PageObject;

import AbstractComonents.AbstractComponentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlaceOrderPage extends AbstractComponentsPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder =\"Select Country\"]")
    WebElement country;


    @FindBy(xpath = "//section/button")
    List<WebElement> dropdown;

    @FindBy(xpath = "//a[@class=\"btnn action__submit ng-star-inserted\"]")
    WebElement placeOrderButton;


    By dropDownButton = By.xpath("//section/button");



    public PlaceOrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmationPage placeOrder(String Country) {

        // locating Country input and sending keys
        country.sendKeys(Country);
        WaitForElementToAppear(dropDownButton);
        for (WebElement dropDown : dropdown) {
            System.out.println(dropDown.getText());
            if (dropDown.getText().equalsIgnoreCase(Country)) {
                dropDown.click();
                break;
            }
        }
        placeOrderButton.click();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        return orderConfirmationPage;
    }

}
