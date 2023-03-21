package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */
    @Test
    public void put02() {
        //Set the url
        spec.pathParams("first", "update", "second", 21);

        // Set the expected data

        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Ali Can",123,23,"Perfect image");
        System.out.println("expectedData = " + expectedData); // Update ıcın gonderilecek data
        DummyRestApiResponseBodyPojo expectedBodyPojo = new DummyRestApiResponseBodyPojo("success",expectedData,"Successfully! Record has been updated.");
       //

        // Set the request get the response
        Response response =given().spec(spec).when().body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        // do assertion
       DummyRestApiResponseBodyPojo actualdata = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
        System.out.println("actualdata = " + actualdata);


        assertEquals(200,response.statusCode());
        assertEquals(expectedBodyPojo.getStatus(),actualdata.getStatus());
        assertEquals(expectedBodyPojo.getMessage(),actualdata.getMessage());

        assertEquals(expectedData.getEmployee_name(),actualdata.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_age(),actualdata.getData().getEmployee_age());
        assertEquals(expectedData.getEmployee_salary(),actualdata.getData().getEmployee_salary());
        assertEquals(expectedData.getProfile_image(),actualdata.getData().getProfile_image());


    }
}
