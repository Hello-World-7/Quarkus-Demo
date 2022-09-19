package org.dev.quark.micro;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

@QuarkusTest
public class BookResourceTest {
    

    @Test
    public void testEndpoint() {
        given()
        .formParam("title", "Hello Boys!")
        .formParam("yearOfPublication", 2019)
        .formParam("genre", "Drama")
        .formParam("author", "Rahim Set")
          .when().post("/api/books")
          .then()
             .statusCode(201)
             //.body("isbn_13", startsWith("13-"))
             .body("title", is("Hello Boys!"))
             .body("author", is("Rahim Set"))
             .body("genre", is("Drama"))
             .body("year_of_publication", is(2019));
    }

}