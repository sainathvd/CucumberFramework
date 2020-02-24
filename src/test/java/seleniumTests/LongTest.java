package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LongTest {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/sainath/saish_linux/Softwares/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shop.demoqa.com");

        driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");

        List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
        items.get(0).click();

        Select sel = new Select(driver.findElement(By.cssSelector("select#pa_color")));
        sel.selectByIndex(1);

        sel = new Select(driver.findElement(By.cssSelector("select#pa_size")));
        sel.selectByIndex(1);

        WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        addToCart.click();


        WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
        cart.click();

        WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
        continueToCheckout.click();

        Thread.sleep(5000);
        WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
        firstName.sendKeys("Lakshay");

        WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
        lastName.sendKeys("Sharma");

        WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
        emailAddress.sendKeys("test@gmail.com");

        WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
        phone.sendKeys("07438862327");

        WebElement countryDropDown = driver.findElement(By.id("select2-billing_country-container"));
        countryDropDown.click();
        Thread.sleep(2000);

        List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
        for(WebElement country : countryList){
            if(country.getText().equals("India")) {
                country.click();
                Thread.sleep(3000);
                break;
            }
        }

        WebElement city = driver.findElement(By.cssSelector("#billing_city.input-text"));
        city.sendKeys("Delhi");

        WebElement address = driver.findElement(By.cssSelector("#billing_address_1.input-text"));
        address.sendKeys("Shalimar Bagh");

        WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode.input-text"));
        postcode.sendKeys("110088");

        WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
        shipToDifferetAddress.click();
        Thread.sleep(3000);

        List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
        paymentMethod.get(0).click();

        WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
        acceptTC.click();

        WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
        placeOrder.submit();

        driver.quit();
    }
}
