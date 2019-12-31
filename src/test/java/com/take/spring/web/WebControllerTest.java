package com.take.spring.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WebControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
    public void getMainPage() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertTrue(body.contains("스프링부트로 시작하는 웹 서비스"));
    }

}
