package org.mnu.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.BoardVO;
import org.mnu.mapper.BoardMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTest {
	
	//자유게시판 테스트 완료
	
	@Inject
	private BoardMapper mapper;
	
	@Test
	public void testDI() {
		log.info("==================================== 자동 DI Test ====================================");
		log.info(mapper + "\n");
	}
	
	@Test
	public void testList() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 게시판 리스트 테스 ====================================");
		log.info(mapper.list(pageObject) + "\n");
	}

	@Test
	public void testView() throws Exception{
		long no = 23;
		log.info("==================================== 게시글 보기 test ====================================");
		log.info(mapper.view(no) + "\n");
	}
	
	@Test
	public void testWrite() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 진행");
		vo.setContent("테스트 진행중");
		vo.setWriter("SE");
		log.info("==================================== 게시글 쓰기 test ====================================");
		log.info(mapper.write(vo) + "\n");
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setNo(7);
		vo.setTitle("테스트 진행");
		vo.setContent("테스트 진행중");
		vo.setWriter("SE");
		log.info("==================================== 게시글 글수정 test ====================================");
		log.info(mapper.update(vo) + "\n");
	}

	@Test
	public void testDelete() throws Exception{
		long no  = 24;
		log.info("==================================== 게시글 글삭제 test ====================================");
		log.info(mapper.delete(no) + "\n");
	}
	
}
