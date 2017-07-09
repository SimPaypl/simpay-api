package pl.edu.tirex.payservices;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import pl.edu.tirex.payservices.connection.SimpayStatusRequest;
import pl.edu.tirex.payservices.connection.SimpayStatusResponse;
import pl.edu.tirex.payservices.models.SimpayAuth;
import pl.edu.tirex.payservices.models.SimpayStatusParameters;
import pl.edu.tirex.payservices.utils.JsonEntity;
import pl.edu.tirex.payservices.utils.PayServiceUtils;

import java.io.IOException;
import java.io.InputStreamReader;

public class Test
{
    public static void main(String[] args) throws IOException
    {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://simpay.pl/api/1/status");

        SimpayAuth auth = new SimpayAuth("27337b98", "380d486a7e7fcbae74ab282de88c5acf");
        SimpayStatusRequest request = new SimpayStatusRequest(new SimpayStatusParameters(auth, 2902, 7055, "931682"));
        post.setEntity(new JsonEntity(request));
        System.out.println(PayServiceUtils.getGson().toJson(request));

        HttpResponse response = client.execute(post);

        StringBuilder sb = new StringBuilder();
//        new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines().forEach(sb::append);
//        System.out.println(sb.toString());
//        SimpayStatusResponse simpayStatusResponse = PayServiceUtils.getGson().fromJson(sb.toString(), SimpayStatusResponse.class);
        SimpayStatusResponse responseObject = PayServiceUtils.getGson().fromJson(new InputStreamReader(response.getEntity().getContent()), SimpayStatusResponse.class);
        System.out.println(responseObject);
        System.out.println(responseObject.getErrors());
        System.out.println(responseObject.getRespond().getCode());
        System.out.println(responseObject.getRespond().getStatus());
        System.out.println(responseObject.getRespond().getTimeUsed());
        System.out.println(responseObject.getRespond().isTest());
    }
}
