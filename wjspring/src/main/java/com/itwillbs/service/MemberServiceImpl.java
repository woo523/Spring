package com.itwillbs.service;

import com.itwiilbs.dao.MemberDAO;
import com.itwiilbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO 부모 = MemberDAOImpl 자식 객체생성
		MemberDAO memberDAO = new MemberDAOImpl();
		// 메서드 호출
		memberDAO.insertMember(memberDTO);
	}

}
