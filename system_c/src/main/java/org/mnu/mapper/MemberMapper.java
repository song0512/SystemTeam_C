package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.MemberVO;
import org.mnu.domain.LoginVO;

import com.webjjang.util.PageObject;

/**
 * @brief 회원 객체 사용 방법 정의 
 * @details 회원 객체의 사용 방법을 정의한 타입
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

public interface MemberMapper {
	
	// 리스트
	public List<MemberVO> list(PageObject pageObject) throws Exception;
	
	//전체 데이터 개수
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	//보기
	public MemberVO view(String id)throws Exception;
	
	//회원가입
	public int write(MemberVO vo)throws Exception;
	
	//수정
	public int update(MemberVO vo)throws Exception;

	// 로그인 처리
	public LoginVO login(LoginVO invo) throws Exception;
	
	//아이디 중복 체크 
	public String idCheck(String id) throws Exception;
	
	// 탈퇴
	public void delete(String id) throws Exception;
	
}
