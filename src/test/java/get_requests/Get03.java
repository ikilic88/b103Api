package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 {
/*
Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
 */
    @Test
    public void get03(){
        // set the Url
        String url = "https://jsonplaceholder.typicode.com/todos/23";

         // Set the expected data

        // Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();
        // Do assertion
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).// “title” is “et itaque necessitatibus maxime molestiae qui quas velit”
                body("completed",equalTo(false)). //  “completed” is false
                body("userId",equalTo(2)); // "userId" :2

        // 2. yol
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),"completed",equalTo(false)
                        ,"userId",equalTo(2));
        // Tek body() methodu icerisinde coklu assertion yaparak soft assertion olusturabiliriz
        // Fail olması durumunda body() içerisinde Java
        // Coklu body() methodu ile assertion yapıldıgında fail durumunda java bir sonraki body() methodu oncecalısmayı durdurur
    }
}

