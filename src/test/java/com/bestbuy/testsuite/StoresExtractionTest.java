package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
        // response.log().all();checking mate


    }

    //1 Extract the limit
    @Test
    public void limitExtract() {
        int limit = response.extract().path("limit");
        System.out.println("Extract the limit " + limit);
    }

    // 2 Extract the total
    @Test
    public void totalExtract() {
        int total = response.extract().path("total");
        System.out.println("Extract the total " + total);
    }

    //3 Extract the name of 5th store
    @Test
    public void nameofStore() {
        List<Integer> id = response.extract().path("data.id");
        System.out.println(" Extract the name of 5th store" + id);
    }

    //4. Extract the names of all the store
    @Test
    public void nameOfAllStore() {
        List<String> name = response.extract().path("data.name");
        System.out.println(" Extract the names of all the store" + name);
    }


    //5. Extract the storeId of all the store
    @Test
    public void storeIdAllStore() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the store " + storeId);
    }


    //6. Print the size of the data list
    @Test
    public void sizeOfList() {
        List<String> dataList = response.extract().path("data");
        System.out.println("Extract the size of data list " + dataList.size());
    }

    //7 Get all the value of the store where store name = St Cloud
    @Test
    public void stCloud() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'stCloud'}");
        System.out.println(" Get all the value of the store where store name = St Cloud" + values);
    }

    //8 Get the address of the store where store name = Rochester
    @Test
    public void storeName() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name == 'Rochester'}");
        System.out.println(" Get the address of the store where store name = Rochester" + address);
    }


    //9 Get all the services of 8th store
    @Test
    public void getAllServices() {
        List<String> services = response.extract().path("data[7].services");
        System.out.println("Get all the services of the store where store id 7 store " + services);

    }


    //10 Get store services of the store where service name = Windows Store
    public void windowsStore(){
        List<HashMap<String ,?>> services=response.extract().path("data.services*.find{it.name=='Windows Store'}.storeservices");
        System.out.println("Get storeservices of the store where service name = Windows Store" + services);
    }
    // Get all the storeId of all the store
    @Test
    public void storeIfOfAllStore(){
        List<Integer>storeId   = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the store "+storeId);
    }


    //11 Get all the storeId of all the store
    @Test
    public void storeId1() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the store " + storeId);
    }

    //12 Get id of all the store
    @Test
    public void idAllStore() {
        List<String> getid = response.extract().path("data.id");
        System.out.println("Get id of all the store " + getid);
    }

    //13 Find the store names Where state = ND
    @Test
    public void storeNameState() {
        List<String> state = response.extract().path("data.findAll{it.name == 'ND'}.state.name");
        System.out.println("Find the store names Where state = ND " + state);

    }

    //14 Find the Total number of services for the store where store name = Rochester

        @Test
        public void storeNameIsEqualToRochester(){
            int noOfServices  = response.extract().path("data.find{it.name=='Rochester'}.services.size");
            System.out.println("Find the Total number of services for the store where store name = Rochester "+noOfServices);
        }


    

    //15 Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void allServices() {

    }

    //16 Find the name of all services Where store name = “Fargo”
    @Test
    public void storename() {
        List<HashMap<String, ?>> fargo = response.extract().path("data.findAll{it.name == 'fargo'}.services*.name");
        System.out.println("Find the name of all services Where store name = Fargo" + fargo);
    }

    //17 Find the zip of all the store
    public void zipstore() {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("Get id of all the store " + zip);
    }

    //18 Find the zip of store name = Roseville
    @Test
    public void zipStoreName() {
        List<String> zipStore = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("Get id of all the store " + zipStore);
    }

    //19. Find the store services details of the service name = Magnolia Home Theater
    @Test
    public void homeTheater() {
        List<String> HomeTheater = response.extract().path("data.services*.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("Get id of all the store " + HomeTheater);

    }

    //20. Find the lat of all the stores
    @Test
    public void latOfAllStores() {
        List<?> latName = response.extract().path("data.lat");
        System.out.println("Find the lat of all the stores " + latName);
    }
}
