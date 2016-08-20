package com.bucketlist.home;

import java.util.Date;

public class GuestBrdVO {
	private int brdno; /* 게시번호 */
	private String brduserid; /* 아이디 */
	private String brdsubject; /* 제목 */
	private String brdcontext; /* 내용 */
	private String brdfilepath; /* 파일 */
	private String brdcount; /* 조회수 */
	private Date brdadddate; /* 게시날짜 */
	
	public GuestBrdVO(int brdno, String brduserid, String brdsubject, String brdcontext, String brdfilepath,
			String brdcount, Date brdadddate) {
		super();
		this.brdno = brdno;
		this.brduserid = brduserid;
		this.brdsubject = brdsubject;
		this.brdcontext = brdcontext;
		this.brdfilepath = brdfilepath;
		this.brdcount = brdcount;
		this.brdadddate = brdadddate;
	}
	
	public int getBrdno() {
		return brdno;
	}
	public void setBrdno(int brdno) {
		this.brdno = brdno;
	}
	public String getBrduserid() {
		return brduserid;
	}
	public void setBrduserid(String brduserid) {
		this.brduserid = brduserid;
	}
	public String getBrdsubject() {
		return brdsubject;
	}
	public void setBrdsubject(String brdsubject) {
		this.brdsubject = brdsubject;
	}
	public String getBrdcontext() {
		return brdcontext;
	}
	public void setBrdcontext(String brdcontext) {
		this.brdcontext = brdcontext;
	}
	public String getBrdfilepath() {
		return brdfilepath;
	}
	public void setBrdfilepath(String brdfilepath) {
		this.brdfilepath = brdfilepath;
	}
	public String getBrdcount() {
		return brdcount;
	}
	public void setBrdcount(String brdcount) {
		this.brdcount = brdcount;
	}
	public Date getBrdadddate() {
		return brdadddate;
	}
	public void setBrdadddate(Date brdadddate) {
		this.brdadddate = brdadddate;
	}
	
	
}
