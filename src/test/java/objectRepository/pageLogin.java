package objectRepository;

import org.openqa.selenium.By;

public class pageLogin {

    By field_username = By.name("user-name");
    By field_password = By.id("password");
    By btn_login = By.xpath("//input[@type='submit'][@data-test='login-button']");

    public By getField_username() {
        return field_username;
    }

    public By getField_password() {
        return field_password;
    }

    public By getBtn_login() {
        return btn_login;
    }
}
