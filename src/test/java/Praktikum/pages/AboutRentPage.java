package Praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AboutRentPage {
    private final WebDriver driver;
    private final By fieldWhen = By.cssSelector("input[placeholder*='* Когда привезти самокат']");
    //поле Когда привезти самокат
    private final By durationRentField = By.cssSelector(".Dropdown-placeholder");
    //поле Срок аренды
    private final By twoDaysField = By.xpath(".//div[text()='двое суток']");
    //поле 2 суток в Сроке аренды
    private final By checkboxBlack = By.cssSelector("input[id='black']");
    //чек-бокс Черного самоката
    private final By checkboxGrey = By.cssSelector("input[id='grey']");
    //чек-бокс Серого самоката
    private final By commentField = By.cssSelector("input[placeholder*='Комментарий для курьера']");
    //поле Комментарий
    private final By orderButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");
    //кнопка Заказать
    private final By yesPopupButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g') and text()='Да']");
    //кнопка Да в всплывающем окне
    private final By confirmPopup = By.cssSelector("[class*='Order_ModalHeader__3FDaJ']");
    //всплывающее окно Хотите оформить заказ
    private final By orderInProcessedPopup = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and (text()='Заказ оформлен')]");
    //окно Заказ оформлен

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderInProcessed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderInProcessedPopup));
        assert driver.findElement(orderInProcessedPopup).isDisplayed();
    }

    public void clickOnYesPopupButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmPopup)).isDisplayed();

        driver.findElement(yesPopupButton).click();
    }

    public void clickOnOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void chooseColor(String colorScooter) {
        if (colorScooter.equals("Чёрный")) {
            driver.findElement(checkboxBlack).click();
        } else if(colorScooter.equals("Серый")){
            driver.findElement(checkboxGrey).click();
        }
    }
    public void clickOnTwoDays() {
        driver.findElement(twoDaysField).click();
    }

    public void clickOnDurationRentField() {
        driver.findElement(durationRentField).click();
    }

    public void enterFieldWhen(String rentDate) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldWhen)).isDisplayed();
        driver.findElement(fieldWhen).sendKeys(rentDate);
        driver.findElement(fieldWhen).sendKeys(Keys.ENTER);
    }
}
