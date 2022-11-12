package stepDefinitions;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import objectRepository.pageProduct;

public class product extends env {

    int prev_amount;
    pageProduct elementProduct = new pageProduct();

    @When("user add first product to cart")
    public void user_add_first_product_to_cart() {
        List<WebElement> btn_addToCart = driver.findElements(elementProduct.getBtn_addToCart());
        btn_addToCart.get(0).click();
        Assert.assertTrue(btn_addToCart.size() == 6);
    }

    @And("user see initial amount")
    public void user_see_initial_amount() {
        WebElement text_amountInCart = driver.findElement(elementProduct.getBadge_amountProduct());
        prev_amount = Integer.valueOf(text_amountInCart.getText());
    }

    @When("user add second product to cart")
    public void user_add_second_product_to_cart() {
        driver.findElement(elementProduct.getBtn_addToCart()).click();
    }

    @Then("user verify amount of product in cart incremented")
    public void user_verify_amount_of_product_in_cart_incremented() {
        WebElement text_amountInCart = driver.findElement(elementProduct.getBadge_amountProduct());
        int curr_amount = Integer.valueOf(text_amountInCart.getText());
        Assert.assertTrue(curr_amount - prev_amount == 1);
    }

}
