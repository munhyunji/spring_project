package spring.board.Controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.board.dto.BoardVO;
import spring.board.dto.UserVO;
import spring.board.paging.Paging;
import spring.board.service.BoardService;
import spring.board.service.UserService;


@Controller
public class UserController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// service를 주입받아 데이터를 가져온다,,
	@Inject
	private UserService service;

	// 회원보기
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model,
			@ModelAttribute("UserVO") UserVO userVO,
			HttpServletRequest request) throws Exception {
	
		return "login";
	}
	

	@RequestMapping(value = "/login_ok.do", method = RequestMethod.POST)
	public String login_ok(Model model, HttpServletRequest request, 
			HttpServletResponse reponse,
			RedirectAttributes rttr,
			 @ModelAttribute("UserVO") UserVO userVO,
			@RequestParam(required=false, defaultValue="") String userid		
			
			) throws Exception {
	
		logger.debug("login");
		try {
			
		//로그인상태를 유지하기위한 session 설정..
		HttpSession session = request.getSession();
		userVO = service.selectUser(userid);
		
		if(userVO == null) {
			session.setAttribute("userVO", null);
			
		} else {
		//세션 저장
			session.setAttribute("userVO", userVO);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("userVO", userVO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	// 회원가입
			@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
			public void signupGET() throws Exception {
			
			}
			
	// 회원가입 파라미터 받아오기
		
		@RequestMapping(value = "/signup_ok.do", method = RequestMethod.POST)
		public String signup(Model model, 
				 @Valid @ModelAttribute("UserVO") UserVO userVO, 
				 BindingResult result, 
				 HttpServletRequest request) throws Exception { 

			if(result.hasErrors()) {
				for(ObjectError obj:result.getAllErrors()) {
				
					System.out.println("메시지:"+obj.getDefaultMessage());
					
				}
				return "signup"; // 다시입력하도록함 
			}
			
			service.insertUser(userVO);
			
			return "redirect:/";
		}
		
		// 회원정보 조회
		@RequestMapping(value = "/userinfo.do", method = RequestMethod.GET)
		public String userinfo(Model model,
				@ModelAttribute("UserVO") UserVO userVO, 
				HttpServletRequest request,
				String userid
				) throws Exception {
				

			try {
				userVO = service.selectUser(userid);
			} catch (Exception e) {
				// TODO: handle exception
			}
			model.addAttribute("userVO", userVO);
			
					return "userinfo";
				}
		
		// 회원정보 수정
		// update는 id값을 통해 상세정보 데이터를 불러오듯이 selectOne을하여 값을 가져오고 그값을 view페이지의 value값에
		// 넣어준다
		@RequestMapping(value = "/userupdate.do", method = RequestMethod.GET)
		public String update(Model model, RedirectAttributes rttr, @RequestParam(value = "userid") String userid) throws Exception {

			logger.info("update");

			model.addAttribute("board", service.selectUser(userid));

			return "userupdate";
		}

		
		@RequestMapping(value = "/userupdate_ok.do", method = RequestMethod.POST)
		public String userupdate(Model model,
				@ModelAttribute("UserVO") UserVO userVO, 
				HttpServletRequest request,
				
				@RequestParam(value="userid") String userid,
				@RequestParam(value="userpassword") String userpassword ) throws Exception {
				

			try {
				userVO = service.selectUser(userid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("userVO", userVO);
			
					return "userinfo";
				}
		
		
		//유저삭제
		// 삭제하기
		@RequestMapping(value = "/userdelete.do", method = RequestMethod.GET)
		public String delete(Model model, BoardVO board, HttpSession session, @RequestParam(value = "id") int id) throws Exception {

			model.addAttribute("userVO", service.deleteUser(id));
			session.invalidate();
			return "redirect:/";
		}
		
		//ID중복여부 체크
		@ResponseBody // ajax에서 보낸 데이터값을 받는 몸?데이터 
		@RequestMapping(value = "checkID.do", method = {RequestMethod.GET, RequestMethod.POST})
		public Map<Object, Object> checkID(String userid) throws Exception {

			
			System.out.println(userid);
			
			int count= 0; // db에 접근해서 입력한정보 userVO가 있는지 확인한다 
			Map<Object, Object> map = new HashMap<>();
			
			count = service.checkID(userid); //
			map.put("count", count);
			
			return map;
		}

}
