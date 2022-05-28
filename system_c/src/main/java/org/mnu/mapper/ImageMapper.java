package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.ImageVO;

import com.webjjang.util.PageObject;

public interface ImageMapper {
	
	//list
	public List<ImageVO> list(PageObject pageObject) throws Exception;
	
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	//view
	public ImageVO view(long no) throws Exception;
	
	
	//write
	public int write(ImageVO vo) throws Exception;

}
