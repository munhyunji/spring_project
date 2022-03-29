package spring.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.board.dao.UserDAO;
import spring.board.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO selectUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectUser(userid);
	}

	@Override
	public int insertUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertUser(userVo);
	}

	@Override
	public int deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}

	@Override
	public int updateUser(UserVO userVo) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateUser(userVo);
	}

	@Override
	public int checkID(String userid) throws Exception {

		
		return dao.checkID(userid);
	}

}
