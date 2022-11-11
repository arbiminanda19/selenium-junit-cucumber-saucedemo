package stepDefinitions;

import config.env;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class login extends env {

    int duration = 10;

    @Given("user is on SauceDemo homepage")
    public void user_is_on_sauce_demo_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }
    @When("user input username")
    public void user_input_username() {
        WebElement field_userName = driver.findElement(By.name("user-name"));
        field_userName.isDisplayed();
        field_userName.sendKeys("standard_user");
    }

    @And("user input password")
    public void user_input_password() {
        WebElement field_password = driver.findElement(By.id("password"));
        Assert.assertTrue(field_password.isEnabled());
        field_password.sendKeys("secret_sauce");
    }
    @And("user click enter")
    public void user_click_enter() {
        WebElement field_password = driver.findElement(By.id("password"));
        field_password.sendKeys(Keys.ENTER);
    }
    @Then("user verify success login result")
    public void user_verify_success_login_result() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
    }

    @Then("user verify failed login")
    public void user_verify_failed_login() {
        driver.findElement(By.className("error-button"));
    }

}
