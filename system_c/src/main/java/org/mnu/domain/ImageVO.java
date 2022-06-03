package org.mnu.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
/**
 * @brief 이미지 게시판 VO 
 * @details 각 계층간 데이터를 교환하기 위한 이미지 게시판VO
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */
@Data
public class ImageVO {

	private long no;
	private String title;
	private String content;
	private String id;
	private String name;
	private Date writeDate;
	private String fileName;
	private MultipartFile image;
	private String deleteImage;
	private String category;
}
