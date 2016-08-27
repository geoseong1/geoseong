package com.bucketlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bucketlist.dao.VO;

@Controller
public class Mainmenu {

/* Start : 변수 영역 */
	private VO vo;
	public void setVo(VO vo) {
		this.vo = vo;
	}
/* End : 변수 영역 */
	

/* Start : 메소드 영역 */
	// BucketList 맨 첫 페이지
	@RequestMapping(value="/default.do", method=RequestMethod.GET)
	public String tiles(Model model){
		System.out.println("tiles");
		return "default";
	}
	// login.jsp로 이동
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(Model model){
		
		System.out.println("login");
		return "login";
	}
	
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
