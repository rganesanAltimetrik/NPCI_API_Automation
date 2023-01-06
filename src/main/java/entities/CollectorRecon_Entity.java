package entities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.CommonUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CollectorRecon_Entity {

    public static RequestSpecification req;

    public RequestSpecification collectorRecon_RequestSpecification() throws IOException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(CommonUtils.getValueFromApplicationProperty("collectorReconUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public String generateTranscationID(){
        String transaction_id = CommonUtils.getAlphaNumericString(5)+"-"+CommonUtils.getAlphaNumericString(5)+"-"+CommonUtils.getAlphaNumericString(5)
                +"-"+CommonUtils.getAlphaNumericString(5)+"-"+CommonUtils.getAlphaNumericString(5);
        System.out.println("Transaction ID - " + transaction_id);
        return transaction_id;
    }


}
