import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.PayLoad;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking {
    @Test
    public void test(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        String Responce =   given().log().all().header("Content-Type","application/json")
                .body(PayLoad.login())
                .when().post("auth")
                .then().assertThat().extract().response().asString() ;
        JsonPath js = new JsonPath(Responce) ;
        String token  = js.getString("token") ;
        given().log().all().header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","token="+token+"")
                .body(PayLoad.CreateBooking())
                .when().put("booking/2")
                .then().log().all().assertThat().statusCode(200) ;
    }


}
