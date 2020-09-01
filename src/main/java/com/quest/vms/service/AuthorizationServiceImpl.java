package com.quest.vms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quest.vms.common.utils.ErrorCodes;
import com.quest.vms.common.utils.GenericResponse;
import com.quest.vms.dao.RolesDAO;
import com.quest.vms.dto.RoleDTO;
import com.quest.vms.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	private RolesDAO rolesDao;

	@Override
	public GenericResponse<RoleDTO> getRolesById(final Integer userId) {
		log.info("get roles by userId {} " + userId);
		GenericResponse<RoleDTO> genericResponse = new GenericResponse<>(ErrorCodes.BAD_REQUEST_STATUS_CODE,
				"BAD_REQUEST", null, null);
		List<RoleDTO> roleDTO = rolesDao.getRolesById(userId);
		if (roleDTO != null) {
			genericResponse.setStatusCode(HttpStatus.OK.value());
			genericResponse.setMessage("Success");
			genericResponse.setData(roleDTO);
		} else {
			genericResponse.setMessage("Roles not found");
		}
		return genericResponse;
	}

	@Override
	public RoleDTO getRoles(String roleName) {
		// TODO Auto-generated method stub
		GenericResponse<RoleDTO> genericResponse = new GenericResponse<>(ErrorCodes.BAD_REQUEST_STATUS_CODE,
				"BAD_REQUEST", null, null);
		RoleDTO dto = rolesDao.getRoles(roleName);
		if(dto == null) {
			throw new ServiceException("roles not found");
			//genericResponse.setMessage("failed");
		}else {
			return dto;
			//genericResponse.setData(Collections.singletonList(dto));
			//genericResponse.setMessage("Success");
		}
		//return genericResponse;
	}

}
