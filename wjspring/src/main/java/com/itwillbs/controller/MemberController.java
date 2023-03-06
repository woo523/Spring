package com.itwillbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	// 주의 : 파일이 달라도 같은 @Controller에 있는 가상주소 모두 다르게 부여
	
	// 가상주소 http://localhost:8080/myweb/member/insert
	// 주소매핑 -> member/insertForm.jsp
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// 처리작업
		
		
		// 가상주소에서 주소변경 없이 이동(member/insertForm.jsp) -> 		
		// RequestDispatcher dispatcher =
		//		request.getRequestDispatcher(forward.getPath());
		//		dispatcher.forward(request, response);
		
		return "member/insertForm";
		
		// 가상주소에서 주소 변경하면서 이동(가상주소 /member/login)
		// response.sendRedirect(forward.getPath());
		// return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		
		return "member/main";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		
		return "member/info";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		
		return "member/updateForm";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		
		return "member/deleteForm";
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		
		return "member/list";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro() {
		System.out.println("MemberController insertPro()");
		// 처리작업
				
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("MemberController loginPro()");
		// 처리작업
				
		return "redirect:/member/main";
	}
	
	
}
