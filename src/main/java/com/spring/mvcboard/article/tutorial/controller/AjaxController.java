package com.spring.mvcboard.article.tutorial.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvcboard.article.tutorial.domain.SampleVO;

@RestController
@RequestMapping("/ajax/test")
public class AjaxController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		
		return "Hello World";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		
		SampleVO sampleVO = new SampleVO();
		sampleVO.setSampleNo(1);
		sampleVO.setFirstName("땃");
		sampleVO.setLastName("지");
		
		return sampleVO;
		
	}
	
	@RequestMapping("/sendlist")
	public List<SampleVO> senList() {
		
		List<SampleVO> samples = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			SampleVO sample = new SampleVO();
			sample.setSampleNo(i);
			sample.setFirstName("뚜앗");
			sample.setLastName("지" + i);
			samples.add(sample);
		}
		
		return samples;
	}

	@RequestMapping("/sendmap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> sampleMap = new HashMap<>();
		
		for (int i = 0; i < 20; i++) {
			SampleVO sample = new SampleVO();
			sample.setSampleNo(i);
			sample.setFirstName("뚜앗");
			sample.setLastName("지" + i);
			sampleMap.put(i, sample);
		}
		
		return sampleMap;
	}
	
    @RequestMapping("/sendErrorAuth")
    public ResponseEntity<Void> sendListAuth() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/sendErrorNot")
    public ResponseEntity<List<SampleVO>> sendListNot() {

        List<SampleVO> samples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SampleVO sample = new SampleVO();
            sample.setSampleNo(i);
            sample.setFirstName("뚜앗");
            sample.setLastName("쥐" + i);
            samples.add(sample);
        }

        return new ResponseEntity<>(samples, HttpStatus.NOT_FOUND);
    }
}
