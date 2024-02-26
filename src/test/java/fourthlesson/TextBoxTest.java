package fourthlesson;


import fourthlesson.pages.TextBox;
import org.junit.jupiter.api.Test;



public class TextBoxTest extends TestBase {

    TextBox textBox = new TextBox();

    @Test
    void registrationForm() {
        textBox.openPage()
                .setUserName("Sergey Ermolaev")
                .setEmail("trapeza@mail.com")
                .setAddress("Moscow, Lenina street, 183")
                .setPermanentAddress("Moscow, Lenina street, 184")
                .clickSubmit()
                .checkOutput("Name", "Sergey Ermolaev")
                .checkOutput("Email", "trapeza@mail.com")
                .checkOutput("Current Address", "Moscow, Lenina street, 183")
                .checkOutput("Permananet Address", "Moscow, Lenina street, 184");
    }
}
