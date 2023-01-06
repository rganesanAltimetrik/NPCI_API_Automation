package stepDefinations;

import endpoint.CollectorRecon_Endpoint;
import entities.CollectorRecon_Entity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import payloads.CollectorRecon_Payload;
import utilities.CommonUtils;

import java.io.IOException;

public class CollectorRecon_StepDefination extends CollectorRecon_Entity {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	CollectorRecon_Payload data =new CollectorRecon_Payload();


	@Given("Add Collector Recon Payload with {string} {string} {string}")
	public void add_Collector_Recon_Payload_with(String transaction_id, String collector_app_id, String receiver_app_id) throws IOException {
		if(transaction_id.equals("random")){
			transaction_id = generateTranscationID();
		}
		res= RestAssured.given().spec(collectorRecon_RequestSpecification())
				.body(data.collectorRecon_Payload(transaction_id, collector_app_id, receiver_app_id));
	}

	@When("user calls {string} with {string} http request for Collector Recon")
	public void user_calls_with_http_request(String resource, String method) {
		CollectorRecon_Endpoint resourceAPI = CollectorRecon_Endpoint.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
	}

	@Then("the API call got success with status code {int} for Collector Recon")
	public void the_API_call_got_success_with_status_code(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}

	@Then("{string} in response body is {string} for Collector Recon")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		ResponseBody body = response.getBody();
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.toLowerCase().contains(keyValue), true);
	}


}
