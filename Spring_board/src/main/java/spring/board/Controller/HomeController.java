package spring.board.Controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.board.dto.BoardVO;
import spring.board.paging.Paging;
import spring.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// service를 주입받아 데이터를 가져온다,,
	@Inject
	private BoardService service;

	// 목록보기
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,
			@ModelAttribute("boardVO") BoardVO boardVO, HttpServletRequest request,
			@RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(required=false, value="search_option", defaultValue="all") String search_option,
			@RequestParam(required=false, value="keyword", defaultValue="") String keyword
			) throws Exception {

		int totalCount = service.selectAll(keyword, search_option);// 전체게시글수

		logger.info("home");
		

		Paging paging = new Paging(pageNo, totalCount);
		
		boardVO.setOffset(paging.getOffset()); //limit절에 들어갈 값
		boardVO.setPagesize(paging.getPagesize()); //limit절에 들어갈 1페이지당 글수 값
		boardVO.setKeyword(keyword); //키워드값
		boardVO.setSearch_option(search_option); //선택목록값
		
		List<BoardVO> board = service.selectListItem(boardVO, keyword);
		
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("board", board);
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		model.addAttribute("search_option", search_option);

		return "/home";
	}


	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	public String view(Model model, @RequestParam(value = "id") int id) throws Exception {

		logger.info("selectOne");
		
		model.addAttribute("output", service.selectOne(id));
		model.addAttribute("viewcount", service.updateviewCount(id));

		return "view";
	}

	@RequestMapping(value = "/add.do", method = { RequestMethod.GET })
	public String add(BoardVO board, RedirectAttributes rttr) throws Exception {
		return "add";
	}

	@RequestMapping(value = "/add_ok.do", method = RequestMethod.POST)
	public String add_ok(Model model,BoardVO board, RedirectAttributes rttr,
			
			@RequestParam(value = "userid") String userid,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "postpw", defaultValue="", required=false)int postpw,
			@RequestParam(value = "lockpost", defaultValue="0",required=false)int lockpost) throws Exception {

		model.addAttribute("board", service.insert(board));
		
		return "redirect:/";
	}

	// update는 id값을 통해 상세정보 데이터를 불러오듯이 selectOne을하여 값을 가져오고 그값을 view페이지의 value값에
	// 넣어준다
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(Model model, RedirectAttributes rttr, @RequestParam(value = "id") int id) throws Exception {

		logger.info("update");

		model.addAttribute("board", service.selectOne(id));

		return "update";
	}

	// view에서 수정 버턴을 누르면 파라미터를 받아서 수정한뒤 저장됨
	@RequestMapping(value = "/update_ok.do", method = RequestMethod.POST)
	public String update_ok(Model model, BoardVO board, RedirectAttributes rttr,
			@RequestParam(value = "id") int id,
			@RequestParam(value = "userid") String userid,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "postpw", required=false)int postpw,
			@RequestParam(value = "lockpost", required=false)String lockpost)
			throws Exception {

		model.addAttribute("board", service.update(board));
		return "redirect:/";
	}

	// 삭제하기
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(Model model, BoardVO board, @RequestParam(value = "id") int id) throws Exception {

		model.addAttribute("board", service.delete(id));
		return "redirect:/";
	}

}
