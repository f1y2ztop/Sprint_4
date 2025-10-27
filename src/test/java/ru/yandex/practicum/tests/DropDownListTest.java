package ru.yandex.practicum.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.util.DataForTesting;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DropDownListTest {

    public final String accordionHeadingId;
    public final String accordionPanelId;

    public DropDownListTest(String accordionHeadingId, String accordionPanelId) {
        this.accordionHeadingId = accordionHeadingId;
        this.accordionPanelId = accordionPanelId;
    }

    @Rule
    public DriverFactory factory = new DriverFactory();

    @Parameterized.Parameters
    public static Collection<Object[]> getAccordion() {
        return Arrays.asList(DataForTesting.accordionTestData);
    }

    @Test
    public void testQuestionsDropDownListText() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnAcceptButton();
        mainPage.accordionHeadingClick(accordionHeadingId);
        mainPage.waitForPanelDisplay(accordionPanelId);
        Assert.assertTrue("Элемент с Id:" + accordionPanelId + " не отобразился.",
                driver.findElement(By.cssSelector(accordionPanelId)).isDisplayed());
    }
}
