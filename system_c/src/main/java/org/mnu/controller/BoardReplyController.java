package org.mnu.controller;
/**
 * @brief 게시글 댓글 처리 
 * @details 게시글 댓글 url 요청 처리 
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mnu.domain.BoardReplyVO;
import org.mnu.domain.LoginVO;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping("/reply")
@Log4j
public class BoardReplyController {
	
	@Autowired
	@Qualifier("brs")
	private BoardReplyService service;
	
	// 댓글 리스트
	/**
	 * @brief 댓글 리스트 페이지 
	 * @details 댓글 리스트 페이지 
	 * */
	@GetMapping(value = "/list")
	public ResponseEntity<List<BoardReplyVO>> list(Long no){
		return new ResponseEntity<List<BoardReplyVO>>(service.list(no),HttpStatus.OK);
	}
	
	//댓글 작성
	/** 
	 * @brief 댓글 작성 처리 페이지
	 * @details 댓글을 작성해서 db에 반영
	 * */
	@PostMapping(value = "/write", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> write(@RequestBody BoardReplyVO vo, HttpSession session) {
		log.info("writeReply.vo : " + vo);
		vo.setWriter(((LoginVO)session.getAttribute("login")).getId());
//		vo.setId(((LoginVO)session.getAttribute("login")).getId());
		
		int writeCount = service.write(vo);
		
		log.info(writeCount);
	
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//댓글 수정
	/** 
	 * @brief 댓글 수정 처리 페이지
	 * @details 댓글을 수정해서 db에 반영
	 * */
	@PatchMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(@RequestBody BoardReplyVO vo) {
		log.info("updateReply.vo : " + vo);
		int updateCount = service.update(vo);
		log.info(updateCount);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//댓글 삭제
	/** 
	 * @brief 댓글 삭제 처리 페이지 
	 * @details 댓글을 삭제 처리하고 db에 반영 
	 * */
	@DeleteMapping(value = "/delete", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(Long rno, RedirectAttributes rttr) {
		log.info("deleteReply.rno : " + rno);
		
		int deleteCount = service.delete(rno);
		log.info(deleteCount);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
