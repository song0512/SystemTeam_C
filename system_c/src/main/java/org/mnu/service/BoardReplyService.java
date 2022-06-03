package org.mnu.service;

import java.util.List;

import org.mnu.domain.BoardReplyVO;

/**
 * @brief 댓글 처리 서비스 
 * @details 댓글 처리 서비스
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

public interface BoardReplyService {
	
	public List<BoardReplyVO> list(long no);
	
	public int write(BoardReplyVO vo);
	
	public int update(BoardReplyVO vo);
	
	public int delete(long rno);
}
