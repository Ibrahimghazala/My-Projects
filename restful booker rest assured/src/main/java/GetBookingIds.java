import io.restassured.RestAssured;
import org.example.PayLoad;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookingIds {
    @Test
    public void getBookId(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        given().log().all().header("Content-Type","application/json")

                .when().get("booking")
                .then().log().all().assertThat().statusCode(200) ;

    }
    @Test
    public void getBookByname(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        given().log().all().header("Content-Type","application/json")

                .when().get("booking?firstname=sally&lastname=brown")
                .then().log().all().assertThat().statusCode(200) ;

    }
}
