package fourthlesson.pages;

import com.codeborne.selenide.SelenideElement;
import fourthlesson.components.BaseElements;
import fourthlesson.components.CalendarComponent;
import fourthlesson.components.ResultWindow;

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


    public RegistrationForm openPage() {
        open("automation-practice-form");
        executeJavaScript("$('.Google-Ad').remove()");
        return this;
    }

    public RegistrationForm setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationForm setLastName(String family) {
        lastNameInput.setValue(family);
        return this;
    }

    public RegistrationForm setUserEmail(String mail) {
        baseElements.setUserEmail(mail);
        return this;
    }

    public RegistrationForm chooseGenderWrapper(String gender) {
        genderWrapperInput.$(withText(gender)).click();
        return this;
    }

    public RegistrationForm setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationForm setDateOfBirthday(String month, String year, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public RegistrationForm setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationForm setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationForm uploadPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationForm setAddress(String address) {
        baseElements.setAddress(address);
        return this;
    }

    public RegistrationForm setState(String state) {
        stateInput.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationForm setCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationForm clickSubmit() {
       baseElements.Submit();
        return this;
    }

    public RegistrationForm visibleFinalWindow(){
        thanksCheck.shouldNot(appear);
        return this;
    }

    public RegistrationForm shouldTextThanks(String thanks) {
        thanksCheck.shouldHave(text(thanks));
        return this;
    }

    public RegistrationForm checkFinalValue(String key, String value) {
        resultWindow.checkResult(key, value);
        return this;
    }

    public RegistrationForm setClose(String value) {
        closeClick.$(byText(value)).click();
        return this;
    }



}
