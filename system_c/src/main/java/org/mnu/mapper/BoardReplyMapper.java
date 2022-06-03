package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.BoardReplyVO;

/**
 * @brief 댓글 객체 사용 방법 정의 
 * @details 댓글 객체의 사용 방법을 정의한 타입
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

public interface BoardReplyMapper {
	
	public List<BoardReplyVO> list(long no);
	
	public int write(BoardReplyVO vo);
	
	public int update(BoardReplyVO vo);
	
	public int delete(long rno);

}
