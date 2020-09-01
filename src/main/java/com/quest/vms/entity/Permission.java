package com.quest.vms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

	public static final String PERM_ID = "perm_id";
	public static final String PERM_NAME = "perm_name";
	public static final String PERM_DESC = "perm_desc";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PERM_ID)
	private Integer permissionId;

	@Column(name = PERM_NAME)
	private String permName;

	@Column(name = PERM_DESC)
	private String permDesc;

}
