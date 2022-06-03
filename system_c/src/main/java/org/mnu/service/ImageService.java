package org.mnu.service;

import java.util.List;

import javax.inject.Inject;

import org.mnu.domain.ImageVO;
import org.mnu.mapper.ImageMapper;
import org.springframework.stereotype.Service;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

/**
 * @brief 이미지게시판 처리 서비스 
 * @details ImageService에 정보를 ImageController로 데이터를 넘기는 역할
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */


@Service
@Log4j
public class ImageService {
	@Inject
	private ImageMapper mapper;
	
	//이미지 갤러리
	public List<ImageVO> list(PageObject pageObject) throws Exception {
		log.info(pageObject);
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}
	
	//카페, 디저트 category
	public List<ImageVO> soup_category(PageObject pageObject) throws Exception {
		log.info(pageObject);
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.soup_category(pageObject);
	}
	
	//중식 category
	public List<ImageVO> chinesefood_category(PageObject pageObject) throws Exception {
		log.info(pageObject);
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.chinesefood_category(pageObject);
	}
	
	//패스트푸드 category
	public List<ImageVO> fastfood_category(PageObject pageObject) throws Exception {
		log.info(pageObject);
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.fastfood_category(pageObject);
	}
	
	//분식 category
	public List<ImageVO> snackbar_category(PageObject pageObject) throws Exception {
		log.info(pageObject);
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.snackbar_category(pageObject);
	}
	
	//이미지 보기 
	public ImageVO view(long no) throws Exception {
		log.info(log);
		return mapper.view(no);
	}
	
	// 이미지 등록 
	public int write(ImageVO vo) throws Exception {
		log.info(vo);
		return mapper.write(vo);
	}
	
	// 이미지 변경 
	public int changeImage(ImageVO vo) throws Exception {
		log.info(vo);
		return mapper.changeImage(vo);
	}
	
	//정보수정
	public int update(ImageVO vo) throws Exception {
		log.info(vo);
		return mapper.update(vo);
	}
	
	//이미지게시글 삭제
	
	public int delete(long no) throws Exception {
		log.info(no);
		return mapper.delete(no);
	}

}
