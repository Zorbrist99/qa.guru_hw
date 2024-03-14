package ninthlesson;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsAllureReports {

    @Step("Зайти на гит хаб")
    public void openWindow() {
        open("https://github.com/");
        takeScreenshot();
    }

    @Step("Найти окно поиска")
    public void searchWindowSearcher() {
        $(".search-input").shouldHave(text("Search or jump to...")).click();
        takeScreenshot();
    }

    @Step("Вбить в поиске название проекта {project}")
    public void setNameProject(String project) {
        $("#query-builder-test").setValue(project).pressEnter();
        takeScreenshot();
    }

    @Step("Перейти в проект")
    public void openProject() {
        $("[data-testid='results-list']").$(byText("qa-guru/niffler")).click();
        takeScreenshot();
    }


    @Step("Найти на странице раздел Issues и перейти в него")
    public void searchIssues() {
        $("#issues-tab").click();
        takeScreenshot();
    }

    @Step("Проверить наличие в списке раздела {issues}")
    public void visibleIssues(String issues) {
        $("#issue_85").shouldHave(text(issues)).shouldBe(visible);
        takeScreenshot( );
    }

    //При помощи этого кода, мы сможем скринить каждый шаг теста и перекидывать в Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

