package fourthlesson.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import fourthlesson.components.BaseElements;
import fourthlesson.components.CalendarComponent;
import fourthlesson.components.ResultWindow;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import ninthlesson.attachments.Attach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultWindow resultWindow = new ResultWindow();
    BaseElements baseElements = new BaseElements();
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            stateInput = $("#stateCity-wrapper").$(byText("Select State")),
            cityInput = $("#stateCity-wrapper").$(byText("Select City")),
            thanksCheck = $(".modal-content"),
            closeClick = $(".modal-footer");


    @Step("Открыть страницу")
    public RegistrationForm openPage() {
        open("automation-practice-form");
        executeJavaScript("$('.Google-Ad').remove()");
        executeJavaScript("$('#fixedban').remove()");
        Attach.screenshotAs( "Скрин");
        return this;
    }

    @Step("Ввести имя")
    public RegistrationForm setFirstName(String name) {
        firstNameInput.setValue(name);
        Attach.screenshotAs( "Скрин");
        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationForm setLastName(String family) {
        lastNameInput.setValue(family);
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Ввести почту")
    public RegistrationForm setUserEmail(String mail) {
        baseElements.setUserEmail(mail);
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Выбрать пол")
    public RegistrationForm chooseGenderWrapper(String gender) {
        genderWrapperInput.$(withText(gender)).click();
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Ввести номер телефона")
    public RegistrationForm setUserNumber(String number) {
        userNumberInput.setValue(number);
        Attach.screenshotAs( "Скрин");
        return this;
    }

    @Step("Выбрать дату рождения")
    public RegistrationForm setDateOfBirthday(String month, String year, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Ввести предмет")
    public RegistrationForm setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Выбрать хобби")
    public RegistrationForm setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        Attach.screenshotAs( "Скрин");
        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationForm uploadPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Ввести адрес")
    public RegistrationForm setAddress(String address) {
        baseElements.setAddress(address);
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Выбрать страну")
    public RegistrationForm setState(String state) {
        stateInput.click();
        $(byText(state)).click();
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Выбрать город")
    public RegistrationForm setCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Подтвердить данные")
    public RegistrationForm clickSubmit() {
       baseElements.Submit();
        Attach.screenshotAs( "Скрин");
       return this;
    }

    @Step("Убедиться что окно с введёной информацией отображается")
    public RegistrationForm visibleFinalWindow(){
        thanksCheck.shouldNot(appear);
        Attach.screenshotAs( "Скрин");
        return this;
    }
    @Step("Проверить присутствие текста {thanks}")
    public RegistrationForm shouldTextThanks(String thanks) {
        thanksCheck.shouldHave(text(thanks));
        Attach.screenshotAs( "Скрин");
        return this;
    }

    @Step("Проверить присутствие текста {key} и {value}")
    public RegistrationForm checkFinalValue(String key, String value) {
        resultWindow.checkResult(key, value);
        Attach.screenshotAs( "Скрин");
        return this;
    }

    @Step("Закрыть окно")
    public RegistrationForm setClose(String value) {
        closeClick.$(byText(value)).click();
        Attach.screenshotAs( "Скрин");
        return this;
    }

}
