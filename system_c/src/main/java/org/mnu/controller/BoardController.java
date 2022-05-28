package org.mnu.controller;

import org.mnu.domain.BoardVO;
import org.mnu.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.webjjang.util.PageObject;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	//list
	@GetMapping("/list")
	public String list(@ModelAttribute PageObject pageObject, Model model) throws Exception {
		if (pageObject.getPage() < 1) pageObject.setPage(1);
		
		model.addAttribute("list", service.list(pageObject));
		
		return "board/list";
	}
	
	//view
	@GetMapping("/view")
	public String view(long no, int inc, Model model) throws Exception {
		BoardVO vo = service.view(no, inc);
		
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		model.addAttribute("vo", vo);
		
		return "board/view";
	}
	
	//writeForm
	@GetMapping("/write")
	public String writeForm() throws Exception {

		return "board/write";
	}
	
	//write
	@PostMapping("/write")
	public String write(BoardVO vo, int perPageNum) throws Exception {
		service.write(vo);
		return "redirect:list?page=1&perPageNum="+perPageNum;
	}
	
	//updateForm
	@GetMapping("/update")
	public String updateForm(long no,  Model model) throws Exception {
		System.out.println("BoardController.update().vo = "+no);
		model.addAttribute("vo", service.view(no, 0));
		
		return "board/update";
	}
	
	//update
	@PostMapping("/update")
	public String update(PageObject pageObject, BoardVO vo) throws Exception {
		service.update(vo);
		return "redirect:view?no="+vo.getNo() + "&inc=0"
				+ "&page="+pageObject.getPage() + "&perPageNum="+pageObject.getPerPageNum();
	}
	
	//delete
	@GetMapping("/delete")
	public String delete(long no, int perPageNum) throws Exception {
		service.delete(no);
		
		return "redirect:list?perPageNum="+perPageNum;
	}
}