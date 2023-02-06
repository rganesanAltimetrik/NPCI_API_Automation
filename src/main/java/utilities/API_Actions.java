package utilities;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class API_Actions {

    final static Logger log = LogManager.getLogger(API_Actions.class);

    public Response executeRestRequest(API_Details apiDetails) throws Exception{

        boolean urlEncodingEnabled = true;
        Response response = null;
        RestAssured.baseURI = apiDetails.getUrl();
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification requestSpecification = null;

        if(!(apiDetails.getQueryParameters() == null)) {
            requestSpecification = RestAssured.given().request().urlEncodingEnabled(urlEncodingEnabled)
                    .headers((Map<String, ?>) apiDetails.getHeaders())
                    .queryParams((Map<String, ?>) apiDetails.getQueryParameters());
        }else{
            requestSpecification = RestAssured.given().request().urlEncodingEnabled(urlEncodingEnabled)
                    .headers((Map<String, ?>) apiDetails.getHeaders());
        }

        if (apiDetails.getHttpMethod().contains("PUT")||apiDetails.getHttpMethod().toString().contains("PATCH")  || apiDetails.getHttpMethod().toString().contains("POST")) {

            if (!apiDetails.getRequestBody().isEmpty()) {
                addRequestBodyBasedOnHeaderContentType(apiDetails.getRequestBody(), requestSpecification);
            }

        }
        if (!(apiDetails.getAuthParameters() == null)) {
            addAuthorizationBasedOnType(apiDetails, requestSpecification);
        }
        response = executeHttpMethod(apiDetails.getPath(), apiDetails.getHttpMethod(), requestSpecification);
        System.out.println(response.getStatusCode());
        return response;
    }

    private Response executeHttpMethod(String endpoint, String httpMethod,
                                       RequestSpecification requestSpecification) {
        Response response;
        log.info("In the executeHttpMethod function to execute the request");

        switch (httpMethod) {

            case "GET":
                response = requestSpecification.get(endpoint).then().log().all().extract().response();
                break;

            case "POST":
                response = requestSpecification.relaxedHTTPSValidation().post(endpoint).then().log().all().extract().response();
                break;

            case "PUT":
                response = requestSpecification.relaxedHTTPSValidation().put(endpoint).then().log().all().extract().response();
                break;

            case "PATCH":
                response = requestSpecification.patch(endpoint).then().log().all().extract().response();
                break;

            case "DELETE":
                response = requestSpecification.delete(endpoint).then().log().all().extract().response();
                break;

            default:
                log.info("Trying to execute a GET  request since no HTTPMethod was provided");
                response = requestSpecification.get(endpoint).then().log().all().extract().response();

        }

        return response;
    }

    public String authCode(API_Details apiDetails, String authKey) {
        return apiDetails.getAuthParameters().get(authKey);
    }

    private void addAuthorizationBasedOnType(API_Details apiDetails,
                                             RequestSpecification requestSpecification)  {
        log.info("Adding authorization type for the request specification.");
        HashMap authParams = apiDetails.getAuthParameters();
        if (authParams != null && !authParams.isEmpty()) {
            requestSpecification.auth().oauth2(authCode(apiDetails, "AccessToken"));

        }
    }

    private void addRequestBodyBasedOnHeaderContentType(String requestResponse, RequestSpecification requestSpecification) {
        if (!requestResponse.isEmpty()) {
            try {
                requestSpecification.body(requestResponse);
                log.info("Adding request body as: \n" + requestResponse);
            } catch (Exception e) {
                log.info(e.getMessage(), e);
            }
        }

    }

}
