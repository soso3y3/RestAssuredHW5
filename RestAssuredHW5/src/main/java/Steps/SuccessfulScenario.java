package Steps;

import Models.Requests.SuccessfulRequest;
import Models.Responses.PassedScenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class SuccessfulScenario {
    private static Response response;

    public static void successfulScenario() {
        SuccessfulRequest successfulRequest_creds = new SuccessfulRequest("eve.holt@reqres.in", "pistol");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType("application/json");
        response = requestSpecification.body(successfulRequest_creds).post("https://reqres.in/api/register");

        if(response.statusCode() == 200){
            PassedScenario passed = response.as(PassedScenario.class);
            Assert.assertEquals("4", passed.id);
            Assert.assertEquals("QpwL5tke4Pnpja7X4", passed.token);
        }
        else
            Assert.fail();
    }
}
