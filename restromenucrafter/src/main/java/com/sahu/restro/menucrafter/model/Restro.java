package com.sahu.restro.menucrafter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.sahu.restro.menucrafter.constants.Status;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Restro extends Auditable<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String photo;
	private String uuid;
	private Boolean active;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToMany(mappedBy = "restros")
	private List<User> users;
	
}
