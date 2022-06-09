package org.mnu.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.BoardVO;
import org.mnu.mapper.BoardMapper;
import org.mnu.mapper.MemberMapper;
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
		log.info("==================================== 1. 자동 DI Test ====================================");
		log.info(mapper + "\n");
	}
	
	@Test
	public void testList() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 2. 게시판 리스트 테스트 ====================================");
		log.info(mapper.list(pageObject) + "\n");
	}

	@Test
	public void testView() throws Exception{
		long no = 186;
		log.info("==================================== 3. 게시글 조회 테스트 ====================================");
		log.info(mapper.view(no) + "\n");
	}
	
	@Test
	public void testWrite() throws Exception{
		BoardVO vo = new BoardVO();

		vo.setTitle("게시글 작성 테스트 진행");
		vo.setContent("게시글 작성 테스트 진행중");
		log.info("==================================== 4. 게시글 작성 테스트 ====================================");
		log.info(mapper.write(vo) + "\n");
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setNo(186);
		vo.setTitle("게시글 수정 테스트 진행");
		vo.setContent("게시글 수정 테스트 진행중");
		log.info("==================================== 5. 게시글 수정 테스트 ====================================");
		log.info(mapper.update(vo) + "\n");
	}

	@Test
	public void testDelete() throws Exception{
		long no  = 186;
		log.info("==================================== 6. 게시글 삭제 테스트 ====================================");
		log.info(mapper.delete(no) + "\n");
	}
	
}
