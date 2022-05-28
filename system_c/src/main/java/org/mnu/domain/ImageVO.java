package org.mnu.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

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
	


}
