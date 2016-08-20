package com.bucketlist.home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bucketlist.dto.GuestBrdVO;

public class GuestBrdServiceImpl implements GuestBrdService{

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<GuestBrdVO> getBoardList() {
		System.out.println("GuestBrdService_MyBatis >>> getUserList");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		
		List<GuestBrdVO> getlist = null;
		try{
			System.out.println("------------------Mapper 정의하기 전");
			getlist = session.selectList("guestboard.boardList");	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------Mapper 정의한 후");		
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}		
		return getlist;
	}

	@Override
	public void insertUser(GuestBrdVO gbVO) {
		System.out.println("GuestBrdService_MyBatis >>> insertUser");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		try{
			System.out.println("------------------Insert 하기 전");
			session.insert("guestboard.boardInsert", gbVO);	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------Insert 한 후");		
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
	}

	@Override
	public GuestBrdVO getBoardContent(Integer brdno) {
		System.out.println("GuestBrdService_MyBatis >>> getBoardContent");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		GuestBrdVO gbVO = null;
		try{
			System.out.println("------------------조회 하기 전");
			gbVO = session.selectOne("guestboard.boardContent", brdno);	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------조회 한 후");		
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
		return gbVO;
	}
}
