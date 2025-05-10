import io.restassured.RestAssured;
import org.example.PayLoad;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBooking {
    @Test
    public void getBookId(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        given().log().all().header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(PayLoad.CreateBooking())

                .when().post("booking")
                .then().log().all().assertThat().statusCode(200) ;

    }
}
