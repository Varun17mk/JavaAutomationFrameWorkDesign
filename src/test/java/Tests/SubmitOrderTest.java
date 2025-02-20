package Tests;

import PageObject.*;
import TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SubmitOrderTest extends BaseTest {
    String productName = "IPHONE 13 PRO";
    String Country = "India";

    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) {

        //Sending Email id and Password as argument and loginApplicationPage performs login into application using arguments provided
        // and navigating to productCatalogue page
        ProductCatalogue productCatalogue = landingPage.loginApplicationPage(input.get("email"),input.get("password"));

        // 2] Loading ProductCatalogue page from ProductCatalogue class
        CartPage cartPage = productCatalogue.addProductToCart(input.get("product"));

        // 3] CartPage
        //Checking if the selected item matches expected item
        // and navigating to placeOrderPage page
        PlaceOrderPage placeOrderPage = cartPage.checkingTheCartProducts(input.get("product"));

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


    // Using HashMap passing parameters
    @DataProvider
    public Object[][] getData(){
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("email","varunm@gmail.com");
        map1.put("password","Varun@1234");
        map1.put("product","IPHONE 13 PRO");

        HashMap<String,String> map2 = new HashMap<>();
        map2.put("email","nurav@gmail.com");
        map2.put("password","Varun@1234");
        map2.put("product","ADIDAS ORIGINAL");

        return new Object[][] {{map1}, {map2}};
    }


    // Using 2D Array passing parameters
//    @DataProvider
//    public Object[][] getData(){
//       return new Object[][] {{"varunm@gmail.com","Varun@1234","IPHONE 13 PRO"},{"nurav@gmail.com","Varun@1234","BANARSI SAREE"},{"nurav@gmail.com","Varun@1234","QWERTY"}};
//    }


}
