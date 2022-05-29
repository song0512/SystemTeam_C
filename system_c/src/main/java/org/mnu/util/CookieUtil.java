package org.mnu.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

@Log4j
public class CookieUtil {
	public static void createCookie(String cookieName, String cookiePath, String cookieData, int cookieMaxAge, HttpServletResponse response) throws Exception {
		Cookie storeIdCookie = new Cookie(cookieName, cookieData);
		storeIdCookie.setPath(cookiePath);
		storeIdCookie.setMaxAge(cookieMaxAge);
		response.addCookie(storeIdCookie);
			  
		log.info("** cookie를 생성했습니다.");
	}
				
	public static void createMessageCookie(Integer msg, HttpServletResponse response) throws Exception {
		createCookie("msg", "/", "" + msg, 5 * 60, response);
	}
}