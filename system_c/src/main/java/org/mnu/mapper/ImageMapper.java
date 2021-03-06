package org.mnu.mapper;

import java.util.List;

import org.mnu.domain.ImageVO;

import com.webjjang.util.PageObject;

/**
 * @brief 이미지 게시판 객체 사용 방법 정의 
 * @details 이미지 게시판 객체의 사용 방법을 정의한 타입
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */


public interface ImageMapper {
	
	//list
	public List<ImageVO> list(PageObject pageObject) throws Exception;
	
	//카페, 디저트 category
	public List<ImageVO> soup_category(PageObject pageObject) throws Exception;
	
	//중식 category
	public List<ImageVO> chinesefood_category(PageObject pageObject) throws Exception;
		
	//패스트푸드 category
	public List<ImageVO> fastfood_category(PageObject pageObject) throws Exception;
		
	//분식 category
	public List<ImageVO> snackbar_category(PageObject pageObject) throws Exception;
		

	public long getTotalRow(PageObject pageObject) throws Exception;
	
	//view
	public ImageVO view(long no) throws Exception;
	
	//write
	public int write(ImageVO vo) throws Exception;
	
	//update
	public int update(ImageVO vo) throws Exception;
	
	//changeImage
	public int changeImage(ImageVO vo) throws Exception;
	
	//DeleteImage
	public int delete(long no) throws Exception;

}
