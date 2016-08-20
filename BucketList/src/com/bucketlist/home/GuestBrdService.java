package com.bucketlist.home;

import java.util.List;

import com.bucketlist.dto.GuestBrdVO;

public interface GuestBrdService {
	List<GuestBrdVO> getBoardList();
	void insertUser(GuestBrdVO gbVO);
	GuestBrdVO getBoardContent(Integer brdno);
}