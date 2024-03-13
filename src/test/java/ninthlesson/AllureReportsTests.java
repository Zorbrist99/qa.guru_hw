package ninthlesson;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.qameta.allure.Allure.attachment;

public class AllureReportsTests {

    private static final String PROJECT = "qa-guru";
    private static final String ISSUES = "[BUG] Список всех пользователей.";

    @Test
    @DisplayName("Тест без прописанных шагов ")
    void searchIssueInGitHubClean() {
        //Строчка кода позволяет прокидывать шаги selenide в Allure отчет
        SelenideLogger.addListener("allure", new AllureSelenide());

        //Зайти на гит хаб
        open("https://github.com/");
        //Найти окно поиска
        $(".search-input").shouldHave(text("Search or jump to...")).click();
        //Вбить в поиске название какого-то проекта
        $("#query-builder-test").setValue("qa-guru").pressEnter();
        //Перейти в него
        $("[data-testid='results-list']").$(byText("qa-guru/niffler")).click();
        //Найти раздел ишью и перейти в него
        $("#issues-tab").click();
        //Найти какой-то запрос
        $("#issue_85").shouldHave(text("[BUG] Список всех пользователей.")).shouldBe(visible);
    }

    @Test
    @DisplayName("Тест с прописанными шагами через Лямбда")
    void searchIssueInGitHubWithStepsLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Зайти на гит хаб", () -> {
            open("https://github.com/");
            // Эта каманда отвечает за добавление в Allure файла с логами. В "как будет называться файл"
            attachment("Log", webdriver().driver().source());
        });

        step("Найти окно поиска", () -> {
            $(".search-input").shouldHave(text("Search or jump to...")).click();
        });

        step("Вбить в поиске название проекта " + PROJECT, () -> {
            $("#query-builder-test").setValue(PROJECT).pressEnter();
        });

        step("Перейти в проект " + PROJECT, () -> {
            $("[data-testid='results-list']").$(byText("qa-guru/niffler")).click();
        });

        step("Найти на странице раздел Issues и перейти в него", () -> {
            $("#issues-tab").click();
        });

        step("Проверить наличие в списке раздела " + ISSUES, () -> {
            $("#issue_85").shouldHave(text(ISSUES)).shouldBe(visible);
        });

    }

    @Test
    @DisplayName("Тест с прописанными шагами в PageObject")
    void searchIssueInGitHubWithStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsAllureReports stepsAllureReports = new StepsAllureReports();

        stepsAllureReports.openWindow();
        stepsAllureReports.searchWindowSearcher();
        stepsAllureReports.setNameProject(PROJECT);
        stepsAllureReports.openProject();
        stepsAllureReports.searchIssues();
        stepsAllureReports.visibleIssues(ISSUES);

    }
}
