package sauceTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class emptyCart {

    @Test
    public void emptyCart() {

        WebDriver driver;
        String url = "https://www.saucedemo.com/";

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
        int duration = 10;
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
        WebElement field_userName = driver.findElement(By.name("user-name"));
        WebElement field_password = driver.findElement(By.id("password"));

        field_userName.isDisplayed();
        field_userName.sendKeys("standard_user");
        Assert.assertTrue(field_password.isEnabled());
        field_password.sendKeys("secret_sauce");
        field_password.sendKeys(Keys.ENTER);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );

        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[contains(@class,'shopping_cart_link')]")).click();
        WebElement table_product = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(table_product.getText(), "Sauce Labs Backpack");

        WebElement btn_remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        btn_remove.click();
        Assert.assertFalse(driver.getPageSource().contains("inventory_item_name"));

        driver.quit();

    }

}
