package Praktikum;

import Praktikum.pages.AboutRentPage;
import Praktikum.pages.ForWhomScooterPage;
import Praktikum.pages.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.junit.Rule;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final String name;
    private final String secondName;
    private final String address;
    private final String phoneNumber;
    private final String comment;
    private final String rentDate;
    private final String metroStation;
    private final String colorScooter;

    public OrderScooterTest(String name, String secondName, String address, String phoneNumber, String comment, String rentDate, String metroStation, String colorScooter) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.rentDate = rentDate;
        this.metroStation = metroStation;
        this.colorScooter = colorScooter;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Иван", "Иванов", "Москва, Комсомольская 1", "+79991234567", "Тише, дети", "15.04.2024", "Медведково", "Чёрный"},
                {"Петя", "Петров", "Москва, Стадион ВТБ Арена", "+71234567890", "Звони громче!!!", "02.04.2024", "Динамо", "Серый"},
        };
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void OrderUpperButton() {
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver);
        main.open();

        Cookie cartoshkaCookie = new Cookie("Cartoshka-legacy", "true");
        Cookie cartoshkaLegacy = new Cookie("Cartoshka", "true");
        driver.manage().addCookie(cartoshkaCookie);
        driver.manage().addCookie(cartoshkaLegacy);
        driver.navigate().refresh();

        main.clickOnUpperButtonOrder();

        ForWhomScooterPage forWhon = new ForWhomScooterPage(driver);

        forWhon.enterName(name);
        forWhon.enterSecondName(secondName);
        forWhon.enterAddress(address);
        forWhon.clickOnMetroField();
        forWhon.clickOnMetroStation(metroStation);
        forWhon.enterPhoneNumber(phoneNumber);
        forWhon.clickOnForwardButton();

        AboutRentPage about = new AboutRentPage(driver);

        about.enterFieldWhen(rentDate);
        about.clickOnDurationRentField();
        about.clickOnTwoDays();
        about.chooseColor(colorScooter);
        about.enterComment(comment);
        about.clickOnOrderButton();
        about.clickOnYesPopupButton();
        about.checkOrderInProcessed();
    }

    @Test
    public void OrderMiddleButton() {
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver);
        main.open();

        Cookie cartoshkaCookie = new Cookie("Cartoshka-legacy", "true");
        Cookie cartoshkaLegacy = new Cookie("Cartoshka", "true");
        driver.manage().addCookie(cartoshkaCookie);
        driver.manage().addCookie(cartoshkaLegacy);
        driver.navigate().refresh();

        main.clickMiddleOrderButton();

        ForWhomScooterPage forWhon = new ForWhomScooterPage(driver);

        forWhon.enterName(name);
        forWhon.enterSecondName(secondName);
        forWhon.enterAddress(address);
        forWhon.clickOnMetroField();
        forWhon.clickOnMetroStation(metroStation);
        forWhon.enterPhoneNumber(phoneNumber);
        forWhon.clickOnForwardButton();

        AboutRentPage about = new AboutRentPage(driver);

        about.enterFieldWhen(rentDate);
        about.clickOnDurationRentField();
        about.clickOnTwoDays();
        about.chooseColor(colorScooter);
        about.enterComment(comment);
        about.clickOnOrderButton();
        about.clickOnYesPopupButton();
        about.checkOrderInProcessed();
    }
}