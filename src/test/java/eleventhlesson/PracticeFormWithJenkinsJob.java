package eleventhlesson;

import com.codeborne.selenide.logevents.SelenideLogger;
import fourthlesson.TestBase;
import fourthlesson.pages.RegistrationForm;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static ninthlesson.attachments.Attach.screenshotAs;

public class PracticeFormWithJenkinsJob extends TestBase {


        RegistrationForm registrationForm = new RegistrationForm();

        @Test
        @Feature("Форма регистрации")
        @Story("Заполнение формы регистрации")
        @Owner("ermolaevcc")
        @Severity(SeverityLevel.NORMAL)
        @Tag("simple")
        @DisplayName("Проверка формы регистрации")
        void RegistrationForm() {
            registrationForm.openPage()
                    .setFirstName("Sergey")
                    .setLastName("Ermolaev")
                    .setUserEmail("zorbrist@mail.ru")
                    .chooseGenderWrapper("Male")
                    .setUserNumber("89147833422")
                    .setDateOfBirthday("April", "1994", "10")
                    .setSubjects("Economics")
                    .setHobbies("Reading")
                    .uploadPicture("ForTest.png")
                    .setAddress("Russia, Moscow, 3rd street of builders")
                    .setState("Uttar Pradesh")
                    .setCity("Agra")
                    .clickSubmit()
                    .shouldTextThanks("Thanks for submitting the form")
                    .checkFinalValue("Student Name", "Sergey Ermolaev")
                    .checkFinalValue("Student Email", "zorbrist@mail.ru")
                    .checkFinalValue("Gender", "Male")
                    .checkFinalValue("Mobile", "8914783342")
                    .checkFinalValue("Date of Birth", "10 April,1994")
                    .checkFinalValue("Subjects", "Economics")
                    .checkFinalValue("Hobbies", "Reading")
                    .checkFinalValue("Picture", "ForTest.png")
                    .checkFinalValue("Address", "Russia, Moscow, 3rd street of builders")
                    .checkFinalValue("State and City", "Uttar Pradesh Agra");
        }
    }
