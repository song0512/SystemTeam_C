package org.mnu.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mnu.domain.BoardVO;
import org.mnu.domain.LoginVO;
import org.mnu.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.util.PageObject;

/**
 * @brief 게시판 주소 처리 
 * @details 게시판 url 요청 처리 
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//list
	/** 
	 * @brief 게시판 리스트 페이지 
	 * @details 게시판 리스트 페이지 
	 * */
	@GetMapping("/list")
	public String list(@ModelAttribute PageObject pageObject, Model model) throws Exception {
		if (pageObject.getPage() < 1) pageObject.setPage(1);
		
		model.addAttribute("list", service.list(pageObject));
		
		return "board/list";
	}
	
	//view
	/** 
	 * @brief 게시글 페이지 
	 * @details 게시판에서 게시글을 골라 보는 페이지 
	 * */
	@GetMapping("/view")
	public String view(long no, int inc, Model model) throws Exception {
		BoardVO vo = service.view(no, inc);
		
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		model.addAttribute("vo", vo);
		
		return "board/view";
	}
	
	//writeForm
	/** 
	 * @brief 게시글 작성 페이지
	 * @details 게시글을 작성할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/write")
	public String writeForm() throws Exception {

		return "board/write";
	}
	
	//write
	/** 
	 * @brief 게시글 작성 처리 페이지
	 * @details 게시글을 작성해서 db에 반영
	 * */
	@PostMapping("/write")
	public String write(BoardVO vo, int perPageNum, RedirectAttributes rttr, HttpServletResponse response,HttpSession session) throws Exception {

		vo.setId(((LoginVO)session.getAttribute("login")).getId());
		service.write(vo);
		
		
		rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
		return "redirect:list?page=1&perPageNum="+perPageNum;
	}
	
	//updateForm
	/**
	 * @brief 게시글 수정 페이지
	 * @details 게시글을 수정할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/update")
	public String updateForm(long no,  Model model) throws Exception {
		System.out.println("BoardController.update().vo = "+no);
		model.addAttribute("vo", service.view(no, 0));
		
		return "board/update";
	}
	
	//update
	/** 
	 * @brief 게시글 수정 처리 페이지
	 * @details 게시글을 수정해서 db에 반영
	 * */
	@PostMapping("/update")
	public String update(PageObject pageObject, BoardVO vo,RedirectAttributes rttr) throws Exception {
		service.update(vo);
		rttr.addFlashAttribute("msg", "게시글이 수정되었습니다.");
		
		return "redirect:view?no="+vo.getNo() + "&inc=0"
				+ "&page="+pageObject.getPage() + "&perPageNum="+pageObject.getPerPageNum();
	}
	
	//delete
	/** 
	 * @brief 게시글 삭제 처리 페이지 
	 * @details 게시글을 삭제 처리하고 db에 반영 
	 * */
	@GetMapping("/delete")
	public String delete(long no, int perPageNum,RedirectAttributes rttr) throws Exception {
		service.delete(no);
		
		rttr.addFlashAttribute("msg", "게시글이 삭제되었습니다.");
		
		return "redirect:list?perPageNum="+perPageNum;
	}
}
