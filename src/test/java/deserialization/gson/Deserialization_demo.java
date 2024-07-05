package deserialization.gson;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class Deserialization_demo {
    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;


  //  @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStyleGETPositive() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        Gson gson = new Gson();
        Booking booking = gson.fromJson(responseString, Booking.class);
        System.out.println(booking.toString());


        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}


