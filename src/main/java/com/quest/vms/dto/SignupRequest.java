package com.quest.vms.dto;

import java.util.List;
import java.util.Set;

import com.quest.vms.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

	private String username;
	private String email;
	private String password;
	private Set<String> role;
}
