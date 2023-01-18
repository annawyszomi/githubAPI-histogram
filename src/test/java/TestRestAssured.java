import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;


public class TestRestAssured {

    @Test
    public void getStatusCode200() {
        baseURI = "http://localhost:8080";
        given().get("/users/annawyszomi/repos")
                .then()
                .statusCode(200);
    }

    @Test
    public void getCorrectResponseForFirstElement() {
        baseURI = "http://localhost:8080";
        //given
        Response responseApi = RestAssured.get("/users/annawyszomi/repos");
        Response responseHistogram = RestAssured.get("/users/annawyszomi/reposHistogram");
        //when
        String firstName = responseApi.getBody().jsonPath().get("0");
        String firstHistogram = responseHistogram.getBody().jsonPath().get("0");
        //then
        Assert.assertEquals(firstHistogram.length(), firstName.length());
    }

    @Test
    public void getCorrectResponseForEighthElement() {
        baseURI = "http://localhost:8080";
        //given
        Response responseApi = RestAssured.get("/users/annawyszomi/repos");
        Response responseHistogram = RestAssured.get("/users/annawyszomi/reposHistogram");
        //when
        String firstName = responseApi.getBody().jsonPath().get("8");
        String firstHistogram = responseHistogram.getBody().jsonPath().get("8");
        //then
        Assert.assertEquals(firstHistogram.length(), firstName.length());
    }

    @Test
    public void getCorrectResponseValueForFirstElement() {
        baseURI = "http://localhost:8080";
        //given
        Response responseApi = RestAssured.get("/users/annawyszomi/repos");
        //when
        String firstName = responseApi.getBody().jsonPath().get("0");
        //then
        Assert.assertEquals("algorithms", firstName);
    }

    @Test
    public void getCorrectResponseValueLengthForFirstElement() {
        baseURI = "http://localhost:8080";
        //given
        Response responseApi = RestAssured.get("/users/annawyszomi/repos");
        //when
        String firstName = responseApi.getBody().jsonPath().get("0");
        //then
        Assert.assertEquals(10, firstName.length());
    }
}
