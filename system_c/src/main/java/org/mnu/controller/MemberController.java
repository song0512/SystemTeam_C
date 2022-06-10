package org.mnu.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mnu.domain.BoardVO;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

/**
 * @brief 회원가입 및 로그인 주소 처리 
 * @details 회원가입 및 로그인 url 요청 처리 
 * @author Team.C
 * @date 2022/06/01
 * @version 0.0.1
 * */

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
	//로그인 폼
	/** 
	 * @brief 로그인 페이지
	 * @details 로그인을 할 수 있는 페이지를 보여줌  
	 * */
	@GetMapping("/login")
	public String loginForm() throws Exception {
		log.info("loginForm--");
		return "member/login";
	}
	
	//로그인 - id, pw 입력해서 보냄 -> 받음
	/** 
	 * @brief 로그인 처리 페이지
	 * @details 로그인 작성 후 DB와 일치하는 아이디와 비밀번호를 찾는다.
	 * */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO invo, HttpServletRequest request,HttpServletResponse response, RedirectAttributes rttr) throws Exception {
		log.info("login 처리 ="+ invo);
		
		HttpSession session = request.getSession();
		LoginVO vo = service.login(invo);

		if(vo == null) {
			rttr.addFlashAttribute("msg", "아이디 또는 비밀번호를 잘못 입력했습니다. \\n입력하신 내용을 다시 확인해주세요.");
			return "redirect:/member/login";
			
		}
		rttr.addFlashAttribute("msg", "로그인이 완료되었습니다. \\n환영합니다.");
		
		session.setAttribute("login", vo);
		return "redirect:/image/list";
		
	}

	//로그아웃 처리 - session 지움
	/** 
	 * @brief 로그아웃 처리 페이지
	 * @details 로그아웃 처리 페이지
	 * */
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response, RedirectAttributes rttr) throws Exception {
		session.removeAttribute("login");
		rttr.addFlashAttribute("msg", "회원탈퇴가 되셨습니다.");
		return "redirect:/image/list";
	}
	
	//회원리스트 - 관리자만 가능 
	/** 
	 * @brief 회원 리스트 페이지 - 관리자만 허용 
	 * @details 관리자만 볼 수 있는 회원 리스트 페이지
	 * */
	@GetMapping("/list")
	public String list(@ModelAttribute PageObject pageObject, Model model) throws Exception{
		
		model.addAttribute("list", service.list(pageObject));
		return "member/list";
	}
	
	//회원 정보, 내 정보 확인 
	/** 
	 * @brief 마이페이지 
	 * @details 자신의 정보를 확인할 수 있는 페이지
	 * */
	@GetMapping("/view")
	public String view(String id, String name,Model model, HttpSession session) throws Exception{
		if(id == null) {
			model.addAttribute("title", "내 정보");
			id = ((LoginVO) session.getAttribute("login")).getId();
		} else {
			model.addAttribute("title", "회원 정보");
		}
		model.addAttribute("vo", service.view(id));
		return "member/view";
	}
	
	//회원가입 폼
	/** 
	 * @brief 회원가입 작성 페이지
	 * @details 회원가입을 할 수 있는 페이지를 보여줌
	 * */
	@GetMapping("/write")
	public String writeForm() throws Exception {
		return "member/write";
	}
	
	//회원가입 처리 
	/** 
	 * @brief 회원가입 작성 처리 페이지
	 * @details 아이디, 닉네임, 비밀번호를 작성하여 DB에 반영
	 * */
	@PostMapping("write")
	public String write(MemberVO vo, RedirectAttributes rttr) throws Exception {
		service.write(vo);
		rttr.addFlashAttribute("msg", "회원가입이 되셨습니다. \\n로그인 후 이용해주세요.");
		return "redirect:/member/login";
	}
	
	//아이디 중복 체크
	/** 
	 * @brief 아이디 중복 체크 
	 * @details 작성한 아이디와 일치하는 아이디가 있는지 DB에서 확인
	 * */
	@GetMapping("/idCheck")
	public String idCheck(String id, Model model) throws Exception {
		model.addAttribute("id", service.idCheck(id));
		
		return "member/idCheck";
	}
	
	//updateForm
	/** 
	 * @brief 회원정보 수정 페이지
	 * @details 회원 정보를 수정할 수 있는 페이지를 보여줌 
	 * */
	@GetMapping("/update")
	public String updateForm(String id,  String name,MemberVO vo,Model model, HttpSession session) throws Exception {
		id = ((LoginVO) session.getAttribute("login")).getId();
		System.out.println("BoardController.update().vo = "+id);
		
		model.addAttribute("vo", service.view(id));
			
		return "member/update";
	}
	
	//update
	/** 
	 * @brief 회원정보 수정 처리 페이지
	 * @details 회원정보를 수정해서 db에 반영
	 * */
	@PostMapping("/update")
	public String update(HttpSession session, String id, MemberVO vo, RedirectAttributes rttr) throws Exception {
		service.update(vo);
		
		rttr.addFlashAttribute("msg", "회원정보가 수정되었습니다.");
			
		return "redirect:/member/view";
	}
		
	
	@GetMapping("/delete")
	public String delete(String id, RedirectAttributes rttr, HttpSession session) throws Exception {
		id = ((LoginVO) session.getAttribute("login")).getId();
		service.delete(id);
		
		rttr.addFlashAttribute("msg", "회원탈퇴가 되었습니다.");
		
		return "redirect:/member/logout";
		
	
	}
	
}
