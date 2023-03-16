package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class Get02 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02() {
        // 1.adım: Set the url
        String url = "https://restful-booker.herokuapp.com/booking/0";

        // 2. adım: Set the expected data ==> ( Post, Put, Patch)
        //3. adım : Send the request get the response


        try {
            Response response = given().when().get(url);
        } catch (Exception e) {
            assert e.getMessage().contains("404");
            assert e.getMessage().contains("Not Found");
            Assert.assertFalse(e.getMessage().contains("TechProEd"));
        }

//        response.prettyPrint();
//        // Do assertion
//    //    response.then().
//                statusCode(404).//  HTTP Status code should be 404
//                statusLine(" HTTP/1.1 404 Not Found"); //Status Line should be HTTP/1.1 404 Not Found

        // Response body contains "Not Found"
        // assertTrue() methodu, method parantezi icindeki  degerin false olamsı durumunda test "fail" olluyor
       // assertTrue(response.asString().contains("Not Found"));

        // Response body does not contain "TechProEd"
        // assertTrue() methodu, method parantezi icindeki  degerin true olamsı durumunda test "fail" olluyor
       // assertFalse(response.asString().contains("TechProEd"));


        // Server is "Cowboy"
       // assertEquals("cowboy",response.header("Server"));
    }
}
