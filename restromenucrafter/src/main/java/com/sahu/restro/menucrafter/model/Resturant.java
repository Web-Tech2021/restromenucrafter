package com.sahu.restro.menucrafter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.sahu.restro.menucrafter.constants.Status;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Resturant extends Auditable<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String photo;
	private String uuid;
	private Boolean active;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToMany(mappedBy = "resturants")
	private List<User> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resturant_type")
	private AppParamValue resturantype;
	
}
