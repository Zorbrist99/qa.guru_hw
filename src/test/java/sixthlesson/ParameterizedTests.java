package sixthlesson;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import sixthlesson.data.Language;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ParameterizedTests {

    @DisplayName("Проверка основных функций страницы")
    @Test
    @Tag("smoke")
    void mainFunctionsDisplayed() {
        open("https://steambalance.cc/");
        $(".information").shouldHave(text("Пополни баланс Steam СНГ"));
        // Отображаются поля Ваш логин и сумма введены какие-то значения
        $(".form-fill").$("[name=account]").setValue("ZORBRIST_09");
        $(".form-fill").$("[name=sum]").setValue("100");
        $(".form-methods").$("[value=freekassa-sbp]").click();
        $("#submit").$(byText("Пополнить")).click();
        $(".gray-text").shouldHave(text("Оплата через СБП")).shouldBe(visible);
    }

    @DisplayName("Короткая проверка пополнения игр из меню")
    @Tag("smoke")
    @ValueSource(strings = {
            "Brawl Stars",
            "Honkai Star Rail"
    })
    @ParameterizedTest
    void shortToppingUpGamesFromMenu(String value) {
        open("https://steambalance.cc/");
        $(".games-menu").$(byText(value)).click();
        $(".service-info__wrapper").shouldHave(text("Пополнение " + value)).shouldBe(visible);
    }


    @CsvSource(value = {
            "Brawl Stars, #Qdadw1312",
            "Honkai Star Rail, 345345323"
    })
    @ParameterizedTest(name = "Полноценная проверка пополнения {0} из меню для {1}")
    void longToppingUpGamesFromMenu(String game, String uid) {
        open("https://steambalance.cc/");
        $(".games-menu").$(byText(game)).click();
        $(".service-info__wrapper").shouldHave(text("Пополнение " + game)).shouldBe(visible);
        $("[name=account]").setValue(uid);
        $("#submit").$(byText("Пополнить")).click();
    }


    static Stream<Arguments> checkingTheCountry() {
        return Stream.of(
                Arguments.of(Language.English, List.of("Catalog\n" + "Teaching\n")),
                Arguments.of(Language.Русский, List.of("Каталог\n" + "Преподавание\n"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка отображения разделов на языке {0} {1}")
    void checkingTheCountry(Language language, List<String> value) {
        open("https://stepik.org/catalog");
        $("#ember670").click();
        $(".drop-down__body").$(byText(language.name())).click();
        $$(".navbar__links").filter(visible).shouldHave(texts(value));
    }
}

