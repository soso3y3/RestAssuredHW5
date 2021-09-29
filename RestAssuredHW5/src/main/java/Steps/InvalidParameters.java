package Steps;

import Models.Requests.InvalidParamCall;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class InvalidParameters {
    private static Response response;
    public static void invalidParamCall(){
        InvalidParamCall invalidParamCall = new InvalidParamCall("morpheus","leader");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType("application/json");
        response = requestSpecification.body(invalidParamCall).post("https://reqres.in/api/users");

        if (response.statusCode() != 201){
            Assert.fail();
        }
    }
}
