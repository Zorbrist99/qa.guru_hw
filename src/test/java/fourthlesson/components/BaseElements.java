package fourthlesson.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BaseElements {

    private final SelenideElement userEmailInput = $("#userEmail"),
            addressInput = $("#currentAddress"),
            submitClick = $("#submit");

    public BaseElements setUserEmail(String mail) {
        userEmailInput.setValue(mail);
        return this;
    }

    public BaseElements setAddress(String address){
        addressInput.setValue(address);
        return this;
    }
    public BaseElements Submit() {
        submitClick.click();
        return this;
    }

}
