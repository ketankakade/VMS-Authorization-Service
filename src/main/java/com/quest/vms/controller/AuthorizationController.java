package com.quest.vms.controller;

import static com.quest.vms.common.utils.VmsConstants.AUTHORIZATION_URL_PATH;
import static com.quest.vms.common.utils.VmsConstants.ROLES;
import static com.quest.vms.common.utils.VmsConstants.ROLE_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.vms.common.utils.GenericResponse;
import com.quest.vms.dto.RoleDTO;
import com.quest.vms.exception.ServiceException;
import com.quest.vms.service.AuthorizationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/" + AUTHORIZATION_URL_PATH)
@Api(value = "Authorization controller", description = "")
@Slf4j
public class AuthorizationController {

	@Autowired
	AuthorizationService authorizationService;

	@ApiOperation(value = "Get roles and permissoins by name")
	@GetMapping(ROLES + "/{" + ROLE_NAME + "}")
	public RoleDTO getRoles(@PathVariable(value = ROLE_NAME) String roleName) {
		GenericResponse<RoleDTO> getVisitorGenericResponse = null;
		try {
			RoleDTO role = authorizationService.getRoles(roleName);
			//log.info("name " + getVisitorGenericResponse.getData().get(0).getRoleName());
			return role;
			//return getVisitorGenericResponse;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}