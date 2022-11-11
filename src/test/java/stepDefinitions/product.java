package stepDefinitions;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class product extends env {

    int prev_amount;
    @When("user add first product to cart")
    public void user_add_first_product_to_cart() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }
    @And("user see initial amount")
    public void user_see_initial_amount() {
        WebElement text_amountInCart = driver.findElement(By.className("shopping_cart_badge"));
        prev_amount = Integer.valueOf(text_amountInCart.getText());
    }
    @When("user add second product to cart")
    public void user_add_second_product_to_cart() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }
    @Then("user verify amount of product in cart incremented")
    public void user_verify_amount_of_product_in_cart_incremented() {
        WebElement text_amountInCart = driver.findElement(By.className("shopping_cart_badge"));
        int curr_amount = Integer.valueOf(text_amountInCart.getText());
        Assert.assertTrue(curr_amount - prev_amount == 1);
    }

}
