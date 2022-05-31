package org.mnu.controller;

import java.util.List;

import org.mnu.domain.BoardReplyVO;
import org.mnu.service.BoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply")
@Log4j
public class BoardReplyController {
	
	@Autowired
	@Qualifier("brs")
	private BoardReplyService service;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<BoardReplyVO>> list(Long no){
		return new ResponseEntity<>(service.list(no),HttpStatus.OK);
	}
	
	@PostMapping(value = "/write", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> write(@RequestBody BoardReplyVO vo) {
		log.info("writeReply.vo : " + vo);
		
		int writeCount = service.write(vo);
		
		log.info(writeCount);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
