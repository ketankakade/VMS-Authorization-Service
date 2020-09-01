package com.quest.vms.service;

import com.quest.vms.common.utils.GenericResponse;
import com.quest.vms.dto.RoleDTO;

public interface AuthorizationService {

	public GenericResponse<RoleDTO> getRolesById(final Integer userId);
	
	public RoleDTO getRoles(final String roleName);
}
