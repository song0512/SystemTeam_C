package org.mnu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mnu.domain.ImageVO;
import org.mnu.domain.LoginVO;
import org.mnu.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.webjjang.util.PageObject;
import com.webjjang.util.file.FileUtil;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/image")
@Log4j
public class ImageController {
	
	@Autowired
	private ImageService service;
	
	@GetMapping("/list")
	public String list(PageObject pageObject, Model model) throws Exception {
		if(pageObject.getPage()<1)pageObject.setPage(1);
		log.info("list()");
		
		model.addAttribute("list", service.list(pageObject));
		return "image/list";
	}
	
	@GetMapping("/view")
	public String view(long no, Model model) throws Exception {
		model.addAttribute("vo", service.view(no));
		return "image/view";
	}
	
	@PostMapping("/changeImage")
	public String changeImage(PageObject pageObject, MultipartFile imageFile) throws Exception {
		return "redirect:view";
	}
	
	@GetMapping("/write")
	public String writeForm() throws Exception {
		return "image/write";
	}
	
	@PostMapping("/write")
	public String write(PageObject pageObject, ImageVO vo,HttpSession session, HttpServletRequest request) throws Exception {
		log.info(pageObject);
		
		vo.setId(((LoginVO)session.getAttribute("login")).getId());
		
		String path = "/upload/image";
		String fileName =FileUtil.upload(path, vo.getImage(), request);
		vo.setFileName(fileName);
		
		log.info(vo);
		
		service.write(vo);
		return "redirect:list?page=1&perPageNum="+pageObject.getPerPageNum();
	}
	
	@GetMapping("/upadte")
	public String updateForm(PageObject pageObject, long no, Model model) throws Exception {
		return "image/upadte";
	}
	
	@PostMapping("/upadte")
	public String update(PageObject pageObject, ImageVO vo) throws Exception {
		return "redirect:view";
	}
	
	@GetMapping("/delete")
	public String delete(PageObject pageObject, long no, String deleteFile) throws Exception {
		return "redirect:list";
	}
}
