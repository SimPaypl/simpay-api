package pl.edu.tirex.simpay.api.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
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
}
