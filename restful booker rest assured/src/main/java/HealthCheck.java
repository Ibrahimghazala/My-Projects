import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HealthCheck {
    @Test
    public void getBook(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        given().log().all().header("Content-Type","application/json")

                .when().get("ping")
                .then().log().all().assertThat().statusCode(201) ;

    }
}
