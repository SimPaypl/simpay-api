package pl.edu.tirex.simpay.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import pl.edu.tirex.simpay.api.connection.SimpayStatusRequest;
import pl.edu.tirex.simpay.api.connection.SimpayStatusResponse;
import pl.edu.tirex.simpay.api.models.SimpayAuth;
import pl.edu.tirex.simpay.api.models.SimpayStatusParameters;
import pl.edu.tirex.simpay.api.models.SimpayStatusRespond;
import pl.edu.tirex.simpay.api.utils.JsonEntity;
import pl.edu.tirex.simpay.api.utils.PayServiceUtils;

import java.io.IOException;
import java.io.InputStreamReader;

public class SimpayApi
{
    private static final int SIMPAY_API_VERSION = 1;
    private final String key;
    private final String secret;
    private final int version;

    public SimpayApi(String key, String secret)
    {
        this(key, secret, SIMPAY_API_VERSION);
    }

    public SimpayApi(String key, String secret, int version)
    {
        this.key = key;
        this.secret = secret;
        this.version = version;
    }

    public String getKey()
    {
        return key;
    }

    public String getSecret()
    {
        return secret;
    }

    public int getVersion()
    {
        return version;
    }

    public SimpayStatusRespond getStatus(int serviceId, int number, String code) throws IOException
    {
        SimpayAuth auth = new SimpayAuth(this.key, this.secret);
        SimpayStatusParameters parameters = new SimpayStatusParameters(auth, serviceId, number, code);
        SimpayStatusRequest statusRequest = new SimpayStatusRequest(parameters);

        HttpClient httpClient = PayServiceUtils.getHttpClient();

        HttpPost post = new HttpPost("https://simpay.pl/api/" + this.version + "/status");
        post.setEntity(new JsonEntity(statusRequest));

        HttpResponse httpResponse = httpClient.execute(post);

        SimpayStatusResponse statusResponse = PayServiceUtils.getGson().fromJson(new InputStreamReader(httpResponse.getEntity().getContent()), SimpayStatusResponse.class);

        System.out.println(statusResponse);
        return null;
    }
}
