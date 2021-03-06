package org.mnu.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @brief 회원 VO 
 * @details 각 계층간 데이터를 교환하기 위한 회원VO
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String name; 
	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private Date conDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getConDate() {
		return conDate;
	}
	public void setConDate(Date conDate) {
		this.conDate = conDate;
	}
	
}
