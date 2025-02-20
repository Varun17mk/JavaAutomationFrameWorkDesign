package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandaloneTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("varunm@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Varun@1234");
        driver.findElement(By.id("login")).click();


        // Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        List<WebElement> Items = driver.findElements(By.cssSelector(".mb-3"));
        //Java Streams to iterate over list of webElements [Its clean code replaced for iterating through for loop]
        WebElement prod = Items.stream().filter(product
                -> product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);

        // after going to html block of "IPHONE 13 PRO" locating "add to cart" button, example of limiting  driver scope
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        driver.findElement(By.xpath("//button[@routerlink = \"/dashboard/cart\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart h3")));

        //Checking if the selected item matches expected item
        Boolean match = driver.findElement(By.cssSelector(".cart h3")).getText().equalsIgnoreCase("IPHONE 13 PRO");
        Assert.assertTrue(match, "Its what it is expected");

        // Clicking Checkout button
        driver.findElement(By.cssSelector(".subtotal button")).click();

        // locating Country input and sending keys
        driver.findElement(By.xpath("//input[@placeholder =\"Select Country\"]")).sendKeys("ind");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section/button")));
        List<WebElement> dropdown = driver.findElements(By.xpath("//section/button"));
        for (WebElement dropDown : dropdown) {
            System.out.println(dropDown.getText());
            if (dropDown.getText().equalsIgnoreCase("India")) {
                dropDown.click();
                break;
            }
        }

        driver.findElement(By.xpath("//a[@class=\"btnn action__submit ng-star-inserted\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
        System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
        String confirmationText = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(driver.findElement(By.cssSelector(".hero-primary")).getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}
