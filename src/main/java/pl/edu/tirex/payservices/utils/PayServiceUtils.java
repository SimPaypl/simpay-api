package pl.edu.tirex.payservices.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PayServiceUtils
{
    private static Gson gson = new GsonBuilder().registerTypeAdapterFactory(new SkipArrayAdapterFactory()).create();

    public static Gson getGson()
    {
        return gson;
    }

    public static void setGson(Gson gson)
    {
        PayServiceUtils.gson = gson;
    }
}
