package org.mnu.controller;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnu.domain.BoardVO;
import org.mnu.domain.LoginVO;
import org.mnu.domain.MemberVO;
import org.mnu.mapper.MemberMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberTest {
	
	@Inject
	private MemberMapper mapper;
	
	@Test
	public void testList() throws Exception{
		PageObject pageObject = new PageObject();
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("==================================== 1. 사용자 리스트 테스트 ====================================");
		log.info(mapper.list(pageObject) + "\n");
	}
	
	@Test
	public void testWrite() throws Exception{
		MemberVO vo = new MemberVO(); 
		
		vo.setId("user222");
		vo.setPw("asd1233");
		vo.setName("유저22");
		vo.setStatus("정상");
		log.info("==================================== 2. 회원가입 테스트 ====================================");
		try {
			log.info("==================================== 2-1. 회원가입 성공 테스트 ====================================");
			log.info(mapper.write(vo) + "\n");
			
		}catch(Exception e) {
			log.info("==================================== 2-2. 회원가입 실패 테스트 ====================================");
			e.printStackTrace();
			log.error(e.getMessage());
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testLogin() throws Exception{
		LoginVO vo = new LoginVO();
		
		vo.setId("admin");
		vo.setPw("admin");

		log.info("==================================== 로그인 테스트 ====================================");
	
		log.info(mapper.login(vo) + "\n");
			
		
	}
}
