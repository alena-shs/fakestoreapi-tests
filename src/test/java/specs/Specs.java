package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.codeborne.selenide.Configuration.baseUrl;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class Specs {
    public static RequestSpecification requestSpec = with()
            .baseUri(baseUrl)
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .contentType(ContentType.JSON);

    public static ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
