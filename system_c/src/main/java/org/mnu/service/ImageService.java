package org.mnu.service;

import java.util.List;

import javax.inject.Inject;

import org.mnu.domain.ImageVO;
import org.mnu.mapper.ImageMapper;
import org.springframework.stereotype.Service;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

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
