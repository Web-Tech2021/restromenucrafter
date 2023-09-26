package com.sahu.restro.menucrafter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sahu.restro.menucrafter.constants.Status;
import com.sahu.restro.menucrafter.constants.SubscriptionSource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class NewsLetterSubscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private String email;
	private String firstName;
	private String lastName;
	private Date subscriptionDate;
	private Date unsubscriptionDate;
	private Boolean active;
	
	@Enumerated(EnumType.STRING)
	private Status subscriptionStatus;
	
	@Enumerated(EnumType.STRING)
	private SubscriptionSource subscriptionSource;
}
