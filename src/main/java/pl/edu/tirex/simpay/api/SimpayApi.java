package pl.edu.tirex.simpay.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import pl.edu.tirex.simpay.api.connection.SimpayStatusRequest;
import pl.edu.tirex.simpay.api.connection.SimpayStatusResponse;
import pl.edu.tirex.simpay.api.models.SimpayAuth;
import pl.edu.tirex.simpay.api.models.SimpayStatusParameters;
import pl.edu.tirex.simpay.api.utils.JsonEntity;
import pl.edu.tirex.simpay.api.utils.PayServiceUtils;

import java.io.IOException;
import java.io.InputStreamReader;

public class SimpayApi
{
    private static final int SIMPAY_API_VERSION = 1;
    private final SimpayAuth auth;
    private final int version;

    public SimpayApi(String key, String secret)
    {
        this(key, secret, SIMPAY_API_VERSION);
    }

    public SimpayApi(String key, String secret, int version)
    {
        this.auth = new SimpayAuth(key, secret);
        this.version = version;
    }

    public SimpayAuth getAuth()
    {
        return auth;
    }

    public int getVersion()
    {
        return version;
    }

    public SimpayStatusResponse getStatus(int serviceId, int number, String code) throws IOException
    {
        SimpayStatusParameters parameters = new SimpayStatusParameters(this.auth, serviceId, number, code);
        SimpayStatusRequest statusRequest = new SimpayStatusRequest(parameters);

        HttpClient httpClient = PayServiceUtils.getHttpClient();

        HttpPost post = new HttpPost("https://simpay.pl/api/" + this.version + "/status");
        post.setEntity(new JsonEntity(statusRequest));

        HttpResponse httpResponse = httpClient.execute(post);
        SimpayStatusResponse statusResponse = PayServiceUtils.getGson().fromJson(new InputStreamReader(httpResponse.getEntity().getContent()), SimpayStatusResponse.class);

        return statusResponse;
    }
}
