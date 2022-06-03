package org.mnu.domain;

import lombok.Data;

/**
 * @brief 로그인 VO 
 * @details 각 계층간 데이터를 교환하기 위한 로그인VO
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Data
public class LoginVO {
	private String id, name, pw;

}
