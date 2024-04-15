package sixteenthlesson.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.http.ContentType.JSON;

public class SpecRequest {
    public static RequestSpecification userRequestSpec = with()
            .log().body()
            .log().uri()
            .contentType(JSON);

    public static ResponseSpecification userResponseSpec = new ResponseSpecBuilder()
            .log(BODY)
            .build();
}

