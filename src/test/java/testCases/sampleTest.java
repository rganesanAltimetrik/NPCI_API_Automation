package testCases;

import enums.HttpMethods;
import groovyjarjarantlr4.v4.automata.ATNFactory;
import utilities.API_Actions;
import utilities.API_Details;

import javax.xml.ws.Response;
import java.util.HashMap;

public class sampleTest {

    static String testCaseID = "Test_001";
    static String httpMethod = HttpMethods.POST.toString();
    static String url = "https://reqres.in/";
    static String path = "api/users";
    static String requestbody = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";





    public static void executeRestRequest() throws Exception {

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        API_Details apiDetails = new API_Details();
        apiDetails.setTestCaseID(testCaseID);
        apiDetails.setHttpMethod(httpMethod);
        apiDetails.setUrl(url);
        apiDetails.setPath(path);
        apiDetails.setRequestBody(requestbody);
        apiDetails.setHeaders(headers);

        API_Actions apiActions = new API_Actions();
        apiActions.executeRestRequest(apiDetails);

    }

    public static void main (String args[]) throws Exception {

        executeRestRequest();
    }


}
