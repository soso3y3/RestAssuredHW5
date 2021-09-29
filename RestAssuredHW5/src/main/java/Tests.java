import Steps.InvalidParameters;
import org.testng.annotations.Test;

import static Steps.InvalidParameters.invalidParamCall;
import static Steps.SuccessfulScenario.successfulScenario;
import static Steps.UnsuccessfulScenario.unsuccessfulScenario;

public class Tests {

    @Test
    public void successfulTest(){
        successfulScenario();
    }
    @Test
    public void unSuccessfulTest(){
        unsuccessfulScenario();
    }
    @Test
    public void invalidParametersTest(){
        invalidParamCall();
    }
}
