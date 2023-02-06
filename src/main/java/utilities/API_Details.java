package utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class API_Details {

    private String testCaseID;

    private String httpMethod;

    private String url;

    private String path;

    private HashMap<String, String> pathParams;

    private HashMap<String, String> queryParams;

    private String requestBody;

    private HashMap<String, String> headers;

    private HashMap<String, String> authParams;








    public String getTestCaseID(){
        return testCaseID;
    }

    public void setTestCaseID(String testCaseID){
        this.testCaseID = testCaseID;
    }

    public String getHttpMethod(){
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod){
        this.httpMethod = httpMethod;
    }

    public String getUrl(){ return url; }

    public void setUrl(String url){
        this.url = url;
    }

    public String getPath(){ return path; }

    public void setPath(String path){
        this.path = path;
    }

    public HashMap<String, String> getPathParameters(){
        return pathParams;
    }

    public void setPathParameters(HashMap<String, String> pathParams){
        this.pathParams = pathParams;
    }

    public HashMap<String, String> getQueryParameters(){
        return queryParams;
    }

    public void setQueryParameters(HashMap<String, String> queryParams){
        this.queryParams = queryParams;
    }

    public String getRequestBody(){ return requestBody; }

    public void setRequestBody(String requestBody){
        this.requestBody = requestBody;
    }

    public HashMap<String, String> getHeaders(){
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers){
        this.headers = headers;
    }

    public HashMap<String, String> getAuthParameters(){ return authParams; }

    public void setAuthParameters(HashMap<String, String> authParams){
        this.authParams = authParams;
    }




}
