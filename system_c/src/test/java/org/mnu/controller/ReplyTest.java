package org.mnu.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.BoardReplyVO;
import org.mnu.mapper.BoardReplyMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyTest {
	@Inject
	private BoardReplyMapper mapper;
	
	@Test
	public void testList() throws Exception{
		long no = 164;
		log.info("==================================== 1. 댓글 조회 테스트 ====================================");
		log.info(mapper.list(no) + "\n");
	}
	
	@Test
	public void testWrite() throws Exception{
		BoardReplyVO vo = new BoardReplyVO();
		
		vo.setNo(190);
		vo.setContent("댓글 작성 테스트 진행중");
		vo.setWriter("admin");
		
		log.info("==================================== 2. 댓글 작성 테스트 ====================================");
		log.info(mapper.write(vo) + "\n");
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardReplyVO vo = new BoardReplyVO();
		vo.setWriter("admin2");
		vo.setContent("댓글 수정 테스트 진행중");
		vo.setRno(102);
		log.info("==================================== 3. 댓글 수정 테스트 ====================================");
		log.info(mapper.update(vo) + "\n");
	}
	
	@Test
	public void testDelete() throws Exception{
		long rno = 102;
		log.info("==================================== 4. 댓글 삭제 테스트 ====================================");
		log.info(mapper.delete(rno) + "\n");
	}
}
