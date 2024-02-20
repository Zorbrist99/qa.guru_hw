package secondLesson;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FindAlementInGithubTests {

    @Test
    void findJUnit5InSoftAssertions() {
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }""")).shouldBe(visible);
        $(".markdown-body").shouldHave(text("""
                class Tests {
                  @RegisterExtension\s
                  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();

                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """)).shouldBe(visible);
        //!!!Для того, что бы проверить кусок кода на странице, достаточно прописать команду shouldHave(text("Код который нужно проверить")) **Называется  "Многострочные строковые литералы"**  !!!
    }
}
