package RSacademy;

import PageObject.*;
import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SubmitOrderTest extends BaseTest {
    String productName = "IPHONE 13 PRO";
    String Country = "India";

    @Test
    public void submitOrder() {

        //Sending Email id and Password as argument and loginApplicationPage performs login into application using arguments provided
        // and navigating to productCatalogue page
        ProductCatalogue productCatalogue = landingPage.loginApplicationPage("varunm@gmail.com", "Varun@1234");

        // 2] Loading ProductCatalogue page from ProductCatalogue class
        CartPage cartPage = productCatalogue.addProductToCart(productName);

        // 3] CartPage
        //Checking if the selected item matches expected item
        // and navigating to placeOrderPage page
        PlaceOrderPage placeOrderPage = cartPage.checkingTheCartProducts(productName);

        // 4] Placing Order by entering country and clicking on place order
        // and navigating to orderConfirmationPage page

        OrderConfirmationPage orderConfirmationPage = placeOrderPage.placeOrder(Country);

        // 5] Order ConfirmationPage
        String text = orderConfirmationPage.setPlaceOrder();
        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

    @Test(dependsOnMethods = "submitOrder")
    public void OrderHistoryTest() {
        landingPage.loginApplicationPage("varunm@gmail.com", "Varun@1234");
       OrderPage orderPage = new OrderPage(driver);
        orderPage.goToOrdersPage();
        if(orderPage.verifyOrderDisplay(productName))
        {
            System.out.println("All items are correct!!");
        }
        else System.out.println("Check once again");
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }
}
