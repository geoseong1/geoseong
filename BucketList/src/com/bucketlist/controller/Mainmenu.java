package com.bucketlist.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.web.util.ServletContextAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
    private ServletContext servletContext;
	
/* End : 변수 영역 */
	

/* Start : 메소드 영역 */
	@RequestMapping(value="/default.do", method=RequestMethod.GET)
	public String tiles(Model model){
		System.out.println("tiles");
		return "default";
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
