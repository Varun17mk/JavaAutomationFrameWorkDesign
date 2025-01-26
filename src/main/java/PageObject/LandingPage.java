package PageObject;

import AbstractComonents.AbstractComponentsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponentsPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Opening URL from below method
    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    //Using PageFactory[Design Pattern]
    @FindBy(id = "userEmail")
    WebElement userEmailLocator;

    @FindBy(id = "userPassword")
    WebElement UserPasswordLocator;

    @FindBy(id = "login")
    WebElement SubmitLocator;

//            .ng-tns-c4-8.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error

    @FindBy(css = "[class*=ngx-toastr]")
    WebElement errorMessageCss;

    //Actions on elements
    public ProductCatalogue loginApplicationPage(String Email, String Password) {
        userEmailLocator.sendKeys(Email);
        UserPasswordLocator.sendKeys(Password);
        SubmitLocator.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public String  getErrorMessage(){
        WaitForWebElementToAppear(errorMessageCss);
       String errorMessageText= errorMessageCss.getText();
       return errorMessageText;
    }

}
