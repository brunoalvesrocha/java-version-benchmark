package com.example.demo.resource;

import com.example.demo.utils.BaseTest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author bruno.alves.rocha
 */

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarResourceTest extends BaseTest {

    @Test
    public void should_return_200_ok() throws Exception {
        get(url("/cars")).then().statusCode(OK.value());
    }

    @Test
    public void should_return_one_car() throws Exception {
        final String nameCar = get(url("/cars")).then().extract().jsonPath()
                .getString("name");

        assertThat(nameCar, has("[fusca]"));
    }
}
