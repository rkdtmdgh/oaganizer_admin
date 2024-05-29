package com.office.myorganizeradmin.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.office.myorganizeradmin.admin.mapper.AdminMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminService {
	
	final static int ADMIN_ALREADY 			= -1;
	final static int ADMIN_SIGN_UP_FAIL		= 0;
	final static int ADMIN_SIGN_UP_SUCCESS 	= 1;
	
	final private AdminMapper adminMapper;
	final private PasswordEncoder passwordEncoder;
	
	public AdminService(AdminMapper adminMapper, PasswordEncoder passwordEncoder) {
		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	
	}

	// 관리자 회원 가입 확인
	public int adminSignUpConfirm(AdminDto adminDto) {
		log.info("adminSignUpConfirm()");
		
		// ID 중복 확인
		Boolean isAdmin = adminMapper.isAdmin(adminDto.getA_id());
		
		// 관리자 회원 가입
		if(!isAdmin) {
			log.info("THIS ADMIN ID DOES NOT EXIST");
			
			adminDto.setA_pw(passwordEncoder.encode(adminDto.getA_pw()));
			
			int result = adminMapper.adminSignUpConfirm(adminDto);
			
			if(result <= 0) {
				log.info("ADMIN SIGNUP FAIL");
				return ADMIN_SIGN_UP_FAIL;
				
			} else {
				log.info("ADMIN SIGNUP SUCCESS");
				return ADMIN_SIGN_UP_SUCCESS;
				
			}
			
		} else {
			log.info("THIS ADMIN ID EXIST");
			return ADMIN_ALREADY;
			
		}
	}

	// ID를 이용한 관리자 정보 조회
	public AdminDto getAdminById(String a_id) {
		log.info("getAdminById()");
		
		AdminDto loginedAdminDto = adminMapper.getAdminById(a_id);
		
		return loginedAdminDto;
		
	}

	// 관리자 정보 수정 확인
	public int adminModifyConfirm(AdminDto adminDto) {
		log.info("adminModifyConfirm()");
		
		adminDto.setA_pw(passwordEncoder.encode(adminDto.getA_pw()));
		int result = adminMapper.adminModifyConfirm(adminDto);
		
		return result;
	}

	// 관리자 회원 정보 삭제 확인
	public int adminDeleteConfirm(String a_id) {
		log.info("adminDeleteConfirm()");
		
		int result = adminMapper.adminDeleteConfirm(a_id);
		
		return result;
	}

	// 관리자 목록
	public ArrayList<AdminDto> adminList() {
		log.info("adminList()");
		
		return adminMapper.adminList();
	}

	// 관리자 ROLE 변경
	public Object adminModifyForRole(Map<String, String> map) {
		log.info("adminModifyForRole()");
		
		Map<String, Object> responseMap = new HashMap<>();
		
		int resultModifyForRole = adminMapper.adminModifyForRole(map);
		responseMap.put("resultModifyForRole", resultModifyForRole);
		
		return responseMap;
	}

}
