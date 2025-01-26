package AbstractComonents;

import PageObject.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponentsPage {
    WebDriver driver;
    @FindBy(css = "[routerlink*='myorders']")
    WebElement OrderHeader;

    public AbstractComponentsPage(WebDriver driver){
        this.driver= driver;
    }

    public void WaitForElementToBeClickable(By findBy){
        // Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void WaitForElementToAppear(By AppearBy){
        // Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppearBy));
    }

    public void WaitForWebElementToAppear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void WaitForElementToDisappear(By DisappearBy){
        // Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DisappearBy));
    }

    public OrderPage goToOrdersPage(){
        OrderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }


}
