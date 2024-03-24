package Praktikum;

import Praktikum.pages.MainPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class СheckYandexHeader {
    @Rule
    public DriverRule driverRule = new DriverRule();
    @Test
    public void clickOnYandexInHeader(){
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver);
        main.open();
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        main.clickOnYandexInHeader();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*=logoContainer-3l]")));
        driver.findElement(By.cssSelector("[class*=logoContainer-3l]"));
        assert driver.findElement(By.cssSelector("[class*=logoContainer-3l]")).isDisplayed();
    }
}
