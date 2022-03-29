package spring.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.board.dto.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "spring.board.mappers.UserMapper";
	
	@Override
	public UserVO selectUser(String userid) throws Exception {
		
		return sqlSession.selectOne(Namespace+".selectUser", userid);
	}

	@Override
	public int insertUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+".insertUser", userVo);
	}

	
	@Override
	public int updateUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace+".updateUser", userVo);
	}
	
	@Override
	public int deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace+".deleteUser", id);
	}

	@Override
	public int checkID(String userid) throws Exception {
		
		
		return sqlSession.selectOne(Namespace+".checkID", userid);
	}

	

}
