package spring.board.service;

import spring.board.dto.UserVO;

public interface UserService {
	
	public UserVO selectUser(String userid) throws Exception;
	public int insertUser (UserVO userVo) throws Exception;
	public int deleteUser (int id) throws Exception;
	public int updateUser (UserVO userVo) throws Exception;
	public int checkID(String userid) throws Exception;
}
