package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUI {

    public static final Target TXTB_USERNAME = Target
            .the("username text box")
            .located(By.id("user-name"));
    
    public static final Target TXTB_PASSWORD = Target
            .the("password text box")
            .located(By.id("password"));

    public static final Target BTN_LOGIN = Target
            .the("login button")
            .located(By.id("login-button"));
}
