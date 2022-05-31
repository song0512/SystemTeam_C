package org.mnu.service;

import java.util.List;

import org.mnu.domain.BoardReplyVO;

public interface BoardReplyService {
	
	public List<BoardReplyVO> list(long no);
	
	public int write(BoardReplyVO vo);
	
	public int update(BoardReplyVO vo);
	
	public int delete(long rno);
}
