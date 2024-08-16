package VoilaTest.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class TransactionSteps {
    private WebDriver driver;

    public TransactionSteps(WebDriverProvider provider) {
        this.driver = provider.getDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://example.com/login");
    }

    @When("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("validUsername");
        passwordField.sendKeys("validPassword");
        loginButton.click();
    }

    @When("I search for a product with a price below IDR 10.000.000")
    public void i_search_for_a_product_with_a_price_below_IDR_10_000_000() {
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("product");
        searchBox.submit();

        WebElement maxPriceField = driver.findElement(By.id("maxPrice"));
        WebElement applyFilterButton = driver.findElement(By.id("applyFilter"));

        maxPriceField.clear();
        maxPriceField.sendKeys("10000000");
        applyFilterButton.click();

    }

    @When("the product is not in the BAG or WATCH category for example {string}")
    public void the_product_is_not_in_the_BAG_or_WATCH_category(String categorySelector) {
        WebElement category = driver.findElement(By.className("product-category"));
        if (!categorySelector.equals("BAG") && !categorySelector.equals("WATCH")) {
            category.sendKeys(categorySelector);
        }
        else{
            assertFalse("A product is found in the restricted category (BAG or WATCH)", true);
        }

    }

    @When("I add the product to my cart")
    public void i_add_the_product_to_my_cart() {
        WebElement addToCartButton = driver.findElement(By.id("addToCartButton"));
        addToCartButton.click();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        WebElement checkoutButton = driver.findElement(By.id("checkoutButton"));
        checkoutButton.click();
    }

    @When("I input my name on Shipping Address as {string}")
    public void i_input_my_name_on_Shipping_Address_as(String name) {
        WebElement nameField = driver.findElement(By.id("shippingName"));
        nameField.sendKeys(name);
    }

    @When("I choose a courier")
    public void i_choose_a_courier() {
        WebElement courierDropdown = driver.findElement(By.id("courierDropdown"));
        courierDropdown.sendKeys("CourierName");
    }

    @When("I choose a payment method as midtrans or bank transfer for example {string}")
    public void i_choose_a_payment_method_as(String paymentMethod) {
        WebElement paymentDropdown = driver.findElement(By.id("paymentDropdown"));
        if (paymentMethod.equals("midtrans") || paymentMethod.equals("bank transfer")){
            paymentDropdown.sendKeys(paymentMethod);
        }
        else{
            assertFalse("Payment method is invalid", true);
        }
    }

    @Then("I should see the transaction amount is correct")
    public void i_should_see_the_transaction_amount_is_correct() {
        WebElement amountElement = driver.findElement(By.id("transactionAmount"));
        String priceText = amountElement.getText().replace("IDR", "").replace(",", "").trim();
        int price = Integer.parseInt(priceText);

        assertTrue(price<10000000);
    }

    @Then("the transaction should be successfully completed")
    public void the_transaction_should_be_successfully_completed() {
        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
        assertEquals("Transaction completed successfully", confirmationMessage.getText());
    }

}

