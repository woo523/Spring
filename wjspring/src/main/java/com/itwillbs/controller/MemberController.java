package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// 멤버변수 부모 = 자식 객체생성
//	MemberService memberService = new MemberServiceImpl();
	
	// 스프링 3버전 자동으로 객체생성
	// 멤버변수 부모 공통적인 틀 선언 => 데이터 은닉
	// 스프링파일 root-context.xml 객체생성
	// MemberController 파일에 멤버변수 memberService 전달
	
	//	private MemberService memberService;
	
	// 멤버변수 값을 전달 생성자, set메서드 통해서 전달
	// 생성자
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}
	// set 메서드
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	// 스프링 4버전 자동으로 객체생성
	// 멤버변수 부모 공통적인 틀 선언 => 데이터 은닉
	// 부모를 상속받은 자식 클래스 자동으로 찾아옴
	// 데이터 은닉된 부모 인터페이스 멤버변수에 xml에서 객체생성해서
	// set메서드 통해서 전달
	@Inject 
	private MemberService memberService;
	
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
	public String info(HttpSession session, Model model) {
		System.out.println("MemberController info()");
		String id=(String)session.getAttribute("id");
		MemberDTO memberDTO = memberService.getMember(id);
		
		// memberDTO를 들고 member/info.jsp로 이동
		// request.setAttribute("memberDTO",memberDTO);
		// request 대신에 스프링 제공 Model 담아서 이동
		model.addAttribute("memberDTO", memberDTO);
		
		return "member/info";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		System.out.println("MemberController update()");
		String id=(String)session.getAttribute("id");
		MemberDTO memberDTO = memberService.getMember(id);

		model.addAttribute("memberDTO", memberDTO);
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
//		MemberService memberService = new MemberServiceImpl();
		// 메서드 호출
		memberService.insertMember(memberDTO);
		
		// 로그인 페이지로 이동
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		// 처리 작업
		// 디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		
		// MemberLoginPro.java execute() 대신
		// MemberService 부모 = MemberServiceImpl 자식 객체생성
//		MemberService memberService = new MemberServiceImpl();
		// 리턴할형 MemberDTO userCheck() 메서드 정의
		// MemberDTO memberDTO2 = userCheck(id, pass) 메서드 호출
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			System.out.println("아이디 비밀번호 일치");
			// 회원이 일치하다라는 표시 
			// => 페이지 상관없이 값이 계속 유지가 되도록 설정
			// => 세션의 특징을 이용해서 => 세션 기억장소 안에 유지할 값 저장해놓고 어디서나 사용가능
			// 세션객체 받아와서 세션 사용
			session.setAttribute("id", memberDTO.getId());
			return "redirect:/member/main";
		}else {
			//아이디 비밀번호 틀림
			System.out.println("아이디 비밀번호 틀림");
			return "member/msg";
		}
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("MemberController logout()");
		session.invalidate();
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		// 디비 수정 처리 => 처리 => 디비 자바 메서드 호출
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			System.out.println("아이디 비밀번호 일치");
			// 수정작업
			memberService.updateMember(memberDTO);
			return "redirect:/member/main";
		}else {
			//아이디 비밀번호 틀림
			System.out.println("아이디 비밀번호 틀림");
			return "member/msg";
		}
		
	}
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController deletePro()");
		// 디비 삭제 처리 => 처리 => 디비 자바 메서드 호출
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			System.out.println("아이디 비밀번호 일치");
			// 삭제작업
			memberService.deleteMember(memberDTO);
			session.invalidate();
			return "redirect:/member/main";
		}else {
			//아이디 비밀번호 틀림
			System.out.println("아이디 비밀번호 틀림");
			return "member/msg";
		}

	}
	
	
}
