package fifthlesson;


import fourthlesson.TestBase;
import fourthlesson.pages.RegistrationForm;
import org.junit.jupiter.api.Test;
import static fifthlesson.FakeData.*;
import static fifthlesson.FakeData.setMail;


public class PracticeFormWithRandomValueTests extends TestBase {
    RegistrationForm registrationForm = new RegistrationForm();
    String Name = setName(),
            LastName = setLastName(),
            Mail = setMail(),
            Gender = setGender(),
            Number = setNumber(),
            BirthdayMonth = setBirthdayMonth(),
            BirthdayYear = setBirthdayYear(),
            BirthdayDay = setBirthdayDay(),
            Subjects = setSubjects(),
            Hobbies = setHobbies(),
            Picture = setPicture(),
            Address = setAddress(),
            State = setState(),
            City = setCity();
    @Test
    void studentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(Name)
                .setLastName(LastName)
                .setUserEmail(Mail)
                .chooseGenderWrapper(Gender)
                .setUserNumber(Number)
                .setDateOfBirthday(BirthdayMonth, BirthdayYear, BirthdayDay)
                .setSubjects(Subjects)
                .setHobbies(Hobbies)
                .uploadPicture(Picture)
                .setAddress(Address)
                .setState(State)
                .setCity(City)
                .clickSubmit()
                .shouldTextThanks("Thanks for submitting the form")
                .checkFinalValue("Student Name", Name + " " + LastName)
                .checkFinalValue("Student Email", Mail)
                .checkFinalValue("Gender",Gender)
                .checkFinalValue("Mobile", Number)
                .checkFinalValue("Date of Birth", BirthdayDay + " " + BirthdayMonth + "," + BirthdayYear)
                .checkFinalValue("Subjects", Subjects)
                .checkFinalValue("Hobbies", Hobbies)
                .checkFinalValue("Picture", Picture)
                .checkFinalValue("Address", Address)
                .checkFinalValue("State and City", State + " " + City)
                .setClose("Close");
    }

    @Test
    void shortStudentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(Name)
                .setLastName(LastName)
                .setUserEmail(Mail)
                .chooseGenderWrapper(Gender)
                .setUserNumber(Number)
                .setDateOfBirthday(BirthdayMonth, BirthdayYear, BirthdayDay)
                .setAddress(Address)
                .clickSubmit()
                .shouldTextThanks("Thanks for submitting the form")
                .checkFinalValue("Student Name", Name + " " + LastName)
                .checkFinalValue("Student Email", Mail)
                .checkFinalValue("Gender", Gender)
                .checkFinalValue("Mobile", Number)
                .checkFinalValue("Date of Birth", BirthdayDay + " " + BirthdayMonth + "," + BirthdayYear)
                .checkFinalValue("Address", Address)
                .setClose("Close");
    }

    @Test
    void negativeStudentRegistrationForm() {
        registrationForm.openPage()
                .setFirstName(Name)
                .setUserEmail(Mail)
                .chooseGenderWrapper(Gender)
                .setUserNumber(Number)
                .setDateOfBirthday(BirthdayMonth, BirthdayYear, BirthdayDay)
                .setAddress(Address)
                .clickSubmit()
                .visibleFinalWindow();
    }
}
