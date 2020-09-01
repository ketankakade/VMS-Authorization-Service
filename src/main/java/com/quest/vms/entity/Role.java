package com.quest.vms.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	public static final String ROLE_ID = "role_id";
	public static final String ROLE_NAME = "role_name";
	public static final String ROLE_DESC = "role_desc";
	public static final String CREATED_TIMESTAMP = "created_ts";
	public static final String FK_PERM = "fk_perm";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ROLE_ID)
	private Integer roleId;

	@Column(name = ROLE_NAME, nullable = false)
	private String roleName;

	@Column(name = ROLE_DESC, nullable = false)
	private String roleDesc;

	@CreationTimestamp
	@Column(name = CREATED_TIMESTAMP)
	private Timestamp createdTs;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_PERM", nullable = false)
	private List<Permission> permissions;

}
