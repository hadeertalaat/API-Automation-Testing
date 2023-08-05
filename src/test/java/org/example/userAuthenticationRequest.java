package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class userAuthenticationRequest {
    @BeforeMethod
    public void setup() {
        baseURI = "https://dummyjson.com";
    }

    @Test
    public void validateCredentialWithCorrectCredential() {
        String username = "kminchelle";
        String password = "0lelplR";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .post("/auth/login");

        Assert.assertEquals(200, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validateCredentialWithEmptyBody() {
        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/auth/login");

        Assert.assertEquals(400, response.statusCode());
    }

    @Test
    public void validateCredentialWithIncorrectUsername() {
        String username = "incorrect";
        String password = "0lelplR";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .post("/auth/login");

        Assert.assertEquals(400, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validateCredentialWithIncorrectPassword() {
        String username = "kminchelle";
        String password = "incorrect";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .post("/auth/login");

        Assert.assertEquals(400, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validateCredentialWithIncorrectRequest() {
        String username = "kminchelle";
        String password = "0lelplR";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .get("/auth/login");

        Assert.assertEquals(403, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validateCredentialWithEmptyUsername() {
        String username = "";
        String password = "0lelplR";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .post("/auth/login");

        Assert.assertEquals(400, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validateCredentialWithEmptyPassword() {
        String username = "kminchelle";
        String password = "";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .post("/auth/login");

        Assert.assertEquals(400, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validateCredentialWithIncorrectUrl() {
        String username = "kminchelle";
        String password = "0lelplR";

        JSONObject credential = new JSONObject();
        credential.put("username", username);
        credential.put("password", password);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(credential.toJSONString())
                .when()
                .post("/auth/Incorrect");

        Assert.assertEquals(403, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);
    }
}