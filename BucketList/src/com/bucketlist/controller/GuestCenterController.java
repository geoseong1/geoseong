package com.bucketlist.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bucketlist.dao.GuestBrdServiceImpl;
import com.bucketlist.dto.GuestBrdVO;

@Controller
public class GuestCenterController {

/* Start : 변수 영역 */
	private GuestBrdServiceImpl guestBrdServiceImpl;
	public void setGuestBrdServiceImpl(GuestBrdServiceImpl guestBrdServiceImpl) {
		this.guestBrdServiceImpl = guestBrdServiceImpl;
	}
	@Autowired
    private ServletContext servletContext;
	
/* End : 변수 영역 */
	
/* Start : 메소드 영역 */
	// Guestcenter게시판메인 : 리스트 보기
	@RequestMapping(value="/guestcenter.do", method=RequestMethod.GET)
	public String guestcenter(Model model){
		System.out.println("\nguestcenter/guest_main");
		try{
			System.out.println("------------------------------------dao에서 자료 빼오기 전");
			List<GuestBrdVO> list = guestBrdServiceImpl.getBoardList();
			System.out.println("------------------------------------dao에서 자료 빼온 후\n");
			model.addAttribute("guestbrd", list);
		}catch(Exception e){
			System.out.println("[Controller/Mainmenu] 에러 : " + e.getMessage());
		}
		return "guestcenter/guest_main";
	} //end guestcenter list mainmenu 
	
	// 글쓰기 화면(GET)
	@RequestMapping(value="/guestinsert.do", method=RequestMethod.GET)
	public String guestinsert_get(Model model){
		System.out.println("guestinsert_get");		
		return "guestcenter/guest_insert";
	} //end guestinsert_get

	// 글쓰기 버튼 눌렀을때 (POST)
	@RequestMapping(value="/guestinsert.do", method=RequestMethod.POST)
	public String guestinsert_post(Model model, GuestBrdVO gbVO, HttpServletRequest request){
		System.out.println("guestinsert_post");	
		MultipartFile file = gbVO.getFile();
		// servletContext정의는 이렇게 해야 핵이다
		servletContext = request.getSession().getServletContext();
			System.out.println("  file getOriginalFilename?  //" + file.getOriginalFilename());
		// 파일을 업로드했을때만 실행됨
		if(!file.getOriginalFilename().equals("")){	
			String brdfilepath = file.getOriginalFilename();
			gbVO.setBrdfilepath(brdfilepath);	//brdfilepath에 파일이름 넣기
			try{
				String webpath = servletContext.getRealPath("resources/files/guestcenter/");
					System.out.println("     저장경로 : " + webpath);
				File fileclass = new File(webpath+brdfilepath);
				file.transferTo(fileclass);
			}catch(IOException e){
				System.out.println("[guestinsert.do] 에러 : " + e.getMessage());
			}
		} //end if
		// 이 한줄로 실제 SQL에 적용할 것임.
		guestBrdServiceImpl.inserBoard(gbVO);
		return "redirect:guestcenter.do";
	} //end guestinsert_post
	
	// 게시글 내용 들어가서 보기
	@RequestMapping(value="/guestcontent.do", method=RequestMethod.GET)
	public String guestcontent_get(Model model, HttpServletRequest request){
		System.out.println("guestinsert_get brdno? -- " + request.getParameter("brdno"));
		GuestBrdVO gbVO = guestBrdServiceImpl.getBoardContent(Integer.parseInt(request.getParameter("brdno")));
		// 엔터친 내용을 <br>태그로 치환해서 실제로 jsp에서도 한 줄 내려가게 구현.
		gbVO.setBrdcontext(gbVO.getBrdcontext().replace("\r\n", "<br>"));
		model.addAttribute("guestbrd", gbVO);
		return "guestcenter/guest_content";
	} //end guestcontent_get
	
	// 선택된 게시글 제거하기
	@RequestMapping(value="/guestdelete.do", method=RequestMethod.POST)
	public String guestdelete_get(Model model, HttpServletRequest request){
		System.out.println("guestdelete_get brdno ? " + request.getParameter("brdno"));
		guestBrdServiceImpl.removeBoard(Integer.parseInt(request.getParameter("brdno")));
		return "redirect:guestcenter.do";
	} //end guestdelete_get
	
	// 선택된 게시글 수정하기
	@RequestMapping(value="/guestupdate.do", method=RequestMethod.GET)
	public String guestupdate_get(Model model, HttpServletRequest request){
		System.out.println("guestupdate_get brdno ? " + request.getParameter("brdno"));
		model.addAttribute("guestbrd", guestBrdServiceImpl.getBoardContent(Integer.parseInt(request.getParameter("brdno"))));
		return "guestcenter/guest_modify";
	} //end guestupdate_get
		
	// 선택된 게시글 수정 완료 (POST)
	@RequestMapping(value="/guestupdate.do", method=RequestMethod.POST)
	public String guestupdate_post(Model model, GuestBrdVO gbVO, HttpServletRequest request){
		System.out.println("guestupdate_post");	
		MultipartFile file = gbVO.getFile();
		// servletContext정의는 이렇게 해야 핵이다 = 적용된다.
		servletContext = request.getSession().getServletContext();
			System.out.println("  file getOriginalFilename?  //" + file.getOriginalFilename());
		// file.getOriginalFilename이 공란이 아닐때 실행됨
		//if(!file.getOriginalFilename().equals("")){	
			String brdfilepath = file.getOriginalFilename();
			gbVO.setBrdfilepath(brdfilepath);	//brdfilepath에 파일이름 넣기
			try{
				String webpath = servletContext.getRealPath("resources/files/guestcenter/");
					System.out.println("     저장경로 : " + webpath);
				File fileclass = new File(webpath+brdfilepath);
				file.transferTo(fileclass);	// 업로드하려는 파일을 File클래스를 이용하여 실제 지정한 경로로 업로드. 
			}catch(IOException e){
				System.out.println("[guestinsert.do] 에러 : " + e.getMessage());
			}
		//} //end if
		// 이 한줄로 실제 SQL에 적용할 것임.
		guestBrdServiceImpl.updateBoard(gbVO);
		return "redirect:guestcenter.do";
	} //end guestupdate_post
	
	// 선택된 게시글 수정 완료 (POST)
	@RequestMapping(value="/fileremove.do", method=RequestMethod.POST)
	/*@ResponseBody*/
	public String ajax_fileremove(Model model, HttpServletRequest request){
		System.out.println("fileremove.do POST & brdno : " + request.getParameter("brdno"));
		GuestBrdVO gbVO = guestBrdServiceImpl.getBoardContent(Integer.parseInt(request.getParameter("brdno")));
			System.out.println("before] brdfilepath : " + gbVO.getBrdfilepath());
		gbVO.setBrdfilepath(null);
			System.out.println("after] brdfilepath : " + gbVO.getBrdfilepath());
		return "guestcenter/guest_modify";
	}
/* End : 메소드 영역 */
}
