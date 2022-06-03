package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.BoardVO;

import com.webjjang.util.PageObject;

/**
 * @brief 게시판 객체 사용 방법 정의 
 * @details 게시판 객체의 사용 방법을 정의한 타입
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

public interface BoardMapper {
	
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	public BoardVO view(long no)throws Exception;
	
	public int increase(long no)throws Exception;
	
	public int write(BoardVO vo)throws Exception;
	
	public int update(BoardVO vo)throws Exception;
	
	public int delete(long no) throws Exception;

}
