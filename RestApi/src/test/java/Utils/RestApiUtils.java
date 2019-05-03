package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestApiUtils {
    public static JsonPath rawToJson(Response response) {
        String resp = response.asString();
        return new JsonPath(resp);
    }
}
