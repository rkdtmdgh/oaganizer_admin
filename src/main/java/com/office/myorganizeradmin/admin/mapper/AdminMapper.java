package com.office.myorganizeradmin.admin.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.office.myorganizeradmin.admin.AdminDto;

@Mapper
public interface AdminMapper {

	Boolean isAdmin(String a_id);

	int adminSignUpConfirm(AdminDto adminDto);

	AdminDto getAdminById(String a_id);

	int adminModifyConfirm(AdminDto adminDto);

	int adminDeleteConfirm(String a_id);

	ArrayList<AdminDto> adminList();

	int adminModifyForRole(Map<String, String> map);

}
