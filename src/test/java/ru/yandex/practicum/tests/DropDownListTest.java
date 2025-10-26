package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;

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
        return Arrays.asList(MainPage.accordionTestData);
    }

    @Test
    public void testQuestionsDropDownListText() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnAcceptButton();
        mainPage.accordionHeadingClick(accordionHeadingId);
        mainPage.panelDisplayCheck(accordionPanelId);
    }
}
