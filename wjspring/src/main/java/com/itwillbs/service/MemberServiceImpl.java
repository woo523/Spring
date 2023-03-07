package com.itwillbs.service;

import javax.inject.Inject;

import com.itwiilbs.dao.MemberDAO;
import com.itwiilbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// 부모 인터페이스 틀 상속
	
	// 멤버변수 부모 = 자식 객체 생성

	//	MemberDAO memberDAO = new MemberDAOImpl();
	private MemberDAO memberDAO;
	
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

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
		MemberDTO memberDTO2 = memberDAO.userCheck(memberDTO);
		return null;
	}

}
