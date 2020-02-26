package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;

    @Given("user is on Home Page")
    public void user_is_on_Home_Page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","/home/sainath/saish_linux/Softwares/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shop.demoqa.com");


        throw new io.cucumber.java.PendingException();
    }

    @When("he search for {string}")
    public void he_search_for(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("http://shop.demoqa.com/?s=" + string + "&post_type=product");
        throw new io.cucumber.java.PendingException();
    }

    @When("choose to buy the first item")
    public void choose_to_buy_the_first_item() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
        items.get(0).click();
        Select sel = new Select(driver.findElement(By.cssSelector("select#pa_color")));
        sel.selectByIndex(1);

        sel = new Select(driver.findElement(By.cssSelector("select#pa_size")));
        sel.selectByIndex(1);

        WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        addToCart.click();

        throw new io.cucumber.java.PendingException();
    }

    @When("moves to checkout from mini cart")
    public void moves_to_checkout_from_mini_cart() {
        // Write code here that turns the phrase above into concrete actions
        WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
        cart.click();
        throw new io.cucumber.java.PendingException();
    }

    @When("enters personal details on checkout page")
    public void enters_personal_details_on_checkout_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
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

        Select sel1 = new Select(driver.findElement(By.name("billing_state")));
        sel1.selectByValue("MH");

        WebElement city = driver.findElement(By.cssSelector("#billing_city.input-text"));
        city.sendKeys("Delhi");

        throw new io.cucumber.java.PendingException();
    }

    @When("select same delivery address")
    public void select_same_delivery_address() {
        // Write code here that turns the phrase above into concrete actions
        WebElement address = driver.findElement(By.cssSelector("#billing_address_1.input-text"));
        address.sendKeys("Shalimar Bagh");

        WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode.input-text"));
        postcode.sendKeys("110088");
        throw new io.cucumber.java.PendingException();
    }

    @When("select payment method as {string} payment")
    public void select_payment_method_as_payment(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
        paymentMethod.get(0).click();
        Thread.sleep(5000);

        WebElement acceptTC = driver.findElement(By.name("terms"));
        acceptTC.click();

        throw new io.cucumber.java.PendingException();
    }

    @When("place the order")
    public void place_the_order() {
        // Write code here that turns the phrase above into concrete actions
        WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
        placeOrder.submit();
        driver.quit();
        throw new io.cucumber.java.PendingException();
    }
}
