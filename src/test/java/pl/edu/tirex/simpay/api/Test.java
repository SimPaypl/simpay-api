package pl.edu.tirex.simpay.api;


import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException
    {
//        HttpClient client = HttpClients.createDefault();
//        HttpPost post = new HttpPost("https://simpay.pl/api/1/status");
//
//        SimpayAuth auth = new SimpayAuth("27337b98", "380d486a7e7fcbae74ab282de88c5acf");
//        SimpayStatusRequest request = new SimpayStatusRequest(new SimpayStatusParameters(auth, 2902, 7055, "931682"));
//        post.setEntity(new JsonEntity(request));
//        System.out.println(PayServiceUtils.getGson().toJson(request));
//
//        HttpResponse response = client.execute(post);
//
//        StringBuilder sb = new StringBuilder();
////        new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines().forEach(sb::append);
////        System.out.println(sb.toString());
////        SimpayStatusResponse simpayStatusResponse = PayServiceUtils.getGson().fromJson(sb.toString(), SimpayStatusResponse.class);
//        SimpayStatusResponse responseObject = PayServiceUtils.getGson().fromJson(new InputStreamReader(response.getEntity().getContent()), SimpayStatusResponse.class);
//        System.out.println(responseObject);
//        System.out.println(responseObject.getErrors());
//        System.out.println(responseObject.getRespond().getCode());
//        System.out.println(responseObject.getRespond().getStatus());
//        System.out.println(responseObject.getRespond().getTimeUsed());
//        System.out.println(responseObject.getRespond().isTest());
        SimpayApi simpayApi = new SimpayApi("27337b98", "380d486a7e7fcbae74ab282de88c5acf");
        simpayApi.getStatus(2902, 7055, "2B1F59");
    }
}
