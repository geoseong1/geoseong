package com.bucketlist.service;

import java.util.List;

import com.bucketlist.dto.MemberVO;

public interface MemberService {
	List<MemberVO> getMemberList();
	void inserMember(MemberVO memVO);
	MemberVO getMemberContent(String userid);
	void removeMember(String userid);
	void updateMember(MemberVO memVO);
}
