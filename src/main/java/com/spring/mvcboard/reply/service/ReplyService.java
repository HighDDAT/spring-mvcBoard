package com.spring.mvcboard.reply.service;

import java.util.List;

import com.spring.mvcboard.reply.domain.ReplyVO;

public interface ReplyService {
	
	// 기본 댓글처리 관련
    List<ReplyVO> list(Integer articleNo) throws Exception;

    void create(ReplyVO replyVO) throws Exception;

    void update(ReplyVO replyVO) throws Exception;

    void delete(Integer replyNo) throws Exception;

}
