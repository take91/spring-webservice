package com.take.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.take.spring.domain.PostsRepository;
import com.take.spring.dto.PostsMainResponseDto;
import com.take.spring.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostsService {

	private PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
}
