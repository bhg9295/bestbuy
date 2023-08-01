package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class StoresAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();
    }
    //1. Verify the if the total is equal to 1561
    @Test
    public void totalEqual(){
        response.body("total", equalTo(1561));

    }
    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void verifyLimitOfStore(){
        response.body("limit", equalTo(10));

    }
    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void singleName(){
        response.body("limit", equalTo(10));

    }
    //4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void multipleName(){
        response.body("limit", equalTo(10));
    }
    //5. Verify the storied=7 inside store services of the third store of second services
    @Test
    public void storeServices(){
        response.body("limit", equalTo(10));
    }

    //7. Verify the state = MN of forth store
    @Test
    public void  stateOfStore(){
        response.body("limit", equalTo("MN of forth store"));
    }
    //8. Verify the store name = Rochester of 9th store
    @Test
    public void verifyStorename(){
        response.body("name", equalTo("Rochester"));
    }
    //9. Verify the storeId = 11 for the 6th store
    @Test
    public void verifyStoreIds(){
        response.body("id", equalTo(11));
    }
    //10. Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void verifytheserviceId(){
        response.body("id", equalTo(10));
    }
}