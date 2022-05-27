package org.mnu.service;

import java.util.List;

import javax.inject.Inject;

import org.mnu.domain.BoardVO;
import org.mnu.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import com.webjjang.util.PageObject;

@Service
public class BoardService {
	
	@Inject
	private BoardMapper mapper;
	
	//list
	public List<BoardVO> list(PageObject pageObject) throws Exception{
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		System.out.println("BoardService.list().pageObject - " + pageObject);
		return mapper.list(pageObject);
	}
	
	//view
	public BoardVO view(long no, int inc) throws Exception {
		if(inc == 1) mapper.increase(no);
		return mapper.view(no);
	}
	
	//write
	public int write(BoardVO vo) throws Exception {
		return mapper.write(vo);
	}
	
	//update
	public int update(BoardVO vo) throws Exception {
		return mapper.update(vo);
	}

	//delete
	public int delete(long no) throws Exception {
		return mapper.delete(no);
	}
}
