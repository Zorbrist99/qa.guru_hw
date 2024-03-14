import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @Test
    void searchMonth (){
        Configuration.pageLoadStrategy = "eager";

        open("https://demoqa.com/automation-practice-form");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");

        sleep(10000);
    }
}
