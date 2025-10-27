package ru.yandex.practicum.pages.util;

import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage;

import java.util.Arrays;
import java.util.Collection;

public class DataForTesting {

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

    public static Collection<Object[]> getOrderTestData() {
        return Arrays.asList(new Object[][]{
                {MainPage.upperOrderButton, "Иван", "Подпивасов", "Москва, ул. Академика Янгеля д.14",
                        "Улица Академика Янгеля", "+79777777777", "10.11.2025", OrderPage.rentPeriodFirst, OrderPage.blackPearlCheckBox,
                        "Доставить после 12:00"},
                {MainPage.lowerOrderButton, "Алексей", "Пивоваров", "Москва ул. Пушкина д.Колотушкина",
                        "Пушкинская", "89153496329", "25.12.2025", OrderPage.rentPeriodSecond,
                        OrderPage.greyHopeless, "Позвонить за пол часа"}
        });
    }
}
