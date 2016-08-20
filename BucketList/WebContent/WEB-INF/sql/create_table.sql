-- 회원
create table member(
	userid varchar(50), /* 아이디 */
	username varchar(50), /* 이름 */
	userpwd varchar(50), /* 비번 */
	userphone varchar(50), /* 연락처 */
	useremail varchar(100), /* 이메일 */
	joindate date, /* 가입날짜 */
	writedbrd varchar(50), /* 남긴 테이블명+글번호 */
	writedreply varchar(900), /* 남긴 댓글 */
	primary key(userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 게스트센터 게시판 : 위시에듀
create table guest_wishedu(
	brdno int AUTO_INCREMENT, /* 게시번호 */
	brduserid varchar(50), /* 아이디 */
	brdsubject varchar(100), /* 제목 */
	brdcontext text, /* 내용 */
	brdfilepath text, /* 파일 */
	brdcount varchar(20), /* 조회수 */
	brdadddate date, /* 게시날짜 */
	primary key(brdno),
	FOREIGN KEY (brduserid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

----------------------------- 여기까지 만듦.

-- 게스트센터 게시판 : 위시라이프
create table guest_wishlife(

);


-- 회원버켓리스트정보
CREATE TABLE bucketlist_info (
  userid varchar(50), /* 아이디 */
  bucketlist_name varchar(100), /* 버켓리스트명 */
  wishedu_info int, /* 위시에듀정보 */
  wishlife_info int, /* 위시라이프정보 */
  primary key(userid),
	FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;