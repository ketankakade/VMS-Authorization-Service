package com.quest.vms.dao;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quest.vms.dto.RoleDTO;
import com.quest.vms.entity.Role;
import com.quest.vms.repository.RolesRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RolesDAOImpl implements RolesDAO {

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired RolesRepository rolesRepository;

	@Override
	public List<RoleDTO> getRolesById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO getRoles(String name) {
		// TODO Auto-generated method stub
		Role role = rolesRepository.findByRoleName(name);
		RoleDTO dto = transformEntityToDto(role);
		return dto;
	}

	public Role transformDtoToEntity(RoleDTO dto) {
		return modelMapper.map(dto, Role.class);
	}

	public RoleDTO transformEntityToDto(Role entity) {
		return modelMapper.map(entity, RoleDTO.class);
	}

}
