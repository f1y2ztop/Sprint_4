package ru.yandex.practicum.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.util.EnvConfig;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле Имя
    private static final By nameField = By.cssSelector("input[placeholder='* Имя']");
    // Поле Фамилия
    private static final By surNameField = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле адреса
    private static final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле станции метро
    private static final By metroStationField = By.cssSelector("input[placeholder='* Станция метро']");
    // Выбор станции метро в раскрывающемся списке
    private static final By metroStationSelect = By.cssSelector(".select-search__row");
    // Поле телефон
    private static final By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка далее
    private static final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    // Поле когда привезти самокат
    private static final By calendarField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Поле срок аренды
    private static final By rentPeriodField = By.cssSelector(".Dropdown-placeholder");
    // Выпадающий список сутки
    public static final By rentPeriodFirst = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    // Выпадающий список трое суток
    public static final By rentPeriodSecond = By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']");
    // Чекбокс цвет черный жемчуг
    public static final By blackPearlCheckBox = By.cssSelector("#black");
    // Чекбокс цвет серая безысходность
    public static final By greyHopeless = By.cssSelector("#grey");
    // Поле комментраий для курьера
    private static final By commentForCourier = By.cssSelector("input[placeholder='Комментарий для курьера']");
    // Кнопка заказа
    private static final By orderButton = By.xpath(
            ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    // Кнопка подтверждения заказа
    private static final By orderConfirmationButton = By.xpath(".//button[text()='Да']");
    // Кнопка посмотреть статус
    public static final By watchStatus = By.xpath(".//button[text()='Посмотреть статус']");

    public void fillNameField(String nameData) {
        driver.findElement(nameField).sendKeys(nameData);
    }

    public void fillSurNameField(String surNameData) {
        driver.findElement(surNameField).sendKeys(surNameData);
    }

    public void fillAddressField(String addressData) {
        driver.findElement(addressField).sendKeys(addressData);
    }

    public void fillMetroStation(String metroStationData) {
        driver.findElement(metroStationField).sendKeys(metroStationData);
        driver.findElement(metroStationSelect).click();
    }

    public void fillPhoneNumberField(String phoneNumberData) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumberData);
    }

    public void nextButtonClick() {
        driver.findElement(nextButton).click();
    }

    public void rentPeriodField(String calendarData) {
        driver.findElement(calendarField).sendKeys(calendarData + Keys.ENTER);
    }

    public void chooseRentPeriod(By rentPeriod) { // ОТРЕДАЧИТЬ
        driver.findElement(rentPeriodField).click();
        WebElement rentAmount = driver.findElement(rentPeriod);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", rentAmount);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(rentPeriod)).click();

    }

    public void chooseColor(By colorCheckBox) {
        driver.findElement(colorCheckBox).click();
    }

    public void fillCommentForCourier(String commentForCourierData) {
        driver.findElement(commentForCourier).sendKeys(commentForCourierData);
    }

    public void orderPageOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(orderButton)).click();
    }

    public void orderConfirmationButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(orderConfirmationButton)).click();

    }

    public void waitForOrderDisplay() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(watchStatus));

    }
}

