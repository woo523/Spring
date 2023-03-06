package com.itwillbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
	// 주의 : 파일이 달라도 같은 @Controller에 있는 가상주소 모두 다르게 부여
	
	// 서블릿이 동작하기 전에 서버에서 request, response 서버 내장객체 생성 => 서버 기억장소 할당
    // request 기억장소 안에 사용자가 입력한 파라미터 정보(태그 입력한 정보), 서버 정보, 클라이언트 정보, 세션 정보, 쿠키 정보 저장
	
	
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
	public String insertPro(MemberDTO memberDTO) {
		// HttpServletRequest request
		// 사용자가 입력한 내용 => request에 저장 => request 가져오기
		System.out.println("MemberController insertPro()");
		// post 방식 한글 깨지고 request.setCharacterEncoding("UTF-8")
		// web.xml에서 한글설정을 한번만 하고 모든 곳에 한글처리가 됨.
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pass"));
//		System.out.println(request.getParameter("name"));
		// 패키지 com.itwillbs.domain MemberDTO에 저장
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setPass(request.getParameter("pass"));
//		memberDTO.setName(request.getParameter("name"));

		// 스프링 insertForm.jsp id, pass, name 태그이름 입력된 값이 서버에 전달되면
		// request에 저장 => MemberDTO 객체 생성 => 멤버변수 id, pass, name 이름이 동일하면
		// 자동으로 setId() 메서드 호출되어지고 request.getParameter("id")를 동작해서 값 저장
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		// MemberFrontController 주소매핑 호출 
		// => MemberInsertPro.java execute() 호출 -> MemberDAO insertMember()		
		// 자바 파일 메서드 호출 회원가입 처리 => MemberService 처리 => MemberDAO 디비
		// 주소매핑 MemberController
		// -> 처리 패키지 com.itwillbs.service
		// -> 처리 MemberService 인터페이스 MemberServiceImpl 클래스 insertMember()
		// -> 디비 패키지 com.itwillbs.dao
		// -> 디비 MemberDAO 인터페이스 MemberDAOImpl 클래스 insertMember()
		
		// MemberService 부모 = MemberServiceImpl 자식 객체생성
		MemberService memberService = new MemberServiceImpl();
		// 메서드 호출
		memberService.insertMember(memberDTO);
		
		// 로그인 페이지로 이동
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO) {
		System.out.println("MemberController loginPro()");
		// 처리 작업
		// 디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout() {
		System.out.println("MemberController logout()");

		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro() {
		System.out.println("MemberController updatePro()");
		// 디비 수정 처리 => 처리 => 디비 자바 메서드 호출
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro() {
		System.out.println("MemberController deletePro()");
		// 디비 삭제 처리 => 처리 => 디비 자바 메서드 호출
		return "redirect:/member/main";
	}
	
	
}
