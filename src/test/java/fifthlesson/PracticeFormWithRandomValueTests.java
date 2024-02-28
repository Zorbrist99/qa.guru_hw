package fifthlesson;


import fourthlesson.TestBase;
import fourthlesson.pages.RegistrationForm;
import org.junit.jupiter.api.Test;

import static fifthlesson.FakeData.*;
import static fifthlesson.FakeData.setMail;


public class PracticeFormWithRandomValueTests extends TestBase {
    RegistrationForm registrationForm = new RegistrationForm();
    String name = setName(),
            lastName = setLastName(),
            mail = setMail(),
            gender = setGender(),
            number = setNumber(),
            birthdayMonth = setBirthdayMonth(),
            birthdayYear = setBirthdayYear(),
            birthdayDay = setBirthdayDay(),
            subjects = setSubjects(),
            hobbies = setHobbies(),
            picture = setPicture(),
            address = setAddress(),
            state = setState(),
            city = setCity();

    @Test
    void studentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(mail)
                .chooseGenderWrapper(gender)
                .setUserNumber(number)
                .setDateOfBirthday(birthdayMonth, birthdayYear, birthdayDay)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .shouldTextThanks("Thanks for submitting the form")
                .checkFinalValue("Student Name", name + " " + lastName)
                .checkFinalValue("Student Email", mail)
                .checkFinalValue("Gender", gender)
                .checkFinalValue("Mobile", number)
                .checkFinalValue("Date of Birth", birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                .checkFinalValue("Subjects", subjects)
                .checkFinalValue("Hobbies", hobbies)
                .checkFinalValue("Picture", picture)
                .checkFinalValue("Address", address)
                .checkFinalValue("State and City", state + " " + city)
                .setClose("Close");
    }

    @Test
    void shortStudentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(mail)
                .chooseGenderWrapper(gender)
                .setUserNumber(number)
                .setDateOfBirthday(birthdayMonth, birthdayYear, birthdayDay)
                .setAddress(address)
                .clickSubmit()
                .shouldTextThanks("Thanks for submitting the form")
                .checkFinalValue("Student Name", name + " " + lastName)
                .checkFinalValue("Student Email", mail)
                .checkFinalValue("Gender", gender)
                .checkFinalValue("Mobile", number)
                .checkFinalValue("Date of Birth", birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                .checkFinalValue("Address", address)
                .setClose("Close");
    }

    @Test
    void negativeStudentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(name)
                .setUserEmail(mail)
                .chooseGenderWrapper(gender)
                .setUserNumber(number)
                .setDateOfBirthday(birthdayMonth, birthdayYear, birthdayDay)
                .setAddress(address)
                .clickSubmit()
                .visibleFinalWindow();
    }
}
