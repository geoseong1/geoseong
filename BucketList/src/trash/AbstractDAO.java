package trash;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		System.out.println("AbstractDAO " + queryId);
		return sqlSession.selectList(queryId);
	}
	
}
