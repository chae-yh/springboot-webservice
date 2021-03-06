package com.younghoon.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.younghoon.book.springboot.service.posts.PostsService;
import com.younghoon.book.springboot.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postsService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "index";
	}

	@GetMapping("/posts/update/{id}")
	public String postUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);

		return "posts-update";
	}

	@GetMapping("/posts/save")
	public String postSave() {
		return "posts-save";
	}
}
