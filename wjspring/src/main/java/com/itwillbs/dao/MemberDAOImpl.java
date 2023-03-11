package com.itwillbs.dao;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

//@Inject
//private MemberDAO memberDAO;
// => 자동으로 @Repository 정의된 자식클래스 찾아가서 객체생성

@Repository
public class MemberDAOImpl implements MemberDAO{

	// 마이바티스 디비연결 객체생성	
	// 은닉 멤버 변수
	// @Inject => root-context.xml 파일 객체 생성된 "sqlSession" 찾아서 자동으로 가져옴
	@Inject // context.xml 자동으로 찾아감
	private SqlSession sqlSession;
		
	
	// 디비연결 객체생성
	// 은닉 멤버 변수
//	private DataSource dataSource;
//	private SimpleJdbcTemplate template;
	
	// set 메서드
//	@Inject
//	public void setDataSource(DataSource dataSource) {
////		this.dataSource = dataSource;
//		template= new SimpleJdbcTemplate(dataSource);
//	}
//	
	private static final String namespace = "com.itwillbs.mappers.memberMapper";
//	String sql = "insert into members(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberDTO memberDTO) {
		// 디비작업
		System.out.println("MemberDAOImpl insertMember()");

		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		// src/main.resources 폴더 mappers 파일 memberMapper.xml
		// namespace="com.itwillbs.mappers.memberMapper" 이름으로 불러서 사용
		// MyBatis sql구문 호출해서 사용
//		sqlSession.insert(sql구문이름, ?표에 입력될 값 memberDTO);
		sqlSession.insert(namespace+".insertMember", memberDTO);
			
		
//		template.update(sql값, 입력될값);
//		template.update(sql, memberDTO.getId(),memberDTO.getPass(),memberDTO.getName(),memberDTO.getDate());
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl userCheck()");
		
		// selectOne 리턴값이 MemberDTO 하나일때 사용
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberDAOImpl getMember()");
		
		// selectOne 리턴값이 MemberDTO 하나일때 사용
		return sqlSession.selectOne(namespace+".getMember", id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl updateMember()");
		sqlSession.update(namespace+".updateMember",memberDTO);
	}


	@Override
	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl updateMember()");
		sqlSession.update(namespace+".deleteMember",memberDTO);
	}


		
	}



