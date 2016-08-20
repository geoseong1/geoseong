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
	
	@RequestMapping(value="/guestcenter.do", method=RequestMethod.GET)
	public String guestcenter(Model model){
		System.out.println("guestcenter/guest_main");
		
		//System.out.println("get String from mapper : " + dao.randomString());
		try{
			System.out.println("------------------------------------dao에서 자료 빼오기 전");
			List<GuestBrdVO> list = guestDao.getBoardList();
			System.out.println("------------------------------------dao에서 자료 빼온 후");
			System.out.println("	getBrduserid : " + list.get(0).getBrduserid());
			System.out.println("	getBrdsubject : " + list.get(0).getBrdsubject());
			System.out.println("	getBrdcontext : " + list.get(0).getBrdcontext());
			System.out.println("	getBrdfilepath : " + list.get(0).getBrdfilepath());
			System.out.println("	getBrdcount : " + list.get(0).getBrdcount());
			System.out.println("	getBrdadddate : " + list.get(0).getBrdadddate());

			model.addAttribute("guestbrd", list);
		}catch(Exception e){
			System.out.println("[Controller/Mainmenu] 에러 : " + e.getMessage());
			
		}
			return "guestcenter/guest_main";
		/*try {
			List<GuestBrdVO> list = new ArrayList<GuestBrdVO>();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date to;
			to = transFormat.parse("2016-08-19");
			GuestBrdVO guestvo = new GuestBrdVO(3, "geoseong", "안뇽", "방가워", "none", "0", to);
			list.add(guestvo);
			model.addAttribute("guestbrd", list);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Date parsing error from Controller");
			e.printStackTrace();
		}*/
		
		
	} //end guestcenter list mainmenu 
	
	@RequestMapping(value="/guestinsert.do", method=RequestMethod.GET)
	public String guestinsert_get(Model model){
		System.out.println("guestinsert_get");		
		return "guestcenter/guest_insert";
	} //end guestinsert_get

	@RequestMapping(value="/guestinsert.do", method=RequestMethod.POST)
	public String guestinsert_post(Model model, GuestBrdVO gbVO){
		System.out.println("guestinsert_post");	
		guestDao.insertUser(gbVO);
		System.out.println("guestinsert_post getBrduserid : " + gbVO.getBrduserid());
		System.out.println("guestinsert_post getBrdsubject : " + gbVO.getBrdsubject());
		System.out.println("guestinsert_post getBrdcontext : " + gbVO.getBrdcontext());
		System.out.println("guestinsert_post getBrdfilepath : " + gbVO.getBrdfilepath());
		System.out.println("and\nguestinsert_post getBrdcount: " + gbVO.getBrdcount());
		System.out.println("guestinsert_post getBrdadddate: " + gbVO.getBrdadddate());
		System.out.println("guestinsert_post getBrdno: " + gbVO.getBrdno());
		return guestcenter(model);
	} //end guestinsert_post
	
	@RequestMapping(value="/guestcontent.do", method=RequestMethod.GET)
	public String guestcontent_get(Model model, HttpServletRequest request){
		System.out.println("guestinsert_get brdno ? " + request.getParameter("brdno"));
		
		model.addAttribute("guestbrd", guestDao.getBoardContent(Integer.parseInt(request.getParameter("brdno"))));
		return "guestcenter/guest_content";
	} //end guestcontent_get
	
	/** 테스트 영역 **/
	@RequestMapping(value="/test.do")
	public String index_AOP(Model model){
		System.out.println("test.1");
		int daonum = vo.selectCode();
		System.out.println("Ctrller DAO : " + daonum);
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		model.addAttribute("testfor", vo.selectAll());
		return "test";
	}
	
	@RequestMapping(value="/test.admin")
	public String index_nonAOP(Model model){
		System.out.println("test.2");
		int daonum = vo.selectCode();
		System.out.println("test2 Ctrller DAO : " + daonum);
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		model.addAttribute("testfor", vo.selectAll());
		return "test";
	}
	/** 테스트 영역 **/
/* End : 메소드 영역 */
} //end class
