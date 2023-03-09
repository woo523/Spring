package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

// @Service 자동으로 자식클래스 찾도록 함

@Service 
public class MemberServiceImpl implements MemberService{
	// 부모 인터페이스 틀 상속
	
	// 멤버변수 부모 = 자식 객체 생성

	//	MemberDAO memberDAO = new MemberDAOImpl();
//	private MemberDAO memberDAO;
	
//	@Inject
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO 부모 = MemberDAOImpl 자식 객체생성
//		MemberDAO memberDAO = new MemberDAOImpl();
		// 메서드 호출
		memberDAO.insertMember(memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl userCheck()");
//		MemberDAO memberDAO = new MemberDAOImpl();
//		MemberDTO memberDTO2 = memberDAO.userCheck(memberDTO);
		return memberDAO.userCheck(memberDTO);
	}

}
