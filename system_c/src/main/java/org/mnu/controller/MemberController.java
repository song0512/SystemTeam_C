package org.mnu.controller;

import javax.servlet.http.HttpSession;

import org.mnu.domain.LoginVO;
import org.mnu.domain.MemberVO;
import org.mnu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
	//로그인 폼
	@GetMapping("/login")
	public String loginForm() throws Exception {
		log.info("loginForm--");
		return "member/login";
	}
	
	//로그인 - id, pw 입력해서 보냄 -> 받음
	@PostMapping("/login")
	public String login(LoginVO invo, HttpSession session) throws Exception {
		log.info("login 처리 ="+ invo);
		
		session.setAttribute("login", service.login(invo));
		return "redirect:/board/list";
	}

	//로그아웃 처리 - session 지움
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) throws Exception {
		session.removeAttribute("login");
		rttr.addFlashAttribute("msg", "로그아웃 되셨습니다.");
		
		log.info("로그아웃 됨");
		return "redirect:/board/list";
	}
	
	//회원리스트 - 관리자만 가능 
	@GetMapping("/list")
	public String list(@ModelAttribute PageObject pageObject, Model model) throws Exception{
		
		model.addAttribute("list", service.list(pageObject));
		return "member/list";
	}
	
	//회원 정보, 내 정보 확인 
	@GetMapping("/view")
	public String view(String id, Model model, HttpSession session) throws Exception{
		if(id == null) {
			model.addAttribute("title", "내 정보 보기");
			id = ((LoginVO) session.getAttribute("login")).getId();
		} else {
			model.addAttribute("title", "회원 정보 보기");
		}
		model.addAttribute("vo", service.view(id));
		return "member/view";
	}
	
	//회원가입 폼
	@GetMapping("/write")
	public String writeForm() throws Exception {
		return "member/write";
	}
	
	//회원가입 처리 
	@PostMapping("write")
	public String write(MemberVO vo, RedirectAttributes rttr) throws Exception {
		service.write(vo);
		rttr.addFlashAttribute("msg", "회원가입이 되셨습니다. \\n로그인 후 이용해주세요.");
		return "redirect:/member/login";
	}
	
	//아이디 중복 체크
	@GetMapping("/idCheck")
	public String idCheck(String id, Model model) throws Exception {
		model.addAttribute("id", service.idCheck(id));
		
		return "member/idCheck";
	}
	

}
