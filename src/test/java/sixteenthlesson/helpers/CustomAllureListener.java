package sixteenthlesson.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

//Нужен для красивого отчета в алюре
public class CustomAllureListener {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }
}
