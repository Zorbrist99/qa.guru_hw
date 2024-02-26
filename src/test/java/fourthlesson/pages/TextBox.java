package fourthlesson.pages;

import com.codeborne.selenide.SelenideElement;
import fourthlesson.components.BaseElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBox {

    BaseElements baseElements = new BaseElements();

    private final SelenideElement userNameInput = $("#userName"),
            permanentAddressInput = $("#permanentAddress"),
            outputCheck = $("#output");

    public TextBox openPage() {
        open("text-box");
        return this;
    }

    public TextBox setUserName(String name) {
        userNameInput.setValue(name);
        return this;
    }

    public TextBox setEmail(String email) {
        baseElements.setUserEmail(email);
        return this;
    }

    public TextBox setAddress(String address) {
        baseElements.setAddress(address);
        return this;
    }

    public TextBox setPermanentAddress (String permanentAddress){
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBox clickSubmit() {
        baseElements.Submit();
        return this;
    }

    public TextBox checkOutput(String key, String value){
        outputCheck.shouldHave(text(key)).parent().shouldHave(text(value));
    return this;
    }
}
