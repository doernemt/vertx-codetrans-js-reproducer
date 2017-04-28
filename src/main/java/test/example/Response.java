package test.example;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class Response {
    private boolean successful;
    private String message;

    public Response() { }
    public Response(JsonObject ob) {

    }

    public Response setSuccessful(boolean successful) {
        this.successful = successful;
        if(successful)
            message = "Success";
        else
            message = "Failure";
        return this;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        ResponseConverter.toJson(this, json);
        return json;
    }
}
