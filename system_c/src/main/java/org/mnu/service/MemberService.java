package org.mnu.service;

import java.util.List;

import javax.inject.Inject;

import org.mnu.domain.BoardVO;
import org.mnu.domain.LoginVO;
import org.mnu.domain.MemberVO;
import org.mnu.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import com.webjjang.util.PageObject;

/**
 * @brief 회원 처리 서비스 
 * @details MemberService에 정보를 MemberController로 데이터를 넘기는 역할
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Service
public class MemberService {
	
	@Inject
	private MemberMapper mapper;
	
	//회원리스트
	public List<MemberVO> list(PageObject pageObject) throws Exception {
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}
	
	//회원 정보, 내정보 확인
	public MemberVO view(String id) throws Exception {
		return mapper.view(id);
	}
	
	//회원가입
	public int write(MemberVO vo) throws Exception {
		return mapper.write(vo);
	}
	
	//로그인
	public LoginVO login(LoginVO invo) throws Exception {
		return mapper.login(invo);
	}
	
	//아이디 중복체크 -> 아이디 가져옴
	public String idCheck(String id) throws Exception {
		return mapper.idCheck(id);
	}
	
	// 회원정보 수정
	public int update(MemberVO vo) throws Exception {
		return mapper.update(vo);
	}
	
	//회원탈퇴
	public void delete(String id) throws Exception {
		mapper.delete(id);
	}
}
