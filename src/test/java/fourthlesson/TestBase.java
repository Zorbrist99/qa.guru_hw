package fourthlesson;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;


public class TestBase {

    @BeforeAll
  public static void Configuration() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;


//        Faker faker = new Faker(new Locale("ru"));

//        String name = faker.name().firstName();
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//
//        String streetAddress = faker.address().streetAddress();
    }
}
