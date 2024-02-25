package fourthLesson.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    public static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select"),
            dayInput = $(".react-datepicker__month"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper").$(byText("Select State")),
            cityInput = $("#stateCity-wrapper").$(byText("Select City")),
            submitClick = $("#submit"),
            thanksChack = $(".modal-content"),
            finalWindow = $(".table-responsive"),
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
        userEmailInput.setValue(mail);
        return this;
    }

    public RegistrationForm chooseGenterWrapper(String gender) {
        genterWrapperInput.$(withText(gender)).click();
        return this;
    }

    public RegistrationForm setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationForm setDateOfBirthday(String year, String month, String day) {
        dateOfBirthInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.$(byText(day)).click();
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
        addressInput.setValue(address);
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
        submitClick.click();
        return this;
    }

    public RegistrationForm shouldTextThanks(String thanks) {
        thanksChack.shouldHave(text(thanks));
        return this;
    }

    public RegistrationForm checkFinalValue(String key, String value) {
        finalWindow.shouldHave(text(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationForm setClose(String value) {
        closeClick.$(byText(value)).click();
        return this;
    }


}
