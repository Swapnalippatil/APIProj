package api.test;

import api.endpoints.Routes;
import api.payload.Data;
import api.payload.ListUserPojo;
import api.utilitites.FileUtils;
import com.users.CreateUser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static io.restassured.RestAssured.given;


public class UserTest {
    @BeforeClass()
    public void setup() {
        //RestAssured.baseURI = "https://petstore.swagger.io";
        //RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
        RestAssured.baseURI ="https://reqres.in";
    }

    @Test(priority = 1)
    public void testPostUsereee() throws URISyntaxException, IOException {
        FileUtils file = new FileUtils();
        Response response =  given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(file.getBody("/Users/API/APITest/src/main/resources/data/data1.json"))
                .when()
                .post(Routes.post_url);
        response.then().log().all();
        System.out.println(response.toString());
    }

    @Test(priority = 1)
    public void testPostUser() throws URISyntaxException, IOException {
        FileUtils file = new FileUtils();
        Response response =  given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(file.getBody("/Users/API/APITest/src/main/resources/data/data1.json"))
                .when()
                .post("/create");
        response.then().log().all();
        System.out.println(response);
    }

    @Test(priority = 1)
    public void testPostUseree() throws URISyntaxException, IOException {
        FileUtils file = new FileUtils();
        Response response = given()
                .header("accept","application/json")
                        .header("Content-Type", "application/json")
                                .body(file.getBody("/Users/API/APITest/src/main/resources/data/data.json"))
                                        .post("/v2/pet");
        response.then().log().all();
        System.out.println(response.getBody());
    }


    @Test
    public void response ()
    {
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .get(Routes.get_url);
        System.out.println(response.getBody());
    }

    @Test(priority = 1)
    public void testUseree() throws URISyntaxException, IOException {
        FileUtils file = new FileUtils();
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(file.getBody("/Users/API/APITest/src/main/resources/data/user.json"))
                .post("/api/users");
        response.then().log().all();
        CreateUser user = response.body().as(CreateUser.class);
        System.out.println("Body" + response.getBody().asString());
        System.out.println("Id----" + user.getId());
    }

    @Test(priority = 1)
    public void testListUseree() {
        ListUserPojo pojo = given().when()
                .get("/api/users?page=2").as(ListUserPojo.class);
        System.out.println("Page: " + pojo.getPer_page());
        System.out.println("data: " + pojo.getData());
       List<Data> data = pojo.getData();
        for (int i=0; i< data.size(); i++){
            System.out.println(data.get(i));
        }
    }

    @Test
    public void postTest() throws IOException {
        FileUtils file = new FileUtils();
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(file.getFile("/Users/API/APITest/src/main/resources/data/user.json"))
                .post("");
        response.then().log().all();
        CreateUser user = response.body().as(CreateUser.class);
        System.out.println(user.getId());
    }
    @Test
    public void getTest(){
        Response response = given().when().get("/api/users?page=2");
        int code = response.getStatusCode();
        ListUserPojo pojo = response.body().as(ListUserPojo.class);
        System.out.println("Page: " + pojo.getPer_page());
    }
}
