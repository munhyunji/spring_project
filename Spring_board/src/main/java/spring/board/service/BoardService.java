package spring.board.service;

import java.util.List;

import spring.board.dto.BoardVO;

public interface BoardService {

	public int selectAll(String keyword, String search_option) throws Exception; // 전체글수 카운트
	
	public List<BoardVO> selectListItem(BoardVO board, String keyword) throws Exception; //목록 보기	
	
	public int insert(BoardVO board) throws Exception; //추가하기
	public BoardVO selectOne(int id) throws Exception; // 상세보기
	public int update(BoardVO board) throws Exception; // 수정하기
	public int delete(int id) throws Exception; // 삭제하기

	public int updateviewCount(int id); //조회수 올리기
	
	
}
