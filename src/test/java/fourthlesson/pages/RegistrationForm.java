package fourthlesson.pages;

import com.codeborne.selenide.SelenideElement;
import fourthlesson.components.BaseElements;
import fourthlesson.components.CalendarComponent;
import fourthlesson.components.ResultWindow;
import io.qameta.allure.Step;

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
        return this;
    }

    @Step("Ввести имя")
    public RegistrationForm setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationForm setLastName(String family) {
        lastNameInput.setValue(family);
        return this;
    }
    @Step("Ввести почту")
    public RegistrationForm setUserEmail(String mail) {
        baseElements.setUserEmail(mail);
        return this;
    }
    @Step("Выбрать пол")
    public RegistrationForm chooseGenderWrapper(String gender) {
        genderWrapperInput.$(withText(gender)).click();
        return this;
    }
    @Step("Ввести номер телефона")
    public RegistrationForm setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    @Step("Выбрать дату рождения")
    public RegistrationForm setDateOfBirthday(String month, String year, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }
    @Step("Ввести предмет")
    public RegistrationForm setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }
    @Step("Выбрать хобби")
    public RegistrationForm setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationForm uploadPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);
        return this;
    }
    @Step("Ввести адрес")
    public RegistrationForm setAddress(String address) {
        baseElements.setAddress(address);
        return this;
    }
    @Step("Выбрать страну")
    public RegistrationForm setState(String state) {
        stateInput.click();
        $(byText(state)).click();
        return this;
    }
    @Step("Выбрать город")
    public RegistrationForm setCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }
    @Step("Подтвердить данные")
    public RegistrationForm clickSubmit() {
       baseElements.Submit();
        return this;
    }

    @Step("Убедиться что окно с введёной информацией отображается")
    public RegistrationForm visibleFinalWindow(){
        thanksCheck.shouldNot(appear);
        return this;
    }
    @Step("Проверить присутствие текста {thanks}")
    public RegistrationForm shouldTextThanks(String thanks) {
        thanksCheck.shouldHave(text(thanks));
        return this;
    }

    @Step("Проверить присутствие текста {key} и {value}")
    public RegistrationForm checkFinalValue(String key, String value) {
        resultWindow.checkResult(key, value);
        return this;
    }

    @Step("Закрыть окно")
    public RegistrationForm setClose(String value) {
        closeClick.$(byText(value)).click();
        return this;
    }



}
