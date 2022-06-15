package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@Column(name="uno")
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "myGenerator")
	private Integer uno;
	@Column(name = "uname")
	private String uname;
	@Column(name="uemail")
	private String uemail;
	@Column (name="upassword")
	private String upassword;
	@Column (name="uaddress")
	private String uaddress;
	
	
	

}
