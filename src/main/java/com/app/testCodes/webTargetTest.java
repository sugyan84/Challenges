package com.app.testCodes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


//comments?postId=1
public class webTargetTest {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://starlord.hackerearth.com/books");

        //webTarget = webTarget.path("comments?postId=1");
        //webTarget = webTarget.queryParam("postId", 1);

        Response response = webTarget.request().get();

        Object entity = response.getEntity();
    }
}
