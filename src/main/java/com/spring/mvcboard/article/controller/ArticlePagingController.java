package com.spring.mvcboard.article.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvcboard.article.service.ArticleService;

@Controller
@RequestMapping("/article/paging")
public class ArticlePagingController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	private final ArticleService articleService;

	@Inject
	public ArticlePagingController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// 등록 페이지로 이동
	
	// 등록 처리
	
	// 목록 페이지 이동
	
	// 조회 페이지 이동
	
	// 수정 페이지로 이동
	
	// 수정 처리
	
	// 삭제 처리
	

}
