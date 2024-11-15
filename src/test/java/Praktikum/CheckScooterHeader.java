package Praktikum;

import Praktikum.pages.MainPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class CheckScooterHeader {
    @Rule
    public DriverRule driverRule = new DriverRule();
    @Test
    public void clickOnScooterInHeader(){
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver);
        main.open();
        main.clickOnUpperButtonOrder();
        main.clickOnScooterTextInHeader();
        main.checkScooterTextIsDisplayed();
    }
}