package spring.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.board.dto.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	// sqlSessionTemplate를 주입시킨다
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "spring.board.mappers.BoardMapper";
	
	//DAO에서 정의했던 목록가져오기 - mapper에서 설정했던 쿼리문을 실행한다 -> 목록으로 가져오므로 List로 받아서 리턴한다
	@Override
	public List<BoardVO> selectListItem(BoardVO board, String keyword) throws Exception {
		
		
		return sqlSession.selectList(Namespace+".selectItem", board );
	}
	
	//전체 글수 카운트
	@Override
	public int selectAll(String keyword, String search_option) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("keyword", keyword);
		data.put("search_option", search_option);
		
		
		return sqlSession.selectOne(Namespace+".selectAll", data);
	}

	//상세보기
	@Override
	public BoardVO selectOne(int id) throws Exception {
		
		return sqlSession.selectOne(Namespace+".selectOne", id);
	}
	
	//추가하기
	@Override
	public int insert(BoardVO board) throws Exception {
		
		return sqlSession.insert(Namespace+".insert", board);
	}
	//수정하기
	@Override
	public int update(BoardVO board) throws Exception {
		
		return sqlSession.update(Namespace+".update", board);
	}
	//지우기
	@Override
	public int delete(int id) throws Exception {
		
		return sqlSession.delete(Namespace+".delete", id);
	}

	@Override
	public int updateviewCount(int id) {
		
		return sqlSession.update(Namespace+".updateviewCount", id);
	}

}
