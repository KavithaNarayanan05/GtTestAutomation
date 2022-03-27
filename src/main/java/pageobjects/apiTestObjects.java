package pageobjects;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class apiTestObjects {

    public static void getResponseBody(String URL) {
        //Get response body for API endpoint and log in console
        given().when().get(URL).then().log().all();
    }

    public static boolean getResponseStatus(String URL) {
        //Get response status code for API endpoint and validate against Success status code 200
        int responseStatusCode = given().when().get(URL).getStatusCode();
        System.out.println("\n  The response status is \n" + given().when().get(URL).getStatusCode());
        if (responseStatusCode == 200) return true;
        else return false;
    }

    public static void getResponseHeaders(String URL) {
        //Get Header details of API endpoint
        System.out.println("\n The headers in the response are \n" + get(URL).then().extract().headers());
    }

    public static void getResponseTime(String URL) {
        //Get Response time taken to fetch the response
        System.out.println("\n The time taken to fetch the response \n " + get(URL).timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    public static void getResponseContentType(String URL) {
        //Get Content Type response obtained
        System.out.println("\n The content type of response \n  " + get(URL).then().extract().contentType());
    }

    public static void getAdIDs(String URL) {
        //Get all the Ad IDs in the response and store it in an array
        ArrayList<Integer> ids = when().get(URL).then().extract().path("ads.id");
        //Display the array index and corresponding Ad ID
        for (int a : ids) {
            System.out.println(ids.indexOf(a) + " Ad ID is " + a);
        }
    }

    public static boolean getSizeOfAdsList(int pagesize, String URL) {
        ArrayList<Integer> ids = when().get(URL).then().extract().path("ads.id");
        //Display total size of the array / Ads
        System.out.println("\n Total number of ads is \n" + ids.size());
        //Validate if pagesize on the query param and the size of the array received in response are equal
        if (ids.size() == pagesize) {
            System.out.println("\n  List size is a match \n  ");
            return true;
        } else {
            System.out.println("\n  Actual page size is " +pagesize+" and List size in response is "+ids.size()+" - NOT a match.\n ");
            return false;
        }
    }

}

