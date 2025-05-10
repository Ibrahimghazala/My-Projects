import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Getbook {
    @Test
    public void getBook(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        given().log().all().header("Accept","application/json")

                .when().get("booking/1")
                .then().log().all().assertThat().statusCode(200) ;

    }
}
