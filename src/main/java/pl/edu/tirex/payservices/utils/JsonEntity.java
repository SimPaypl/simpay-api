package pl.edu.tirex.payservices.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.nio.charset.UnsupportedCharsetException;

public class JsonEntity extends StringEntity
{
    private static final Gson gson = new Gson();

    public JsonEntity(Object object) throws UnsupportedCharsetException
    {
        super(gson.toJson(object), ContentType.APPLICATION_JSON);
    }

    public JsonEntity(JsonElement element) throws UnsupportedCharsetException
    {
        super(gson.toJson(element), ContentType.APPLICATION_JSON);
    }

    public JsonEntity(String prefix, Object object)
    {
        super(gson.toJson(createJsonObject(prefix, object)), ContentType.APPLICATION_JSON);
    }

    private static JsonObject createJsonObject(String prefix, Object object)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(prefix, gson.toJsonTree(object));
        System.out.println(gson.toJson(jsonObject));
        return jsonObject;
    }
}
