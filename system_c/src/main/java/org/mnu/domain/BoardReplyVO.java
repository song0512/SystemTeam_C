package org.mnu.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardReplyVO {
	private long rno;//댓글 번호
	private long no; // 글 번호
	private String content; // 내용
	private String writer; // 작성자
	private Date writeDate; //작성일
}
