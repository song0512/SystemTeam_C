package org.mnu.service;

import java.util.List;

import javax.inject.Inject;

import org.mnu.domain.BoardReplyVO;
import org.mnu.mapper.BoardReplyMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @brief 댓글 처리 비즈니스로직
 * @details 댓글 처리 기능을 구현하는 구현부
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Service
@Qualifier("brs")
public class BoardReplyServiceImpl implements BoardReplyService{
	
	@Inject
	private BoardReplyMapper mapper;

	@Override
	public List<BoardReplyVO> list(long no) {
		return mapper.list(no);
	}

	@Override
	public int write(BoardReplyVO vo) {
		return mapper.write(vo);
	}

	@Override
	public int update(BoardReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int delete(long rno) {
		return mapper.delete(rno);
	}



}
