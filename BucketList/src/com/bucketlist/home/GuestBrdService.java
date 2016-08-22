package com.bucketlist.home;

import java.util.List;

import com.bucketlist.dto.GuestBrdVO;

public interface GuestBrdService {
	List<GuestBrdVO> getBoardList();
	void inserBoard(GuestBrdVO gbVO);
	GuestBrdVO getBoardContent(Integer brdno);
	void removeBoard(Integer brdno);
	void updateBoard(GuestBrdVO gbVO);
}
