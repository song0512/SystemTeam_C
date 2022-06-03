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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.util.PageObject;
import com.webjjang.util.file.FileUtil;

import lombok.extern.log4j.Log4j;

/**
 * @brief 이미지게시판 주소 처리 
 * @details 이미지게시판 url 요청 처리 
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Controller
@RequestMapping("/image")
@Log4j
public class ImageController {
	
	@Autowired
	private ImageService service;
	
	@GetMapping("/list")
	/**
	 * @brief 이미지게시판 리스트 페이지 
	 * @details 이미지게시판 리스트 페이지 
	 * */
	public String list(PageObject pageObject, Model model) throws Exception {
		if(pageObject.getPage()<1)pageObject.setPage(1);
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		log.info("list()");
		
		model.addAttribute("list", service.list(pageObject));
		return "image/list";
	}
	
	// 카페, 디저트 카테고리
	/** 
	 * @brief 카페-디저트 카테고리 리스트 페이지  
	 * @details 카페-디저트 카테고리에 해당하는 게시글만 보여주는 페이지  
	 * */
	@GetMapping("/soup_category")
	public String soup_category(PageObject pageObject, Model model) throws Exception {
		if(pageObject.getPage()<1)pageObject.setPage(1);
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		log.info("soup_category()");
		
		model.addAttribute("soup_category", service.soup_category(pageObject));
		return "image/soup_category";
	}
	
	// 중식 카테고리
	/** 
	 * @brief 중식 카테고리 리스트 페이지  
	 * @details 중식 카테고리에 해당하는 게시글만 보여주는 페이지  
	 * */
	@GetMapping("/chinesefood_category")
	public String chinesefood_category(PageObject pageObject, Model model) throws Exception {
		if(pageObject.getPage()<1)pageObject.setPage(1);
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		log.info("chinesefood_category()");
		
		model.addAttribute("chinesefood_category", service.chinesefood_category(pageObject));
		return "image/chinesefood_category";
	}
	
	// 패스트푸드 카테고리 
	/** 
	 * @brief 패스트푸드 카테고리 리스트 페이지  
	 * @details 패스트푸드 카테고리에 해당하는 게시글만 보여주는 페이지  
	 * */
	@GetMapping("/fastfood_category")
	public String fastfood_category(PageObject pageObject, Model model) throws Exception {
		if(pageObject.getPage()<1)pageObject.setPage(1);
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		log.info("fastfood_category()");
		
		model.addAttribute("fastfood_category", service.fastfood_category(pageObject));
		return "image/fastfood_category";
	}
	
	
	// 분식 카테고리
	/** 
	 * @brief 분식 카테고리 리스트 페이지  
	 * @details 분식 카테고리에 해당하는 게시글만 보여주는 페이지  
	 * */
	@GetMapping("/snackbar_category")
	public String snackbar_category(PageObject pageObject, Model model) throws Exception {
		if(pageObject.getPage()<1)pageObject.setPage(1);
		if(pageObject.getPerPageNum() == 10) pageObject.setPerPageNum(8);
		log.info("snackbar_category()");
		
		model.addAttribute("snackbar_category", service.snackbar_category(pageObject));
		return "image/snackbar_category";
	}

	
	
	/** 
	 * @brief 이미지게시글 페이지 
	 * @details 이미지게시판에서 이미지게시글을 골라 보는 페이지 
	 * */
	@GetMapping("/view")
	public String view(long no, Model model) throws Exception {
		ImageVO vo  = service.view(no);
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		model.addAttribute("vo", vo);
		return "image/view";
	}
	
	/** 
	 * @brief 이미지게시글 사진 바꾸는 페이지 
	 * @details 이미지 게시글에 사진을 바꾸고 DB에 반영한다.
	 * */
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
	
	
	/** 
	 * @brief 이미지 게시글 작성 페이지
	 * @details 이미지 게시글을 작성할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/write")
	public String writeForm() throws Exception {
		return "image/write";
	}
	
	//write
	/** 
	 * @brief 이미지 게시글 작성 처리 페이지
	 * @details 이미지 게시글을 작성해서 db에 반영
	 * */
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
	
	/** 
	 * @brief 이미지 게시글 수정 페이지
	 * @details 이미지 게시글을 수정할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/update")
	public String updateForm(PageObject pageObject, long no, Model model) throws Exception {
		model.addAttribute("vo", service.view(no));
		return "image/update";
	}
	
	/** 
	 * @brief 이미지 게시글 수정 처리 페이지
	 * @details 이미지 게시글을 수정해서 db에 반영
	 * */
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
	
	/** 
	 * @brief 이미지 게시글 삭제 처리 페이지 
	 * @details 이미지 게시글을 삭제 처리하고 db에 반영 
	 * */
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
