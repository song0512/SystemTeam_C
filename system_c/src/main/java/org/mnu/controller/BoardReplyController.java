package org.mnu.controller;

import java.util.List;

import org.mnu.domain.BoardReplyVO;
import org.mnu.service.BoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	// 댓글 리스트
	@GetMapping(value = "/list")
	public ResponseEntity<List<BoardReplyVO>> list(Long no){
		return new ResponseEntity<List<BoardReplyVO>>(service.list(no),HttpStatus.OK);
	}
	
	//댓글 작성
	@PostMapping(value = "/write", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> write(@RequestBody BoardReplyVO vo) {
		log.info("writeReply.vo : " + vo);
		
		int writeCount = service.write(vo);
		
		log.info(writeCount);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//댓글 수정
	@PatchMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(@RequestBody BoardReplyVO vo) {
		log.info("updateReply.vo : " + vo);
		int updateCount = service.update(vo);
		log.info(updateCount);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//댓글 삭제
	@DeleteMapping(value = "/delete", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(Long rno) {
		log.info("deleteReply.rno : " + rno);
		
		int deleteCount = service.delete(rno);
		log.info(deleteCount);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
