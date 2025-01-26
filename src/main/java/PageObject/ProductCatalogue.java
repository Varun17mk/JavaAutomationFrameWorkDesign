package PageObject;

import AbstractComonents.AbstractComponentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponentsPage {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //List<WebElement> Items = driver.findElements(By.cssSelector(".mb-3"));

    //Using PageFactory[Design Pattern]
    @FindBy(css = ".mb-3")
    List<WebElement> Products;

    @FindBy(xpath = "//button[@routerlink = '/dashboard/cart']")
    WebElement Cart;

   By productsBy = By.cssSelector(".mb-3");
   By aadToCart = By.cssSelector(".card-body button:last-of-type");
   
   By toastMessage = By.cssSelector("#toast-container");

   By disappearToast = By.cssSelector(".ng-animating");


    //Actions on elements
    public List<WebElement> getProductsList() {
        WaitForElementToAppear(productsBy);
        return Products;
    }

    public WebElement getProductsByName(String productName){
        //Java Streams to iterate over list of webElements [Its clean code replaced for iterating through for loop]
        WebElement prod = getProductsList().stream().filter(product
                -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public CartPage addProductToCart(String productName){
        // after going to html block of "IPHONE 13 PRO" locating "add to cart" button, example of limiting  driver scope
        WebElement Prod =getProductsByName(productName);
        Prod.findElement(aadToCart).click();
        WaitForElementToAppear(toastMessage);
        WaitForElementToDisappear(disappearToast);

        //Clicking on cart to check items
        Cart.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }


}
