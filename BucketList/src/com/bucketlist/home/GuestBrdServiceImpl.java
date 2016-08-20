package com.bucketlist.home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class GuestBrdServiceImpl implements GuestBrdService{

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/*private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}*/

	public String randomString(){
		return "sowhat!!! random string";
	}

	@Override
	public List<GuestBrdVO> getUserList() {
		System.out.println("GuestBrdDAO_MyBatis - getUserList");
		SqlSession session = sqlSessionFactory.openSession();
		List<GuestBrdVO> getlist = null;
		try{
			System.out.println("------------------Mapper 정의하기 전");
			GuestBrdMapper mapper = session.getMapper(GuestBrdMapper.class);
			getlist = mapper.getUserList();
			// 옛날방식 : getlist = session.selectList("com.bucketlist.home.GuestBrdMapper.getUserList");
			System.out.println("------------------Mapper 정의한 후");
		}catch(Exception e){
			System.out.println("[DAO] 에러 : " + e.getMessage());
		}finally{
			session.close();
		}
		return getlist;
	}
}
