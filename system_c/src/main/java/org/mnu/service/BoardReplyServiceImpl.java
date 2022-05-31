package org.mnu.service;

import java.util.List;

import javax.inject.Inject;

import org.mnu.domain.BoardReplyVO;
import org.mnu.mapper.BoardReplyMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("brs")
public class BoardReplyServiceImpl implements BoardReplyService{
	
	@Inject
	private BoardReplyMapper mapper;

	@Override
	public List<BoardReplyVO> list(long no) {
		// TODO Auto-generated method stub
		return mapper.list(no);
	}

	@Override
	public int write(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.write(vo);
	}

	@Override
	public int update(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(long rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}



}
