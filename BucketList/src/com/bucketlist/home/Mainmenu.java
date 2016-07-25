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
	public String index_AOP(Model model){
		vo.msg();
		int daonum = vo.selectCode();
		System.out.println("Ctrller DAO : " + daonum);
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		model.addAttribute("testfor", vo.selectAll());
		return "test";
	}
	
	@RequestMapping(value="/test.2")
	public String index_nonAOP(Model model){
		System.out.println("test.2");
		vo.msg();
		int daonum = vo.selectCode();
		System.out.println("test2 Ctrller DAO : " + daonum);
		// model영역에 select pjtcode, pjtname 쿼리결과를 보냄
		model.addAttribute("testfor", vo.selectAll());
		return "test";
	}
}
