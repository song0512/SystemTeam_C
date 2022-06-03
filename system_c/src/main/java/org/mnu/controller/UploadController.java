package org.mnu.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.log4j.Log4j;

/**
 * @brief 파일업로드 주소 처리 
 * @details 파일업로드 url 요청 처리 
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Controller
@Log4j
public class UploadController {
	
	/** 
	 * @brief 파일업로드 작성 페이지
	 * @details 파일을 업로드할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/uploadForm")
	public void uploadForm() throws Exception{
		log.info("uploadForm()");
	}
	
	/** 
	 * @brief 파일업로드 작성 처리 페이지
	 * @details 파일을 업로드해서 db에 반영
	 * */
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile uploadFile, HttpServletRequest request,
			Model model) throws Exception {
		log.info(uploadFile);

		//서버기준 상대 위치
		String path = "/upload";
		
		//request 이용 -> 절대 위치 구함 
		String savePath = request.getServletContext().getRealPath(path);
		log.info(savePath);
		
		//파일 저장 (동일 파일 이름일 경우 -> 덮어씀?)
		uploadFile.transferTo(new File(savePath, uploadFile.getOriginalFilename()));
		//DB에 저장될 파일 정보 
		String fileName = path + "/" + uploadFile.getOriginalFilename();
		log.info(fileName);
		
		model.addAttribute("fileName", fileName);
	}
	
	/** 
	 * @brief 여러개의 파일업로드 작성 페이지
	 * @details 여러개의 파일을 업로드할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/uploadForms")
	public void uploadForms() throws Exception{
		log.info("uploadForms()");
	}
	
	
	/** 
	 * @brief 여러개의 파일업로드 작성 처리 페이지
	 * @details 여러개의 파일을 업로드해서 db에 반영
	 * */
	@PostMapping("/uploadFormActions")
	public void uploadFormActions(MultipartFile uploadFiles, HttpServletRequest request,
			Model model) throws Exception {
		log.info(uploadFiles);

		
		//서버기준 상대 위치
		String path = "/upload";
		
		//request 이용 -> 절대 위치 구함 
		String savePath = request.getServletContext().getRealPath(path);
		log.info(savePath);
		
		//파일 저장 (동일 파일 이름일 경우 -> 덮어씀?)
		uploadFiles.transferTo(new File(savePath, uploadFiles.getOriginalFilename()));
		//DB에 저장될 파일 정보 
		String fileName = path + "/" + uploadFiles.getOriginalFilename();
		log.info(fileName);
		
		model.addAttribute("fileName", fileName);
	}

}
