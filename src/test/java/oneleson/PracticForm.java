package oneleson;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticForm {


    @BeforeEach
     void Configuration(){
        Configuration.holdBrowserOpen=true;
        Configuration.baseUrl="https://demoqa.com/";
        Configuration.timeout=5000;
        Configuration.browserSize="1920X1080";
        //Команда позволяет не ждать прогрузки страницы, а сразу искать элементы в доме
        Configuration.pageLoadStrategy="eager";

    }
    @Test
    void StudentRegistrationForm(){
        //Открыть экранную форму
        open("automation-practice-form");
        //Ввести Имя
        $("#firstName").setValue("Sergey");
        //Ввести Фамилию
        $("#lastName").setValue("Ermolaev");
        //Ввести мэил
        $("#userEmail").setValue("zorbrist@mail.ru");
        //Выбрать пол
        $("#genterWrapper").$(byText("Male")).click();
        //Ввести номер
        $("#userNumber").setValue("89147833422");
        //Ввести дату рождения
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").click();$(byText("April")).click();
        $(".react-datepicker__year-select").click();$(byText("1994")).click();
        $(".react-datepicker__month").$(byText("10")).click();
        //Ввести пару предметов
        $("#subjectsInput").setValue("Economics").pressEnter();
        //Выбрать чекбокс хобби
        //Добавить картинку
        //Ввести адрес
        //Выбрать рандомно из двух выпадающех меню
        //Нажать кнопку обработки
        //Проверить результат в новом окне


    }
}
