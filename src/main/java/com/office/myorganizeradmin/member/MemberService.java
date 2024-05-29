package com.office.myorganizeradmin.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.office.myorganizeradmin.member.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberService {

	final private MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	
	}

	// 회원 리스트
	public ArrayList<MemberDto> memberList() {
		log.info("memberList()");
		
		return memberMapper.memberList();
		
	}

	// 회원 권한(ROLE) 변경
	public Object memberModifyForRole(Map<String, String> map) {
		log.info("memberModifyForRole()");
		
		Map<String, Object> responseMap = new HashMap<>();
		
		int resultModifyForRole = memberMapper.memberModifyForRole(map);
		responseMap.put("resultModifyForRole", resultModifyForRole);
		
		return responseMap;
	}
	
}
