package ninthlesson;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsAllureReports {

    @Step("Зайти на гит хаб")
    public void openWindow() {
        open("https://github.com/");
    }

    @Step("Найти окно поиска")
    public void searchWindowSearcher() {
        $(".search-input").shouldHave(text("Search or jump to...")).click();
    }

    @Step("Вбить в поиске название проекта {project}")
    public void setNameProject(String project) {
        $("#query-builder-test").setValue(project).pressEnter();
    }

    @Step("Перейти в проект")
    public void openProject (){
        $("[data-testid='results-list']").$(byText("qa-guru/niffler")).click();
    }

    @Step("Найти на странице раздел Issues и перейти в него")
    public void searchIssues (){
        $("#issues-tab").click();
    }

    @Step("Проверить наличие в списке раздела {issues}")
        public void visibleIssues (String issues) {
            $("#issue_85").shouldHave(text(issues)).shouldBe(visible);
        }
    }

