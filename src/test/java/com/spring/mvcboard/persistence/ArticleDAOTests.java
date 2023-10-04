package com.spring.mvcboard.persistence;


import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.SearchCriteria;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTests {
	
	@Inject
	private ArticleDAO articleDAO;
	
	@Test
    public void testCreate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setTitle("새 글 작성 테스트 제목");
        article.setContent("새 글 작성 테스트 내용");
        article.setWriter("새 글 작성 테스트 작성자");
        articleDAO.create(article);
    }
	
	@Test
    public void testCreate2() throws Exception {
		for (int i = 1; i <= 1000; i++) {
	        ArticleVO articleVO = new ArticleVO();
	        articleVO.setTitle(i+ "번째 글 제목 테스트용");
	        articleVO.setContent(i+ "번재 글 내용 테스트용");
	        articleVO.setWriter("tester01"+(i%10));

	        articleDAO.create(articleVO);
		}
	}

    @Test
    public void testRead() throws Exception {
        log.info(articleDAO.read(5).toString());
    }

    @Test
    public void testUpdate() throws Exception {
    	ArticleVO article = new ArticleVO();
        article.setArticleNo(1);
        article.setTitle("글 수정 테스트 제목");
        article.setContent("글 수정 테스트 내용");
        articleDAO.update(article);
    }

    @Test
    public void testDelete() throws Exception {
        articleDAO.delete(1);
    }
    
    @Test
    public void testListPaging() throws Exception {
    	
    	int page = 3;

        List<ArticleVO> articles = articleDAO.listPaging(page);

        for (ArticleVO article : articles) {
            log.info(article.getArticleNo() + ":" + article.getTitle());
        }
    }
    
    @Test
    public void testListCriteria() throws Exception {
        Criteria criteria = new Criteria();
        criteria.setPage(3);
        criteria.setPerPageNum(20);

        List<ArticleVO> articles = articleDAO.listCriteria(criteria);

        for (ArticleVO article : articles) {
            log.info(article.getArticleNo() + " : " + article.getTitle());
        }
    }
    
    @Test
    public void testURI() throws Exception {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/article/read")
                .queryParam("articleNo", 12)
                .queryParam("perPageNum", 20)
                .build();

        log.info("/article/read?articleNo=12&perPageNum=20");
        log.info(uriComponents.toString());

    }
    
    @Test
    public void testURI2() throws Exception {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/{module}/{page}")
                .queryParam("articleNo", 12)
                .queryParam("perPageNum", 20)
                .build()
                .expand("article", "read")
                .encode();

        log.info("/article/read?articleNo=12&perPageNum=20");
        log.info(uriComponents.toString());

    }
    
    @Test
    public void testDynamic1() throws Exception {

        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setPage(1);
        searchCriteria.setKeyword("999");
        searchCriteria.setSearchType("t");

        log.info(" ========== =========== ");

        List<ArticleVO> articles = articleDAO.listSearch(searchCriteria);

        for (ArticleVO article : articles) {
            log.info(article.getArticleNo() + " : " + article.getTitle());
        }

        log.info(" ========== =========== ");

        log.info("searched articles count : " + articleDAO.countSearchedArticles(searchCriteria));
    }

}