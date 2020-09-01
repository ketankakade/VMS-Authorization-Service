package com.quest.vms.dao;

import java.util.List;

import com.quest.vms.dto.RoleDTO;

public interface RolesDAO {

	public RoleDTO getRoles(final String userId);
	public List<RoleDTO> getRolesById(Integer userId);

}
