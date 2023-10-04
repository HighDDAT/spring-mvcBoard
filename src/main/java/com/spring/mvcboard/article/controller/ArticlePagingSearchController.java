package com.spring.mvcboard.article.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvcboard.article.service.ArticleService;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.PageMaker;
import com.spring.mvcboard.commons.paging.SearchCriteria;

@Controller
@RequestMapping("/article/paging/search")
public class ArticlePagingSearchController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticlePagingSearchController.class);
	
	private final ArticleService articleService;
	
	@Inject
	public ArticlePagingSearchController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// 등록 페이지 이동
	
	// 등록 처리
	
	// 목록 페이지 이동
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                       Model model) throws Exception {
    	
        log.info("list page forwarding : RequestMethod.GET");

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        pageMaker.setTotalCount(articleService.countArticles(searchCriteria));

        model.addAttribute("articles", articleService.listCriteria(searchCriteria));
        model.addAttribute("pageMaker", pageMaker);

        return "/article/search/list";
    }
	
	// 조회 페이지 이동
	
	// 수정 페이지 이동
	
	// 수정 처리
	
	// 삭제 처리

}
