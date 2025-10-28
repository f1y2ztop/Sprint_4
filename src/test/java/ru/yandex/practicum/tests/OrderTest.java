package ru.yandex.practicum.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage;
import ru.yandex.practicum.pages.util.DataForTesting;

import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest {

    public final By buttonSelect;
    public final String nameData;
    public final String surNameData;
    public final String addressData;
    public final String metroStationData;
    public final String phoneNumberData;
    public final String calendarData;
    public final By rentPeriod;
    public final By colorCheckBox;
    public final String commentForCourierData;

    public OrderTest(By buttonSelect, String nameData, String surNameData,
                     String addressData, String metroStationData, String phoneNumberData,
                     String calendarData, By rentPeriod, By colorCheckBox, String commentForCourierData) {

        this.buttonSelect = buttonSelect;
        this.nameData = nameData;
        this.surNameData = surNameData;
        this.addressData = addressData;
        this.metroStationData = metroStationData;
        this.phoneNumberData = phoneNumberData;
        this.calendarData = calendarData;
        this.rentPeriod = rentPeriod;
        this.colorCheckBox = colorCheckBox;
        this.commentForCourierData = commentForCourierData;

    }

    @Rule
    public DriverFactory factory = new DriverFactory();

    @Parameterized.Parameters
    public static Collection<Object[]> getOrder() {
        return DataForTesting.getOrderTestData();
    }

    @Test
    public void testScooterOrderUpperButton() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnAcceptButton();
        OrderPage orderPage = mainPage.mainPageOrderButtonClick(buttonSelect);
        orderPage.fillNameField(nameData);
        orderPage.fillSurNameField(surNameData);
        orderPage.fillAddressField(addressData);
        orderPage.fillMetroStation(metroStationData);
        orderPage.fillPhoneNumberField(phoneNumberData);
        orderPage.nextButtonClick();
        orderPage.rentPeriodField(calendarData);
        orderPage.chooseRentPeriod(rentPeriod);
        orderPage.chooseColor(colorCheckBox);
        orderPage.fillCommentForCourier(commentForCourierData);
        orderPage.orderPageOrderButtonClick();
        orderPage.orderConfirmationButtonClick();
        orderPage.waitForOrderDisplay();
        Assert.assertTrue(driver.findElement(OrderPage.watchStatus).isDisplayed());
    }
}