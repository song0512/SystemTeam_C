package org.mnu.domain;

import java.util.Date;

import lombok.Data;
/**
 * @brief 댓글 VO 
 * @details 각 계층간 데이터를 교환하기 위한 댓글VO
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */
@Data
public class BoardReplyVO {
	/**
	 * @brief 댓글 번호 데이터
	 * */
	private long rno;//댓글 번호
	/**
	 * @brief 글 번호 데이터
	 * */
	private long no; // 글 번호
	/**
	 * @brief 댓글 내용 데이터
	 * */
	private String content; // 내용
	/**
	 * @brief 댓글 작성자 데이터
	 * */
	private String writer; // 작성자
	/**
	 * @brief 댓글 작성일 데이터
	 * */
	private Date writeDate; //작성일
}
