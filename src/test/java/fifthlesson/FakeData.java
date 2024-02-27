package fifthlesson;

import com.github.javafaker.Faker;


public class FakeData {


    static Faker faker = new Faker();
    static String name,lastName, number, birthdayYear, birthdayMonth,
            birthdayDay, subjects, hobbies, picture, state, city, mail,
            gender, address;

    public static String setName() {
        return name = faker.name().firstName();
    }

    public static String setLastName() {
        return lastName = faker.name().firstName();
    }

    public static String setMail() {
        return mail = faker.internet().emailAddress();
    }

    public static String setGender() {
        return gender = faker.demographic().sex();
    }

    public static String setNumber() {
        return number = faker.phoneNumber().subscriberNumber(10);
    }

    public static String setBirthdayYear() {
        return birthdayYear = String.valueOf(faker.number().numberBetween(1900, 2023));
    }

    public static String setBirthdayMonth() {
        return birthdayMonth = String.valueOf(faker.options().option("January","February","March","April","May","June","July","August","September","October","November","December"));
    }

    public static String setBirthdayDay() {
        return birthdayDay = String.valueOf(faker.number().numberBetween(1, 29));
    }

    public static String setSubjects() {
        return subjects = String.valueOf(faker.options().option("English","Hindi","Accouting","Economics"));
    }

    public static String setHobbies() {
        return hobbies = String.valueOf(faker.options().option("Sports","Reading","Music"));
    }

    public static String setPicture() {
        return picture = String.valueOf(faker.options().option("ForTest.png","ForTest2.png"));
    }

    public static String setAddress() {
        return address = faker.address().fullAddress();
    }

    public static String setState() {
        return state = String.valueOf(faker.options().option("NCR","Uttar Pradesh","Haryana","Rajasthan"));
    }

    public static String setCity() {
        String cityNcr = String.valueOf(faker.options().option("Delhi", "Gurgaon", "Noida"));
        String cityUttarPradesh = String.valueOf(faker.options().option("Agra", "Lucknow", "Merrut"));
        String cityHaryana = String.valueOf(faker.options().option("Merrut", "Panipat"));
        String cityRajasthan = String.valueOf(faker.options().option("Jaipur", "Jaiselmer"));

        if (state == "NCR") {
            city = cityNcr;
        } else if (state == "Uttar Pradesh") {
            city = cityUttarPradesh;
        } else if (state == "Haryana") {
            city = cityHaryana;
        } else if (state == "Rajasthan") {
            city = cityRajasthan;
        }
        return city;
    }
    }
