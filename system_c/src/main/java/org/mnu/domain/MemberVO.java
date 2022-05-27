package org.mnu.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id, pw, name, status;
	private Date regDate, conDate;
}
