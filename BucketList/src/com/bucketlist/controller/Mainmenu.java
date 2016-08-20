package com.bucketlist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bucketlist.dto.GuestBrdVO;
import com.bucketlist.home.GuestBrdServiceImpl;
import com.bucketlist.home.VO;

@Controller
public class Mainmenu {

/* Start : 변수 영역 */
	private VO vo;
	public void setVo(VO vo) {
		this.vo = vo;
	}
	
	private GuestBrdServiceImpl guestDao;
	public void setGuestDao(GuestBrdServiceImpl guestDao) {
		this.guestDao = guestDao;
	}
/* End : 변수 영역 */
	
/* Start : 메소드 영역 */
	@RequestMapping(value="/default.do", method=RequestMethod.GET)
	public String tiles(Model model){
		System.out.println("tiles");
		return "default";
	}
	
	// 메인 : 리스트 보기
	@RequestMapping(value="/guestcenter.do", method=RequestMethod.GET)
	public String guestcenter(Model model){
		System.out.println("guestcenter/guest_main");
		
		//System.out.println("get String from mapper : " + dao.randomString());
		try{
			System.out.println("\n------------------------------------dao에서 자료 빼오기 전");
			List<GuestBrdVO> list = guestDao.getBoardList();
			System.out.println("------------------------------------dao에서 자료 빼온 후\n");
			model.addAttribute("guestbrd", list);
		}catch(Exception e){
			System.out.println("[Controller/Mainmenu] 에러 : " + e.getMessage());
		}
		return "guestcenter/guest_main";
	} //end guestcenter list mainmenu 
	
	// 글쓰기 화면
	@RequestMapping(value="/guestinsert.do", method=RequestMethod.GET)
	public String guestinsert_get(Model model){
		System.out.println("guestinsert_get");		
		return "guestcenter/guest_insert";
	} //end guestinsert_get

	// 글쓰기 버튼 눌렀을때 DAO이용
	@RequestMapping(value="/guestinsert.do", method=RequestMethod.POST)
	public String guestinsert_post(Model model, GuestBrdVO gbVO){
		System.out.println("guestinsert_post");	
		guestDao.inserBoard(gbVO);
			System.out.println("guestinsert_post getBrduserid : " + gbVO.getBrduserid());
			System.out.println("guestinsert_post getBrdsubject : " + gbVO.getBrdsubject());
			System.out.println("guestinsert_post getBrdcontext : " + gbVO.getBrdcontext());
			System.out.println("guestinsert_post getBrdfilepath : " + gbVO.getBrdfilepath());
			System.out.println("and\nguestinsert_post getBrdcount: " + gbVO.getBrdcount());
			System.out.println("guestinsert_post getBrdadddate: " + gbVO.getBrdadddate());
			System.out.println("guestinsert_post getBrdno: " + gbVO.getBrdno());
		return guestcenter(model);
	} //end guestinsert_post
	
	// 게시글 내용 들어가서 보기
	@RequestMapping(value="/guestcontent.do", method=RequestMethod.GET)
	public String guestcontent_get(Model model, HttpServletRequest request){
		System.out.println("guestinsert_get brdno? -- " + request.getParameter("brdno"));
		
		model.addAttribute("guestbrd", guestDao.getBoardContent(Integer.parseInt(request.getParameter("brdno"))));
		return "guestcenter/guest_content";
	} //end guestcontent_get
	
	// 선택된 게시글 제거하기
	@RequestMapping(value="/guestdelete.do", method=RequestMethod.POST)
	public String guestdelete_get(Model model, HttpServletRequest request){
		System.out.println("guestdelete_get brdno ? " + request.getParameter("brdno"));
		guestDao.removeBoard(Integer.parseInt(request.getParameter("brdno")));
		return guestcenter(model);
	} //end guestdelete_get
	
	/** 테스트 영역 **/
	@RequestMapping(value="/test.do")
	public String index_AOP(Model model){
		System.out.println("test.1");
		int daonum = vo.selectCode();
		System.out.println("Ctrller DAO : " + daonum);
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		model.addAttribute("testfor", vo.selectAll());
		return "test";
	} //end test.do
	
	@RequestMapping(value="/test.admin")
	public String index_nonAOP(Model model){
		System.out.println("test.2");
		int daonum = vo.selectCode();
		System.out.println("test2 Ctrller DAO : " + daonum);
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		model.addAttribute("testfor", vo.selectAll());
		return "test";
	} //end test.admin
	/** 테스트 영역 **/
/* End : 메소드 영역 */
} //end class
