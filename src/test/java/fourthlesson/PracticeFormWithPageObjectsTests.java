package fourthlesson;

import fourthlesson.pages.RegistrationForm;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTests extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    @Test
    void studentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName("Sergey")
                .setLastName("Ermolaev")
                .setUserEmail("zorbrist@mail.ru")
                .chooseGenderWrapper("Male")
                .setUserNumber("89147833422")
                .setDateOfBirthday("1994", "April", "10")
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
                .checkFinalValue("State and City", "Uttar Pradesh Agra")
                .setClose("Close");
    }

    @Test
    void shortStudentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName("Sergey")
                .setLastName("Ermolaev")
                .setUserEmail("zorbrist@mail.ru")
                .chooseGenderWrapper("Male")
                .setUserNumber("89147833422")
                .setDateOfBirthday("1994", "April", "10")
                .setAddress("Russia, Moscow, 3rd street of builders")
                .clickSubmit()
                .shouldTextThanks("Thanks for submitting the form")
                .checkFinalValue("Student Name", "Sergey Ermolaev")
                .checkFinalValue("Student Name", "Sergey Ermolaev")
                .checkFinalValue("Student Email", "zorbrist@mail.ru")
                .checkFinalValue("Gender", "Male")
                .checkFinalValue("Mobile", "8914783342")
                .checkFinalValue("Date of Birth", "10 April,1994")
                .checkFinalValue("Address", "Russia, Moscow, 3rd street of builders")
                .setClose("Close");
    }

    @Test
    void negativeStudentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName("Sergey")
                .setUserEmail("zorbrist@mail.ru")
                .chooseGenderWrapper("Male")
                .setUserNumber("89147833422")
                .setDateOfBirthday("1994", "April", "10")
                .setAddress("Russia, Moscow, 3rd street of builders")
                .clickSubmit()
                .visibleFinalWindow();
    }
}
