import io.restassured.RestAssured;
import org.example.PayLoad;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogIn {
    @Test
    public void logIn(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
           given().log().all().header("Content-Type","application/json")
                .body(PayLoad.login())
                .when().post("auth")
                .then().log().all().assertThat().statusCode(200) ;

    }
}
