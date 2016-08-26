package com.bucketlist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bucketlist.dto.MemberVO;
import com.bucketlist.service.MemberService;

public class MemberServiceImpl implements MemberService{

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public List<MemberVO> getMemberList() {
		System.out.println("MemberServiceImpl_MyBatis >>> getBoardList");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		
		List<MemberVO> getlist = null;
		try{
			System.out.println("------------------selectList하기 전");
			getlist = session.selectList("member.memberList");	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------selectList한 후");		
		}catch(Exception e){
			System.out.println("[MemberServiceImplImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}		
		return getlist;
	}
	@Override
	public void inserMember(MemberVO memVO) {
		System.out.println("MemberServiceImpl_MyBatis >>> insertUser");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		try{
			System.out.println("------------------Insert 하기 전");
			session.insert("member.memberInsert", memVO);	// session을 이용해 매퍼xml의 SQL을 사용
			System.out.println("------------------Insert 한 후");		
		}catch(Exception e){
			System.out.println("[MemberServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
	}
	@Override
	public MemberVO getMemberContent(String userid) {
		System.out.println("MemberServiceImpl_MyBatis >>> getBoardContent");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		MemberVO gbVO = null;
		try{
			System.out.println("------------------조회 하기 전");
			gbVO = session.selectOne("member.memberContent", userid);	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------조회 한 후");
		}catch(Exception e){
			System.out.println("[MemberServiceImplImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
		return gbVO;
	}
	@Override
	public void removeMember(String userid) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateMember(MemberVO memVO) {
		System.out.println("MemberServiceImpl_MyBatis >>> updateBoard");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		try{
			System.out.println("------------------update 하기 전");
			System.out.println("		update 성공? (성공 : 1, 실패 : 0인가 -1인가) -- " + session.update("member.memberUpdate", memVO));	// session을 이용해 매퍼xml의 SQL을 사용
			System.out.println("------------------update 한 후");		
		}catch(Exception e){
			System.out.println("[MemberServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
	}

}
