package com.bucketlist.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mainmenu {

	private VO vo;
	public void setVo(VO vo) {
		this.vo = vo;
	}

	@RequestMapping(value="/test.1")
	public String index(Model model){
		System.out.println("hi");
		vo.msg();
		/*int daonum = vo.selectCode();
		System.out.println("Ctrller DAO : " + daonum);*/
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		//model.addAttribute("testfor", vo.selectAll());
		return "test";
	}
}
