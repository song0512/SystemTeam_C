package org.mnu.domain;

import java.util.Date;

import lombok.Data;
/**
 * @brief 게시판 VO 
 * @details 각 계층간 데이터를 교환하기 위한 게시판VO
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */
@Data
public class BoardVO {
	private long no;
	private long hit;
	private String title;
	private String content;
	private String id;
	private String name;
	private Date writeDate;
}
