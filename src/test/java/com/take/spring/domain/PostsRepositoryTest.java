package com.take.spring.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostsRepositoryTest {

	@Autowired
	PostsRepository postRepository;

	public void cleanup() {
		postRepository.deleteAll();
	}

	@Test
	public void postTest() {

		// given
		postRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("take91@naver.com").build());

		// when
		List<Posts> postsList = postRepository.findAll();

		Posts posts = postsList.get(0);
		assertEquals(posts.getTitle(), "테스트 게시글");
		assertEquals(posts.getContent(), "테스트 본문");

		cleanup();
	}

	@Test
	public void postTimeTest() {
		// given
		LocalDateTime now = LocalDateTime.now();
		postRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jojoldu@gmail.com").build());
		// when
		List<Posts> postsList = postRepository.findAll();

		// then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}
