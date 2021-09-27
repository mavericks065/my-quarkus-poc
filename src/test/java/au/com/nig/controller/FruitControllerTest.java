package au.com.nig.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FruitControllerTest {

//    @Test
//    public void testFetAllsEndpoint() {
//        given()
//                .when().get("/fruits")
//                .then()
//                .statusCode(200)
//                .body(is("Hello here is a list of fruits in a String: apple, pear"));
//    }

    @Test
    public void testFetchOneEndpoint() {
        given()
                .when().get("/fruits/apple")
                .then()
                .statusCode(200)
                .body("name", is("apple"));
    }

}
