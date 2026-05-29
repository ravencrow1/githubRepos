package com.example.repos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReposApplicationTests {
	@LocalServerPort
	private int port;

	private final RestTemplate restTemplate = new RestTemplate();

	@Test
	void returnsReposFromGithub() throws Exception {
		var response = restTemplate.getForEntity("http://localhost:" + port + "/octocat", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotEmpty();
	}

	@Test
	void returns404ForInvalidUser() throws Exception {
		var response = restTemplate.getForEntity("http://localhost:" + port + "/userthatdoesnotexist", String.class);

		assertThat(response.getBody()).contains("User not found");
	}
}
