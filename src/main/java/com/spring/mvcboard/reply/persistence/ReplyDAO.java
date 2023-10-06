package com.spring.mvcboard.reply.persistence;

import java.util.List;

import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;

public interface ReplyDAO {
	
	// 기본 댓글처리 관련
    List<ReplyVO> list(Integer articleNo) throws Exception;

    void create(ReplyVO replyVO) throws Exception;

    void update(ReplyVO replyVO) throws Exception;

    void delete(Integer replyNo) throws Exception;
    
    // 댓글기능 페이징 관련
    List<ReplyVO> listPaging(Integer articleNo, Criteria criteria) throws Exception;

    int countReplies(Integer articleNo) throws Exception;
    
    // 댓글수 트랜잭션 관련
    int getArticleNo(Integer replyNo) throws Exception;

}
