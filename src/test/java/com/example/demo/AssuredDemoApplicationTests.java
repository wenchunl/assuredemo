package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class AssuredDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void lottoId() {
		get("http://localhost:8081/lotto").then().body("lottoId", equalTo(5));
	}

	@Test
	void winnerIds() {
		get("http://localhost:8081/lotto").then().body("winnerList.winnerId", hasItems(23, 54));
	}

}
