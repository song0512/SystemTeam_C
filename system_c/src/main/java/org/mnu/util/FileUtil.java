package org.mnu.util;

import java.io.File;

/**
 * @brief 파일 처리 
 * @details 파일 처리 
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */


public class FileUtil {

	// 파일이 존재하는지 확인하는 메서드
	/**
	 * @brief 파일 존재 여부  
	 * @details 파일이 존재하는지 확인하는 메서드
	 * */
	public static boolean exist(File file) throws Exception{
		return file.exists();
	}
	
	// 파일이 존재하는지 확인하는 메서드
	public static boolean exist(String fileName) throws Exception{
		return toFile(fileName).exists();
	}
	
	// 문자열을 파일 객체로 만들어 주는 메서드
	/**
	 * @brief 파일 객체 변환
	 * @details 문자열을 파일 객체로 만들어 주는 메서드
	 * */
	public static File toFile(String fileName) throws Exception{
		return new File(fileName);
	}
	
	// 파일 지우기
	/**
	 * @brief 파일 지우기
	 * @details 파일 지우기
	 * */
	public static boolean delete(File file) throws Exception {
		return file.delete();
	}
	
	// 파일의 정보를 문자열로 넣어주면 지워주는 메서드
	/**
	 * @brief 파일 삭제
	 * @details 파일을 삭제하는 메서드
	 * */
	public static boolean remove(String fileName) throws Exception {
		File file = toFile(fileName);
		if(!exist(file)) throw new Exception("삭제하려는 파일이 존재하지 않습니다.");
		if(!delete(file)) throw new Exception("삭제하려는 파일이 삭제되지 않았습니다.");
		System.out.println("FileUtil.remove() - 파일이 삭제 되었습니다.");
		return true;
	}
	
	// 중복된 파일에 대한 처리 - 중복이 되지 않는 파일 객체를 리턴해 준다.
	/**
	 * @brief 중복 파일 처리 
	 * @details 중복이 되는 파일을 처리하는 메서드
	 * */
	public static File noDuplicate(String fileFullName) throws Exception {
		System.out.println("FileUtil.noDuplicate().fileFullName"+fileFullName);
		
		File file = null;
		int dotPos = fileFullName.lastIndexOf(".");
		String fileName = fileFullName.substring(0, dotPos);
		String ext = fileFullName.substring(dotPos); 
		int cnt = 0; 

		while(true) {
			if(cnt == 0)
				file = toFile(fileFullName);
			else file = toFile(fileName + cnt + ext);
			if(!exist(file)) break;
			cnt++;
		}
		
		return file;
	}
	
	
}
