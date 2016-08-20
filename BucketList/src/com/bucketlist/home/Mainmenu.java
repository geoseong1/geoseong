package com.bucketlist.home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Mainmenu {

	private VO vo;
	public void setVo(VO vo) {
		this.vo = vo;
	}
	
	private GuestBrdServiceImpl guestDao;
	public void setGuestDao(GuestBrdServiceImpl guestDao) {
		this.guestDao = guestDao;
	}

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
			List<GuestBrdVO> list = guestDao.getUserList();
			System.out.println("------------------------------------dao에서 자료 빼온 후");
			System.out.println("getBrduserid : " + list.get(0).getBrduserid());
			System.out.println("getBrdcontext : " + list.get(0).getBrdcontext());
		}catch(Exception e){
			System.out.println("[Controller] 에러 : " + e.getMessage());
			System.out.println("why your sql doesn't working!!");
		}
		
		try {
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
		}
		
		return "guestcenter/guest_main";
	}
	
	@RequestMapping(value="/tiles123.do", method=RequestMethod.GET)
	public String tiles123(Model model){
		System.out.println("tiles123");
		return "index/bottom/body";
	}

	
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
}
