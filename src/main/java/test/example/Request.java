package test.example;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class Request {
    private String input;

    public Request() { }
    public Request(JsonObject ob) {

    }

    public Request setInput(String input) {
        this.input = input;
        return this;
    }

    public String getInput() {
        return input;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        RequestConverter.toJson(this, json);
        return json;
    }
}
