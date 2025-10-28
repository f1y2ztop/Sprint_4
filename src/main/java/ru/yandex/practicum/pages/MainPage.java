package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.util.EnvConfig;

import java.time.Duration;


public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By cookieAcceptButton = By.cssSelector("#rcc-confirm-button"); // Кнопка принять куки "да все привыкли"
    public static final By upperOrderButton = By.cssSelector(".Button_Button__ra12g"); // Верхняя кнопка заказать
    public static final By lowerOrderButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp"); // Нижняя кнопка заказать

    public void ScrollToAccordion(WebElement accordionHeading) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", accordionHeading);
    }
    public void accordionHeadingClick(String accordionHeadingId) {
        WebElement accordionHeading = driver.findElement(By.cssSelector(accordionHeadingId));
        ScrollToAccordion(accordionHeading);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(accordionHeading)).click();
    }

    public void waitForPanelDisplay(String accordionPanelId) {
        By accordionPanel = By.cssSelector(accordionPanelId);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel));
    }

    public void openMainPage() {
        driver.get(EnvConfig.MAIN_URL);
    }

    public void clickOnAcceptButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT));
        driver.findElement((cookieAcceptButton));
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
    }

    public OrderPage mainPageOrderButtonClick(By buttonSelect) {
        WebElement buttonOrderElement = driver.findElement(buttonSelect);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonOrderElement);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(buttonSelect)).click();
        return new OrderPage(driver);
    }
}
