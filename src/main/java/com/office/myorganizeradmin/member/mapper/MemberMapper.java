package com.office.myorganizeradmin.member.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.office.myorganizeradmin.member.MemberDto;

@Mapper
public interface MemberMapper {

	ArrayList<MemberDto> memberList();

	int memberModifyForRole(Map<String, String> map);

}
