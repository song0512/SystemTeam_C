package org.mnu.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() throws Exception{
		log.info("uploadForm()");
	}
	
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
	
	// 파일 여러개 받기
	@GetMapping("/uploadForms")
	public void uploadForms() throws Exception{
		log.info("uploadForms()");
	}
	
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
