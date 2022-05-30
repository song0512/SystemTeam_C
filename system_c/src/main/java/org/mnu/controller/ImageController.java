package org.mnu.controller;

import java.net.URLEncoder;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		log.info("list()");
		
		model.addAttribute("list", service.list(pageObject));
		return "image/list";
	}
	
	@GetMapping("/view")
	public String view(long no, Model model) throws Exception {
		ImageVO vo  = service.view(no);
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		model.addAttribute("vo", vo);
		return "image/view";
	}
	
	@PostMapping("/changeImage")
	public String changeImage(PageObject pageObject,ImageVO vo, HttpServletRequest request) throws Exception {
		String path = "/upload/image";
		
		String fileName = FileUtil.upload(path, vo.getImage(), request);
		vo.setFileName(fileName);
		
		service.changeImage(vo);
		
		FileUtil.remove(FileUtil.getRealPath("", vo.getDeleteImage(), request));
	
		
		return "redirect:view?no=" + vo.getNo()
				+ "&page=" +pageObject.getPage()
				+ "&perPageNum=" +pageObject.getPerPageNum()
				+ "&key=" +pageObject.getKey()
				//+ "&word="+URLEncoder.encode(pageObject.getWord(),"utf-8")
				+"&word="+pageObject.getWord();
	}
	
	@GetMapping("/write")
	public String writeForm() throws Exception {
		return "image/write";
	}
	
	@PostMapping("/write")
	public String write(PageObject pageObject, ImageVO vo,HttpSession session, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		log.info(pageObject);
		
		vo.setId(((LoginVO)session.getAttribute("login")).getId());
		
		String path = "/upload/image";
		String fileName =FileUtil.upload(path, vo.getImage(), request);
		vo.setFileName(fileName);
		
		service.write(vo);
		rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
		return "redirect:list?page=1&perPageNum="+pageObject.getPerPageNum();
	}
	
	@GetMapping("/update")
	public String updateForm(PageObject pageObject, long no, Model model) throws Exception {
		model.addAttribute("vo", service.view(no));
		return "image/update";
	}
	
	@PostMapping("/update")
	public String update(PageObject pageObject, ImageVO vo, RedirectAttributes rttr) throws Exception {
		log.info(vo);
		log.info(pageObject);
		
		service.update(vo);
		rttr.addFlashAttribute("msg", "게시글이 수정되었습니다.");
		
		return "redirect:view?no="+vo.getNo()
				+ "&page="+pageObject.getPage()
				+ "&perPageNum="+pageObject.getPerPageNum()
				+ "&key="+pageObject.getKey()
				+ "&word="+URLEncoder.encode(pageObject.getWord(),"utf-8");
	}
	
	@GetMapping("/delete")
	public String delete(PageObject pageObject, long no, String deleteImage, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		log.info(no);
		log.info(pageObject);
		log.info(deleteImage);
		
		service.delete(no);
		
		FileUtil.remove(FileUtil.getRealPath("", deleteImage, request));
		return "redirect:list?perPageNum="+pageObject.getPerPageNum();
	}
}
