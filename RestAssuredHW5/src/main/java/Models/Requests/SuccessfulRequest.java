package Models.Requests;

import org.json.simple.JSONObject;

public class SuccessfulRequest {
    public String email;
    public String password;

    public SuccessfulRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
