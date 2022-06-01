package org.mnu.domain;

import java.util.Date;

import lombok.Data;

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
