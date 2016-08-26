package com.bucketlist.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bucketlist.dao.MemberServiceImpl;
import com.bucketlist.dto.MemberVO;

@Controller
public class MemberController {

	/* Start : 변수 영역 */
	private MemberServiceImpl memberServiceImpl;
	public void setMemberServiceImpl(MemberServiceImpl memberServiceImpl) {
		this.memberServiceImpl = memberServiceImpl;
	}
	@Autowired
    private ServletContext servletContext;
	
/* End : 변수 영역 */
	
/* Start : 메소드 영역 */
	// 회원가입하기(GET)
	@RequestMapping(value="/joinmember.do", method=RequestMethod.GET)
	public String joinmember_get(Model model){
		System.out.println("\njoinmember_GET");
		return "account/join_member";
	} //end joinmember_get
	// 회원가입하기(POST)
		@RequestMapping(value="/joinmember.do", method=RequestMethod.POST)
		public String joinmember_post(Model model, /*HttpServletRequest request*/MemberVO memVO){
			System.out.println("\njoinmember_POST");
			try{
				System.out.println("------------------------------------dao에서 자료 빼오기 전");
				memberServiceImpl.inserMember(memVO);
				System.out.println("------------------------------------dao에서 자료 빼온 후\n");
				//model.addAttribute("guestbrd", list);
			}catch(Exception e){
				System.out.println("[Controller/Mainmenu] 에러 : " + e.getMessage());
			}
			return "redirect:default.do";
		} //end joinmember_post
		
		
	// 회원정보수정하기(GET)
	@RequestMapping(value="/updatemember.do", method=RequestMethod.GET)
	public String updatemember_get(Model model){
		System.out.println("\nupdatemember_GET");
		model.addAttribute("memInfo", memberServiceImpl.getMemberContent("geoseong"));
		return "account/update_member";
	}
	// 회원정보수정하기(POST)
	@RequestMapping(value="/updatemember.do", method=RequestMethod.POST)
	public String updatemember_post(Model model, /*HttpServletRequest request*/MemberVO memVO){
		System.out.println("\nupdatemember_POST");
		try{
			System.out.println("------------------------------------dao에서 자료 빼오기 전");
			memberServiceImpl.updateMember(memVO);
			System.out.println("------------------------------------dao에서 자료 빼온 후\n");
			//model.addAttribute("guestbrd", list);
		}catch(Exception e){
			System.out.println("[Controller/Mainmenu] 에러 : " + e.getMessage());
		}
		
		return "redirect:default.do";
	} //end joinmember_post
/* End : 메소드 영역 */
}
