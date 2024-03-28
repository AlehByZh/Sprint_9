package Praktikum.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ForWhomScooterPage {
    private final WebDriver driver;
    private final By fieldName = By.cssSelector("input[placeholder*='* Имя']");
    //поле Имя
    private final By fieldSecondName = By.cssSelector("input[placeholder*='* Фамилия']");
    //поле Фамилия
    private final By fieldAddress = By.cssSelector("input[placeholder*='* Адрес: куда привезти заказ']");
    //поле Адрес
    private final By metroField = By.cssSelector("input[placeholder*='* Станция метро']");
    //поле Станция метро
    private final By fieldPhoneNumber = By.cssSelector("input[placeholder*='* Телефон: на него позвонит курьер']");
    //поле Телефон
    private final By forwardButton = By.cssSelector("[class*=Button_Middle__1CSJM]");
    //кнопка Далее
    private final By stationList = By.cssSelector("div[class*='Order_Text__']");
    //список названий станций метро


    public ForWhomScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRentPage clickOnForwardButton() {
        driver.findElement(forwardButton).click();

        return new AboutRentPage(driver);
    }

    public void enterPhoneNumber(String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldPhoneNumber)).isDisplayed();
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickOnMetroStation(String metroStation) {
        new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> metroSt = driver.findElements(stationList);
        for (WebElement m : metroSt) {
            String nameStation = m.getText();
            if (nameStation.equals(metroStation)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", m);
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(m));
                m.click();
                break;
            }
        }
    }

    public void clickOnMetroField() {
        driver.findElement(metroField).click();
    }

    public void enterAddress(String Address) {
        driver.findElement(fieldAddress).sendKeys(Address);
    }

    public void enterSecondName(String secondName) {
        driver.findElement(fieldSecondName).sendKeys(secondName);
    }

    public void enterName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldName)).isDisplayed();
        driver.findElement(fieldName).sendKeys(name);
    }
}