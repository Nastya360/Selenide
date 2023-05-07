package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldRegisterByAccountNumberDOMModification() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:7777");
        $("[data-test-id =city] input").setValue("Майкоп");
        $("[data-test-id =date] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id =date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id =date] input").setValue("20.05.2023");
        $("[data-test-id=name] input").setValue("Иванов Сергей");
        $("[data-test-id=phone] input").setValue("+79218875800");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Забронировать")).shouldBe(visible);
        $(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));

    }

}

