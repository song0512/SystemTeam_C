package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.BoardReplyVO;

public interface BoardReplyMapper {
	
	public List<BoardReplyVO> list(long no);
	
	public int write(BoardReplyVO vo);
	
	public int update(BoardReplyVO vo);
	
	public int delete(long rno);

}
