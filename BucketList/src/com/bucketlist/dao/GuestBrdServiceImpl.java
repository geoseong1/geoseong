package com.bucketlist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bucketlist.dto.GuestBrdVO;
import com.bucketlist.service.GuestBrdService;

public class GuestBrdServiceImpl implements GuestBrdService{

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<GuestBrdVO> getBoardList() {
		System.out.println("GuestBrdService_MyBatis >>> getBoardList");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		
		List<GuestBrdVO> getlist = null;
		try{
			System.out.println("------------------selectList하기 전");
			getlist = session.selectList("guestboard.boardList");	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------selectList한 후");		
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}		
		return getlist;
	}

	@Override
	public void inserBoard(GuestBrdVO gbVO) {
		System.out.println("GuestBrdService_MyBatis >>> insertUser");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		try{
			System.out.println("------------------Insert 하기 전");
			session.insert("guestboard.boardInsert", gbVO);	// session을 이용해 매퍼xml의 SQL을 사용
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
			session.update("guestboard.boardcntplus1", brdno);	// 조회수 +1 업뎃
			gbVO = session.selectOne("guestboard.boardContent", brdno);	// session을 이용해 매퍼xml의 SQL을 사용하여 결과를 받아낸다.
			System.out.println("------------------조회 한 후");
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
		return gbVO;
	}

	@Override
	public void removeBoard(Integer brdno) {
		System.out.println("GuestBrdService_MyBatis >>> removeBoard");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		try{
			System.out.println("------------------remove 하기 전");
			System.out.println("		remove 하려는 게시번호 : " + session.delete("guestboard.boardDelete", brdno));	// session을 이용해 매퍼xml의 SQL을 사용
			System.out.println("------------------remove 한 후");		
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
	}

	@Override
	public void updateBoard(GuestBrdVO gbVO) {
		System.out.println("GuestBrdService_MyBatis >>> updateBoard");
		SqlSession session = sqlSessionFactory.openSession();	// sqlSessionFactory를 이용해 Session을 연다.
		try{
			System.out.println("------------------update 하기 전");
			System.out.println("		update 하려는 게시번호 : " + session.update("guestboard.boardUpdate", gbVO));	// session을 이용해 매퍼xml의 SQL을 사용
			System.out.println("------------------update 한 후");		
		}catch(Exception e){
			System.out.println("[GuestBrdServiceImpl] 에러 : \n" + e.getMessage());
		}finally{
			session.close();
		}
	}
}
