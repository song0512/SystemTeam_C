package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.BoardVO;

import com.webjjang.util.PageObject;

public interface BoardMapper {
	
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	public BoardVO view(long no)throws Exception;
	
	public int increase(long no)throws Exception;
	
	public int write(BoardVO vo)throws Exception;
	
	public int update(BoardVO vo)throws Exception;
	
	public int delete(long no) throws Exception;

}
