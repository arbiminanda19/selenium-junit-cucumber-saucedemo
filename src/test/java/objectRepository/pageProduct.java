package objectRepository;

import org.openqa.selenium.By;

public class pageProduct {

    By btn_addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
    By badge_amountProduct = By.className("shopping_cart_badge");

    public By getBtn_addToCart() {
        return btn_addToCart;
    }

    public By getBadge_amountProduct() {
        return badge_amountProduct;
    }
}
