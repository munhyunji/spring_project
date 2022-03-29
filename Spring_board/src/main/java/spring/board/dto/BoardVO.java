package spring.board.dto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BoardVO {

	private int id;
	private String title;
	private String content;
	private String userid;
	private int viewcount;
	private int postpw;
	private int lockpost;
	
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public int getPostpw() {
		return postpw;
	}
	public void setPostpw(int postpw) {
		this.postpw = postpw;
	}
	public int getLockpost() {
		return lockpost;
	}
	public void setLockpost(int lockpost) {
		this.lockpost = lockpost;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//페이징에필요한 변수 LIMIT 추가 
	private  int offset;
	private  int pagesize;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	//검색어 설정 변수 
	private String keyword;
	private String search_option;

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearch_option() {
		return search_option;
	}
	public void setSearch_option(String search_option) {
		this.search_option = search_option;
	}
	
	
}
