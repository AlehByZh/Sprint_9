package Praktikum.pages;

import Praktikum.EnvConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPage {

    private final WebDriver driver;
    private final By middleOrderButton = By.cssSelector("[class*='Button_Middle__1CSJM']");
    //кнопка Заказать в центре страницы
    private final By goButton = By.cssSelector("[class*=Header_Button__]");
    //кнопка GO
    private final By statusInputField = By.cssSelector(".Input_Input__1iN_Z");
    //поле ввода номера заказа
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    //кнопка Статус заказа
    private final By upperButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    //кнопка Заказать в шапке страницы
    private final By scooterTextInHeader = By.cssSelector("[class*=Header_LogoScooter]");
    //кнопка Самокат в лого ЯндексСамокат
    private final By scooterTextOnPage = By.cssSelector("[class*=Home_Header__]");
    //Текст Самокат слева от рисунка самоката
    private final By yandexTextInHeader = By.cssSelector("[class*=Header_LogoYandex__]");
    //текст Яндекс в лого ЯндексСамокат

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public StatusPage clickGo() {
        driver.findElement(goButton).click();
        return new StatusPage(driver);
    }

    public void sendOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(statusInputField));

        driver.findElement(statusInputField).sendKeys(orderNumber);
    }

    public void clickOnUpperButtonOrder() {
        driver.findElement(upperButtonOrder).click();
    }

    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    public void clickOrderStatus() {
        driver.findElement(orderStatusButton).click();
    }

    public void open() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void checkPanelText(String elementText, int elementId) {
        String panelText = driver.findElement(By.id("accordion__panel-" + elementId)).getText();
        assertEquals(elementText, panelText);
    }

    public void clickOnPanelFaq(int elementId) {
        driver.findElement(By.id("accordion__heading-" + elementId)).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + elementId)));
    }
    public void clickOnScooterTextInHeader() {
        driver.findElement(scooterTextInHeader).click();
    }

    public void checkScooterTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(scooterTextOnPage));
        assert driver.findElement(scooterTextOnPage).isDisplayed();
    }
    public void clickOnYandexInHeader() {
        driver.findElement(yandexTextInHeader).click();
    }
}