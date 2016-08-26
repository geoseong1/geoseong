package com.bucketlist.dto;

public class MemberVO {
	private String userid; /* 아이디 */
	private String username; /* 이름 */
	private String userpwd; /* 비번 */
	private String userphone; /* 연락처 */
	private String useremail; /* 이메일 */
	private String joindate; /* 가입날짜 */
	private String writedbrd; /* 남긴 테이블명+글번호 */
	private String writedreply; /* 남긴 댓글 */
	
	
	public MemberVO() {
		super();
	}

	public MemberVO(String userid, String username, String userpwd, String userphone, String useremail, String joindate,
			String writedbrd, String writedreply) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.userphone = userphone;
		this.useremail = useremail;
		this.joindate = joindate;
		this.writedbrd = writedbrd;
		this.writedreply = writedreply;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getWritedbrd() {
		return writedbrd;
	}

	public void setWritedbrd(String writedbrd) {
		this.writedbrd = writedbrd;
	}

	public String getWritedreply() {
		return writedreply;
	}

	public void setWritedreply(String writedreply) {
		this.writedreply = writedreply;
	}
	
	
}
