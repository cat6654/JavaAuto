package ALMREST.RestClient.Tests;

import ALMREST.RestClient.AlmRestClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by akosatuchenko on 12/22/2014.
 */
public class AlmRestCRUDTest {
    Random rand = new Random();

@Test
public void TestGetAllDefects() throws Exception {
    AlmRestClient client = new AlmRestClient();
    //login
    client.login("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/","sa","");
    Map<String,String> responseGet = client.sendRequest(
            "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects",
            "GET",
            "",
            null);
    System.out.println("Status Code: " + responseGet.get("StatusCode"));
    System.out.println(responseGet.get("Body"));
    //logout
    client.logout("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/");
    Assert.assertTrue("Status codes do not match. Expected is 200. Actual is " + responseGet.get("StatusCode"), responseGet.get("StatusCode").equals("200"));
}
    @Test
    public void TestPostDefect() throws Exception {
        AlmRestClient client = new AlmRestClient();
        Map<String,Object> postBody = new HashMap<String,Object>();
        //login
        client.login("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/","sa","");
        Map<String,String> responsePost = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects",
                "POST",
                "{\"detected-by\": \"sa\",\"creation-time\": \"2014-11-11\",\"severity\": \"3-High\",\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        System.out.println("Status Code: " + responsePost.get("StatusCode"));
        System.out.println(responsePost.get("Body"));
        //get created defect id from response body
        Assert.assertTrue("Status codes do not match. Expected is 201. Actual is " + responsePost.get("StatusCode"), responsePost.get("StatusCode").equals("201"));
    }

    @Test
    public void TestGetDefect() throws Exception {
        AlmRestClient client = new AlmRestClient();
        Map<String,Object> postBody = new HashMap<String,Object>();
        //login
        client.login("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/","sa","");
        Map<String,String> response = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects",
                "POST",
                "{\"detected-by\": \"sa\",\"creation-time\": \"2014-11-11\",\"severity\": \"3-High\",\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        System.out.println("Status Code: " + response.get("StatusCode"));
        System.out.println(response.get("Body"));
        //get created defect id from response body
        Map<String,Object> postResult = new ObjectMapper().readValue(response.get("Body"), postBody.getClass());
        String id = postResult.get("id").toString();
        Map<String,String> responseGet = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects/" + id,
                "GET",
                "",
                null);
        //logout
        client.logout("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/");
        Assert.assertTrue("Status codes do not match. Expected is 200. Actual is " + responseGet.get("StatusCode"), responseGet.get("StatusCode").equals("200"));
    }

    @Test
    public void TestDeleteDefect() throws Exception {
        AlmRestClient client = new AlmRestClient();
        Map<String,Object> postBody = new HashMap<String,Object>();
        //login
        client.login("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/","sa","");
        Map<String,String> response = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects",
                "POST",
                "{\"detected-by\": \"sa\",\"creation-time\": \"2014-11-11\",\"severity\": \"3-High\",\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        System.out.println("Status Code: " + response.get("StatusCode"));
        System.out.println(response.get("Body"));
        //get created defect id from response body
        Map<String,Object> postResult = new ObjectMapper().readValue(response.get("Body"), postBody.getClass());
        String id = postResult.get("id").toString();
        Map<String,String> responseDelete = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects/" + id,
                "DELETE",
                "",
                null);
        //logout
        client.logout("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/");
        Assert.assertTrue("Status codes do not match. Expected is 200. Actual is " + responseDelete.get("StatusCode"), responseDelete.get("StatusCode").equals("200"));
    }

    @Test
    public void TestUpdateDefect() throws Exception {
        AlmRestClient client = new AlmRestClient();
        Map<String,Object> postBody = new HashMap<String,Object>();
        //login
        client.login("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/","sa","");
        Map<String,String> response = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects",
                "POST",
                "{\"detected-by\": \"sa\",\"creation-time\": \"2014-11-11\",\"severity\": \"3-High\",\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        System.out.println("Status Code: " + response.get("StatusCode"));
        System.out.println(response.get("Body"));
        //get created defect id from response body
        Map<String,Object> postResult = new ObjectMapper().readValue(response.get("Body"), postBody.getClass());
        String id = postResult.get("id").toString();
        Map<String,String> responsePut = client.sendRequest(
                "http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/domains/ALEX_K/projects/sql/defects/" + id,
                "PUT",
                "{\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        //logout
        client.logout("http://myd-vm04769.hpswlabs.adapps.hp.com:8080/qcbin/api/");
        Assert.assertTrue("Status codes do not match. Expected is 200. Actual is " + responsePut.get("StatusCode"), responsePut.get("StatusCode").equals("200"));
    }


}
