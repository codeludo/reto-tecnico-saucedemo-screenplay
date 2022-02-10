package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPageUI {

    public static final Target TXTB_FIRSTNAME = Target
            .the("first name text box")
            .located(By.xpath("//*[@id=\"first-name\"]"));

    public static final Target TXTB_LASTNAME = Target
            .the("last name text box")
            .located(By.xpath("//*[@id=\"last-name\"]"));

    public static final Target TXTB_ZIPCODE = Target
            .the("postal code text box")
            .located(By.xpath("//*[@id=\"postal-code\"]"));

    public static final Target BTN_CONTINUE = Target
                .the("continue button")
                .located(By.xpath("//*[@id='continue']"));

    public static final Target LBL_TAX = Target
                .the("the tax label")
                .located(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]"));

    public static final Target BTN_FINISH = Target
            .the("finish button")
            .located(By.xpath("//*[@id='finish']"));

    public static final Target H2_CHECKOUTCOMPLETE = Target
            .the("the message of successfully checkout")
            .located(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));






}
