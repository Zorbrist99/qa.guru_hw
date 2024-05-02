package eighteenthlesson.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static sixteenthlesson.helpers.CustomAllureListener.withCustomTemplates;

public class Spec {
        public static RequestSpecification userRequestSpec = with()
                //шаг для Allure
                .filter(withCustomTemplates())
                .log().body()
                .log().uri()
                .contentType(JSON);

        public static ResponseSpecification userResponseSpec = new ResponseSpecBuilder()
                .log(ALL)
                .build();

}
