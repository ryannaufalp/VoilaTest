package VoilaTest.steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class SearchSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchSteps(WebDriverProvider provider){
        this.driver = provider.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        driver.get("https://voila.id/");
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String arg0) {
        WebElement searchBar = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div/input\n"));
        searchBar.sendKeys("Nike");
    }

    @And("the user clicks the enter key")
    public void theUserClicksTheEnterKey() {
        WebElement searchBar = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div/input\n"));
        searchBar.sendKeys(Keys.ENTER);
    }

    @Then("the user should see a list of products related to {string}")
    public void theUserShouldSeeAListOfProductsRelatedTo(String search) {

    }

    @And("each product should display the name and price")
    public void eachProductShouldDisplayTheNameAndPrice() {
    }
}
