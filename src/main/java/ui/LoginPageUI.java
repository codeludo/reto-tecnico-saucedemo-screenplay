package ui;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
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

    public static final Target ERROR_MESSAGE = Target
            .the("error message user lock out")
            .locatedBy("//div[@class=\"error-message-container error\"]");
}
