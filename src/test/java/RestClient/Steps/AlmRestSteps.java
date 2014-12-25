package RestClient.Steps;

import RestClient.AlmRestClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by akosatuchenko on 12/25/2014.
 */
public class AlmRestSteps {
    public static Map<String, String> responseGET;
    public static Map<String, String> responsePOST;
    public static Map<String, String> responsePUT;
    public static Map<String, String> responseDELETE;
    public static Map<String, Object> postBODY;

    Random rand = new Random();

    @Given("Login to ALM")
    public void loginToALM(){
        AlmRestClient client = new AlmRestClient();
        //login
        client.login();
    }

    @Given("Logout from ALM")
    public void logoutFromALM(){
        AlmRestClient client = new AlmRestClient();
        //login
        client.logout();
    }

    @When("Get All Defects")
    public void getAllDefectsFromALM(){
        AlmRestClient client = new AlmRestClient();
        //login
        Map<String, String> responseGet = client.sendRequest(
                "defects",
                "GET",
                "",
                null);
        responseGET = responseGet;
    }

    @When("Create defect")
    public void createNewDefectInALM(){
        AlmRestClient client = new AlmRestClient();
        Map<String, Object> postBody = new HashMap<String, Object>();
        //login
        client.login();
        Map<String, String> responsePost = client.sendRequest(
                "defects",
                "POST",
                "{\"detected-by\": \"sa\",\"creation-time\": \"2014-11-11\",\"severity\": \"3-High\",\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        responsePOST = responsePost;
        postBODY = postBody;
    }

    @When("Get previously created defect")
    public void getDefectInALM(){
        Map<String, Object> postBody = postBODY;
        AlmRestClient client = new AlmRestClient();
        Map<String, Object> postResult = null;
        try {
            postResult = new ObjectMapper().readValue(responsePOST.get("Body"), postBody.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id = postResult.get("id").toString();
        Map<String, String> responseGet = client.sendRequest(
                "defects/" + id,
                "GET",
                "",
                null);
        responseGET = responseGet;
    }

    @When("Update previously created defect")
    public void updateDefectInALM(){
        Map<String, Object> postBody = postBODY;
        AlmRestClient client = new AlmRestClient();
        Map<String, Object> postResult = null;
        try {
            postResult = new ObjectMapper().readValue(responsePOST.get("Body"), postBody.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id = postResult.get("id").toString();
        Map<String, String> responsePut = client.sendRequest(
                "defects/" + id,
                "PUT",
                "{\"name\": \"Created from REST " + rand.nextInt() + "\"}",
                null);
        responsePUT = responsePut;
    }

    @When("Delete previously created defect")
    public void deleteDefectInALM(){
        Map<String, Object> postBody = postBODY;
        AlmRestClient client = new AlmRestClient();
        Map<String, Object> postResult = null;
        try {
            postResult = new ObjectMapper().readValue(responsePOST.get("Body"), postBody.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id = postResult.get("id").toString();
        Map<String, String> responseDelete = client.sendRequest(
                "defects/" + id,
                "DELETE",
                "",
                null);
        responseDELETE = responseDelete;
    }

    @Then("Check that Status Code is $statusCode in GetResponse")
    public void checkStatusCodeGet(@Named("$statusCode") String expected){
        if(!responseGET.get("StatusCode").equals(expected))
            throw new RuntimeException("Status codes do not match. Expected is 200. Actual is " + responseGET.get("StatusCode"));
    }
    @Then("Check that Status Code is $statusCode in PostResponse")
    public void checkStatusCodePost(@Named("$statusCode") String expected){
        if(!responsePOST.get("StatusCode").equals(expected))
            throw new RuntimeException("Status codes do not match. Expected is 200. Actual is " + responsePOST.get("StatusCode"));
    }
    @Then("Check that Status Code is $statusCode in PutResponse")
    public void checkStatusCodePut(@Named("$statusCode") String expected){
        if(!responsePUT.get("StatusCode").equals(expected))
            throw new RuntimeException("Status codes do not match. Expected is 200. Actual is " + responsePUT.get("StatusCode"));
    }
    @Then("Check that Status Code is $statusCode in DeleteResponse")
    public void checkStatusCodeDelete(@Named("$statusCode") String expected){
        if(!responseDELETE.get("StatusCode").equals(expected))
            throw new RuntimeException("Status codes do not match. Expected is 200. Actual is " + responseDELETE.get("StatusCode"));
    }


}
