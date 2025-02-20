package Tests;

import PageObject.CartPage;
import PageObject.OrderConfirmationPage;
import PageObject.PlaceOrderPage;
import PageObject.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.RetryFlakyFailedTC;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidation extends BaseTest {

    @Test(groups = "ErrorHandling",retryAnalyzer = RetryFlakyFailedTC.class)
    public void LoginErrorValidation() {

        String productName = "IPHONE 13 PRO";
        String Country = "India";

        //Sending Email id and Password as argument and loginApplicationPage performs login into application using arguments provided
        // and navigating to productCatalogue page
        landingPage.loginApplicationPage("varunm@gmail.com", "Varu1234"); //Providing wrong Password
        Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email  password.");

    }

    @Test
    public  void ConfirmationTextErrorValidation() {

        String productName = "IPHONE 13 PRO";
        String Country = "India";

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
        Assert.assertFalse(text.equalsIgnoreCase("THANYOU FOR THE ORDER."));

    }
}
