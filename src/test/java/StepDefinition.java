import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StepDefinition {
public static String baseURL="https://itunes.apple.com";
    Response response;
    @Given("^Call i tunes search api$")
    public void Call_i_tunes_search_api() throws Throwable
    {
        connectRestAssured();
       System.out.println("Calling i tunes search");
    }

    @Given("^Call i tunes search api with encoded url with parameter \"([^\"]*)\" as \"([^\"]*)\"$")
    public void Call_i_tunes_search_api_with_encoded_url(String key, String value) throws Throwable
    {
        RestAssured.baseURI = baseURL;
        String encodedparam= URLEncoder.encode(value);
        RequestSpecification request = RestAssured.given();
        request.param(key,encodedparam);
        response = request.get("/search");
        System.out.println("Encoded url is -->"+encodedparam+"<--");
        System.out.println(response.getStatusCode());
        System.out.println("Response Body..............."+response.getBody().asString()+".............");
    }

    @Given("^Call i tunes search api with encoded url with parameters \"([^\"]*)\" as \"([^\"]*)\" and \"([^\"]*)\" as \"([^\"]*)\"$")
    public void Call_i_tunes_search_api_with_encoded_url_with_multiple_parameter(String key, String value,String key2, String value2) throws Throwable
    {
        RestAssured.baseURI = baseURL;
        String encodedparam= URLEncoder.encode(value);
        String encodedparam2= URLEncoder.encode(value2);
        RequestSpecification request = RestAssured.given();
        request.param(key,encodedparam);
        request.param(key2,encodedparam2);
        response = request.get("/search");
        System.out.println("Encoded url is -->"+encodedparam+"<--");
        System.out.println(response.getStatusCode());
        System.out.println("Response Body..............."+response.getBody().asString()+".............");
    }

    @Given("^Call i tunes search api with encoded url with parameters \"([^\"]*)\" as \"([^\"]*)\" and \"([^\"]*)\" as \"([^\"]*)\" and \"([^\"]*)\" as \"([^\"]*)\"$")
    public void Call_i_tunes_search_api_with_encoded_url_with_three_parameter(String key, String value,String key2, String value2,String key3, String value3) throws Throwable
    {
        RestAssured.baseURI = baseURL;
        String encodedparam= URLEncoder.encode(value);
        String encodedparam2= URLEncoder.encode(value2);
        String encodedparam3= URLEncoder.encode(value3);
        RequestSpecification request = RestAssured.given();
        request.param(key,encodedparam);
        request.param(key2,encodedparam2);
        request.param(key3,encodedparam3);
        response = request.get("/search");
        System.out.println("Encoded url is -->"+encodedparam+"<--");
        System.out.println(response.getStatusCode());
        System.out.println("Response Body..............."+response.getBody().asString()+".............");
    }

    @Given("^Call i tunes search api with invalid param$")
    public void Call_i_tunes_search_api_with_invalid_param() throws Throwable
    {
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        request.param("xyz","jack+johnson");
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println("Calling i tunes search");
    }

    @Given("^Call i tunes search api with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void call_i_tunes_search_api_with_and(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = baseURL;
        System.out.println(arg2);
        RequestSpecification request = RestAssured.given();
        request.param("term",arg1);
        request.param("limit",arg2);
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println("Calling i tunes search with limit");
    }
    @Given("^Call i tunes search api with \"([^\"]*)\" and entity \"([^\"]*)\"$")
    public void call_i_tunes_search_api_with_and_entity(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = baseURL;
        System.out.println(arg2);
        RequestSpecification request = RestAssured.given();
        request.param("term",arg1);
        request.param("entity",arg2);
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println("Calling i tunes search with entity");
    }

    @Given("^Call i tunes search api with \"([^\"]*)\" and country \"([^\"]*)\"$")
    public void call_i_tunes_search_api_with_and_country(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = baseURL;
        System.out.println(arg2);
        RequestSpecification request = RestAssured.given();
        request.param("term",arg1);
        request.param("country",arg2);
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println("Calling i tunes search with country");
    }

    @Given("^Call i tunes search api with \"([^\"]*)\" and country \"([^\"]*)\" and entity \"([^\"]*)\"$")
    public void call_i_tunes_search_api_with_and_country_and_entity(String arg1, String arg2, String arg3) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = baseURL;
        System.out.println(arg2);
        RequestSpecification request = RestAssured.given();
        request.param("term",arg1);
        request.param("country",arg2);
        request.param("entity",arg3);
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println("Calling i tunes search with term, country and entity");
    }

    @Given("^Verify status code is \"([^\"]*)\"$")
    public void Verify_status_code_is_200(int code) throws Throwable
    {
        Assert.assertEquals(code,response.getStatusCode());
        System.out.println("Status code verified successfully");
    }

    @Then("^Verify result count is \"([^\"]*)\"$")
    public void Verify_result_count_is(int resultCount) throws Throwable
    {
        JSONObject obj=new JSONObject(response.getBody().asString());
        Assert.assertEquals(obj.getInt("resultCount"),resultCount);
        System.out.println("Result count verified successfully");
    }

    @Then("^Verify version number is \"([^\"]*)\"$")
    public void Verify_version_number_is(int resultCount) throws Throwable
    {
        JSONObject obj=new JSONObject(response.getBody().asString());
        String collectioncensor=obj.getJSONArray("results").getJSONObject(2).getString("collectionCensoredName");
        System.out.println(">>>>>>>>"+collectioncensor);
        if(collectioncensor.contains(String.valueOf(resultCount))){
         Assert.assertTrue(true);
         System.out.println("versions verified successfully");
        }else {
            Assert.assertTrue(false);
            System.out.println("versions couldn't verified");
        }

    }

    @Then("^Verify WrapperType is \"([^\"]*)\"$")
    public void Verify_WrapperType(String type) throws Throwable
    {
        JSONObject obj=new JSONObject(response.getBody().asString());
        System.out.println(">>>>>>>>"+obj.getJSONArray("results").getJSONObject(0).getString("wrapperType"));
        Assert.assertEquals(obj.getJSONArray("results").getJSONObject(0).getString("wrapperType"),type);
        System.out.println("WrapperType verified successfully");
    }

    @Then("^Verify collectionExplicitness is \"([^\"]*)\"$")
    public void Verify_collectionExplicitness(String type) throws Throwable
    {
        JSONObject obj=new JSONObject(response.getBody().asString());
        String explicitiStat=obj.getJSONArray("results").getJSONObject(0).getString("collectionExplicitness");
        System.out.println(">>>>>>>>"+explicitiStat);
        String status;
        if(explicitiStat.equals("Explicit")){
            status="Yes";
        }else{
            status="No";
        }

        Assert.assertEquals(status,type);
        System.out.println("Explicitness verified successfully");
    }

    @Then("^Verify artistName is \"([^\"]*)\"$")
    public void Verify_ArtistName(String type) throws Throwable
    {
        JSONObject obj=new JSONObject(response.getBody().asString());
        System.out.println(">>>>>>>>"+obj.getJSONArray("results").getJSONObject(0).getString("artistType"));
        Assert.assertEquals(obj.getJSONArray("results").getJSONObject(0).getString("artistType"),type);
        System.out.println("Artist name verified successfully");
    }


    @Given("^Call i tunes search api without parameter$")
    public void Call_i_tunes_search_api_without_parameter() throws Throwable
    {
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println("Calling i tunes search");
    }


    public void connectRestAssured(){
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        request.param("term","jack+johnson");
        response = request.get("/search");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

    }




}
