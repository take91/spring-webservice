package com.take.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.take.spring.domain.Posts;
import com.take.spring.domain.PostsRepository;
import com.take.spring.dto.PostsSaveRequestDto;

@SpringBootTest
class PostsServiceTest {

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;

	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void postsServiceTest() {
		// given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder().author("take91@naver.com").content("테스트")
				.title("테스트 타이틀").build();

		// when
		postsService.save(dto);

		// then
		Posts posts = postsRepository.findAll().get(0);
		assertEquals(posts.getAuthor(), dto.getAuthor());
		assertEquals(posts.getContent(), dto.getContent());
		assertEquals(posts.getTitle(), dto.getTitle());

		cleanup();
	}

}
