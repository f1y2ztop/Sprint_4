package ru.yandex.practicum.pages;

import org.junit.Assert;
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
    public static final String[][] // Массив данных для теста выпадающего списка "Вопросы о важном"
            accordionTestData = {
            {"#accordion__heading-0", "#accordion__panel-0"},
            {"#accordion__heading-1", "#accordion__panel-1"},
            {"#accordion__heading-2", "#accordion__panel-2"},
            {"#accordion__heading-3", "#accordion__panel-3"},
            {"#accordion__heading-4", "#accordion__panel-4"},
            {"#accordion__heading-5", "#accordion__panel-5"},
            {"#accordion__heading-6", "#accordion__panel-6"},
            {"#accordion__heading-7", "#accordion__panel-7"}
    };
    public static final By upperOrderButton = By.cssSelector(".Button_Button__ra12g"); // Верхняя кнопка заказать
    public static final By lowerOrderButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp"); // Нижняя кнопка заказать

    public void accordionHeadingClick(String accordionHeadingId) {
        WebElement accordionHeading = driver.findElement(By.cssSelector(accordionHeadingId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", accordionHeading);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(accordionHeading)).click();
    }

    public void panelDisplayCheck(String accordionPanelId) {
        By accordionPanel = By.cssSelector(accordionPanelId);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel));
        Assert.assertTrue("Элемент с Id:" + accordionPanel + " не отобразился.",
                driver.findElement(accordionPanel).isDisplayed());
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
