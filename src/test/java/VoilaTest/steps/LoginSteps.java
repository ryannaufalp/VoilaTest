package VoilaTest.steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class LoginSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSteps(WebDriverProvider provider){
        this.driver = provider.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    @Given("the user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://voila.id/account/login");
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        WebElement usernameField = driver.findElement(By.name("identifier"));
        usernameField.sendKeys("ryan.n.pioscha@gmail.com");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        //WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div/div[2]/div[2]/div/div[1]/div/div/input"));

        passwordField.sendKeys("Voilatest2024");
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div/div[2]/button"));
        loginButton.click();

    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p._15kd2weps:nth-child(2)")));
        String expectedUrl = "https://voila.id/";
        String currentUrl = driver.getCurrentUrl();

        assertEquals("User was redirected to the dashboard", expectedUrl, currentUrl);

    }

    @And("the user should see a welcome message with their username")
    public void theUserShouldSeeAWelcomeMessageWithTheirUsername() {
        By welcomeMessage = By.cssSelector("p._15kd2weps:nth-child(2)");
        WebElement welcomeMessageElement = driver.findElement(welcomeMessage);

        String welcomeMessageText = welcomeMessageElement.getText();
        assertEquals("User was redirected to the dashboard", welcomeMessageText, "Hi, Ryan Nauf...!");

    }
}
