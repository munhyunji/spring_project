package spring.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.board.dao.BoardDAO;
import spring.board.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	

	@Override
	public List<BoardVO> selectListItem(BoardVO board, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectListItem(board, keyword);
	}


	@Override
	public int selectAll(String keyword, String search_option) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll(keyword, search_option);
	}


	@Override
	public BoardVO selectOne(int id) throws Exception {
		return dao.selectOne(id);
	}


	@Override
	public int insert(BoardVO board) throws Exception {
		return dao.insert(board);
	}


	@Override
	public int update(BoardVO board) throws Exception {
		
		return dao.update(board);
	}


	@Override
	public int delete(int id) throws Exception {
		
		return dao.delete(id);
	}


	@Override
	public int updateviewCount(int id) {
		
		return dao.updateviewCount(id);
	}


}
