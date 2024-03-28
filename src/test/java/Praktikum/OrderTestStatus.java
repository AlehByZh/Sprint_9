package Praktikum;

import Praktikum.pages.MainPage;
import Praktikum.pages.StatusPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class OrderTestStatus {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void invalidOrderNumber() {
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver);

        main.open();
        main.clickOrderStatus();
        main.sendOrderNumber("12346");
        main.clickGo();

        StatusPage status = new StatusPage(driver);

        status.checkNotFound();
    }
}