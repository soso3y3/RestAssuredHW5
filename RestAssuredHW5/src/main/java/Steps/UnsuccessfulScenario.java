package Steps;

import Models.Requests.UnsuccessfulRequest;
import Models.Responses.FailedScenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class UnsuccessfulScenario {
    private static Response response;

    public static void unsuccessfulScenario(){
        UnsuccessfulRequest unsuccessfulRequest = new UnsuccessfulRequest("sydney@fife");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType("application/json");
        response = requestSpecification.body(unsuccessfulRequest).post("https://reqres.in/api/register");

        if(response.statusCode() == 400){
            FailedScenario failed = response.as(FailedScenario.class);
            Assert.assertEquals("Missing password", failed.error);
        }
    }
}
