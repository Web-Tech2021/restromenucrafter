package com.sahu.restro.menucrafter.util;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sahu.restro.menucrafter.constants.Status;
import com.sahu.restro.menucrafter.constants.SubscriptionSource;
import com.sahu.restro.menucrafter.model.NewsLetterSubscriber;
import com.sahu.restro.menucrafter.model.User;
import com.sahu.restro.menucrafter.service.NewsLetterSubscriberService;

@Component
public class NewsLetterSubscriberUtil {

	@Autowired
	private NewsLetterSubscriberService newsLetterSubscriberService;
	
	public void addRegisteredUserAsSubscriber(User user) {
		NewsLetterSubscriber subscriber = new NewsLetterSubscriber() ;
		if(user != null) {
			subscriber.setUuid(UUID.randomUUID().toString());
			subscriber.setEmail(user.getEmail());
			subscriber.setFirstName(user.getFirstName());
			subscriber.setLastName(user.getLastName());
			subscriber.setSubscriptionDate(new Date());
			subscriber.setActive(true);
			subscriber.setSubscriptionStatus(Status.ACTIVE);
			subscriber.setSubscriptionSource(SubscriptionSource.REGISTERED);
			
			newsLetterSubscriberService.save(subscriber);
		}
	}
	
}
