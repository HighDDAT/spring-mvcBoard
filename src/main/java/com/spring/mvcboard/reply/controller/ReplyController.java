package com.spring.mvcboard.reply.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
    private final ReplyService replyService;

    @Inject
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }
    
    // 댓글 등록
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ReplyVO replyVO) {
        ResponseEntity<String> entity = null;
        try {
            replyService.addReply(replyVO);
            entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    
    // 댓글 목록
    
    // 댓글 수정
    
    // 댓글 삭제

}
