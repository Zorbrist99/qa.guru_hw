package oneleson;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class PracticFormTests {


    @BeforeEach
    void Configuration() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        //Команда позволяет не ждать прогрузки страницы, а сразу искать элементы в доме
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void StudentRegistrationForm() {
        //Открыть экранную форму
        open("automation-practice-form");
        //!!Удалим не нужную рекламу при помощи команды из JavaScript!!
        executeJavaScript("$('.Google-Ad').remove()");

        //Ввести Имя
        $("#firstName").setValue("Sergey");
        //Ввести Фамилию
        $("#lastName").setValue("Ermolaev");
        //Ввести мэил
        $("#userEmail").setValue("zorbrist@mail.ru");
        //Выбрать пол
        $("#genterWrapper").$(withText("Male")).click();
        //Ввести номер
        $("#userNumber").setValue("89147833422");
        //Ввести дату рождения
        $("#dateOfBirthInput").click();
        //!! Команда selectOption может пригодиться когда в DOOM элементы расположены в формате тего <select> <option> </option> </select> !!
        $(".react-datepicker__month-select").selectOption("April");
        // Аналог команды выше, но более удленённый вариант
//        $(".react-datepicker__month-select").click();$(byText("April")).click();
        $(".react-datepicker__year-select").selectOption("1994");
//        $(".react-datepicker__year-select").click();$(byText("1994")).click();
        $(".react-datepicker__month").$(byText("10")).click();
        //Ввести пару предметов
        $("#subjectsInput").setValue("Economics").pressEnter();
        //Выбрать чекбокс хобби
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //Добавить картинку
        //!!!!При использовании метода uploadFromClasspath необходимо добавлять файл в специальную папку resources. Её необходимо располагать в папке test. В Этом случае файлы будут подтягиваться по имени.
        $("#uploadPicture").uploadFromClasspath("ForTest.png");
        //Ввести адрес
        $("#currentAddress").setValue("Russia, Moscow, 3rd street of builders");
        //Выбрать рандомно из двух выпадающех меню
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $(byText("Agra")).click();
        //Нажать кнопку обработки
        $("#submit").click();
        //Проверить результат в новом окне
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Sergey Ermolaev")).
                shouldHave(text("zorbrist@mail.ru")).
                shouldHave(text("Male")).
                shouldHave(text("8914783342")).
                shouldHave(text("10 April,1994")).
                shouldHave(text("Economics")).
                shouldHave(text("Reading")).
                shouldHave(text("ForTest.png")).
                shouldHave(text("Russia, Moscow, 3rd street of builders")).
                shouldHave(text("Uttar Pradesh Agra"));
        //Закрыть окно
        $(".modal-footer").$(byText("Close")).click();


    }
}
