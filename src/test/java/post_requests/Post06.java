package post_requests;

import base_urls.DummyRestApiBaseUrl;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;

public class Post06 extends DummyRestApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    @Test
    public void pos06(){
        // Set the url
        spec.pathParam("first","create");
        // Set the expected data
        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo();
    }
}
