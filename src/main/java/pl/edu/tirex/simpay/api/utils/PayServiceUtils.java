package pl.edu.tirex.simpay.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class PayServiceUtils
{
    private static Gson gson = new GsonBuilder().registerTypeAdapterFactory(new SkipArrayAdapterFactory()).create();
    private static HttpClient httpClient = HttpClients.createDefault();

    public static Gson getGson()
    {
        return gson;
    }

    public static void setGson(Gson gson)
    {
        PayServiceUtils.gson = gson;
    }

    public static HttpClient getHttpClient()
    {
        return httpClient;
    }

    public static void setHttpClient(HttpClient httpClient)
    {
        PayServiceUtils.httpClient = httpClient;
    }
}
