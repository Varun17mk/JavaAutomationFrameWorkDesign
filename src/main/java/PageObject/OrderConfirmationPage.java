package PageObject;

import AbstractComonents.AbstractComponentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OrderConfirmationPage extends AbstractComponentsPage {
    WebDriver driver;

    @FindBy(css = ".hero-primary")
    WebElement confirmationText;


    By Text = By.cssSelector(".hero-primary");


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String setPlaceOrder(){
        WaitForElementToAppear(Text);
        System.out.println(confirmationText.getText());
        String confirmationText = driver.findElement(Text).getText();
        return confirmationText;
    }
}
