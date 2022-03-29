package spring.board.paging;

public class Paging {

	private int pageNo=1; // 현재 페이지번호

	private int totalCount; // 전체데이터 수
	private int totalPage; // 전체 페이지수

	private int pagesize=10; // 1페이지에 보여질 게시글수
	private int rangesize=10; // 1블록에 보여질 페이지수

	private int startPage; // 블록시작 수
	private int endPage; // 블록끝번째 수
	
	private int nextNo; // 이전그룹의 다음페이지 
	private int prevNo; // 이전그룹의 첫번재

	private int offset; // LIMIT할위치

	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getRangesize() {
		return rangesize;
	}

	public void setRangesize(int rangesize) {
		this.rangesize = rangesize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getNextNo() {
		return nextNo;
	}

	public int getPrevNo() {
		return prevNo;
	}

	public Paging(int pageNo, int totalCount) {
		
		/**페이징 처리순서
		 * 1.총페이지수.
		 * 2.총블럭수
		 * 3.range Setting
		 */
		
		//현재페이지와 전체게시글수를 controller로부터 받아온다
		setPageNo(pageNo);
		setTotalCount(totalCount);
		
		this.totalPage=(int)Math.ceil((double)totalCount/(double)pagesize);
		this.startPage = ((pageNo - 1) / pagesize) * pagesize + 1;
		this.endPage = (startPage - 1) + pagesize;
		
		// 마지막페이지수가 전체페이지수보다 많을경우
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		this.nextNo = endPage+1;
		this.prevNo = startPage-1;
		
		
		this.offset = (pageNo -1) * pagesize; 
		
	
	}
	
}
