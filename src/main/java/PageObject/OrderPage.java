package PageObject;

import AbstractComonents.AbstractComponentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponentsPage {
    WebDriver driver;

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> Ordercss;

    By OrderBy= By.cssSelector("tr td:nth-child(3)");

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Boolean verifyOrderDisplay(String productName){
        WaitForElementToAppear(OrderBy);
//        //Checking if the selected item matches expected item
//        Assert.assertTrue(match, "It's what it is expected");
        Boolean matchString   = Ordercss.stream().anyMatch(product ->product.getText().equalsIgnoreCase(productName));
        return matchString;
    }

}
