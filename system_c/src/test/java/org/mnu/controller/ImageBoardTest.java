package org.mnu.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.BoardVO;
import org.mnu.domain.ImageVO;
import org.mnu.mapper.ImageMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ImageBoardTest {
	
	@Inject
	private ImageMapper mapper;
	@Test
	public void testList() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 1. 커뮤니티게시판 리스트 테스트 ====================================");
		log.info(mapper.list(pageObject) + "\n");
	}
	
	@Test
	public void testList_soup_category() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 1-1. 카페, 디저트 카테고리 리스트 테스트 ====================================");
		log.info(mapper.soup_category(pageObject) + "\n");
	}
	
	@Test
	public void testList_chinesefood_category() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 1-2. 중식 카테고리 리스트 테스트 ====================================");
		log.info(mapper.chinesefood_category(pageObject) + "\n");
	}
	
	@Test
	public void testList_fastfood_category() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 1-3. 패스트푸드 카테고리 리스트 테스트 ====================================");
		log.info(mapper.fastfood_category(pageObject) + "\n");
	}
	
	@Test
	public void testList_snackbar_category() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 1-4. 분식 카테고리 리스트 테스트 ====================================");
		log.info(mapper.snackbar_category(pageObject) + "\n");
	}
	
	@Test
	public void testView() throws Exception{
		long no = 84;
		log.info("==================================== 2. 커뮤니티게시판 게시글 조회 테스트 ====================================");
		log.info(mapper.view(no) + "\n");
	}
	
	@Test
	public void testWrite() throws Exception{
		ImageVO vo = new ImageVO();
		
		vo.setTitle("커뮤니티 게시글 작성 테스트 진행");
		vo.setContent("커뮤니티 게시글 작성 테스트 진행중");
		vo.setId("admin");
		vo.setFileName("/upload/image/noImage.jpg");
		vo.setCategory("중식");
		log.info("==================================== 3. 커뮤니티게시판 게시글 작성 테스트 ====================================");
		log.info(mapper.write(vo) + "\n");
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		ImageVO vo = new ImageVO();
		
		vo.setNo(124);
		vo.setTitle("커뮤니티 게시글 수정 테스트 진행");
		vo.setContent("커뮤니티 게시글 수정 테스트 진행중");
		log.info("==================================== 4. 커뮤니티게시판 게시글 수정 테스트 ====================================");
		log.info(mapper.update(vo) + "\n");
	}
	
	@Test
	public void testDelete() throws Exception{
		long no  = 124;
		log.info("==================================== 5. 커뮤니티게시판 게시글 삭제 테스트 ====================================");
		log.info(mapper.delete(no) + "\n");
	}
	
	@Test
	public void testImageUpdate() throws Exception{
		ImageVO vo = new ImageVO();
		vo.setFileName("/upload/image/noImage.jpg");
		vo.setNo(133);
		log.info("==================================== 6. 이미지 변경 테스트 ====================================");
		log.info(mapper.changeImage(vo) + "\n");
	}
	
	

}
