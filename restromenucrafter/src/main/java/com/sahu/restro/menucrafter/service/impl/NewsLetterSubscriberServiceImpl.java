package com.sahu.restro.menucrafter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.restro.menucrafter.model.NewsLetterSubscriber;
import com.sahu.restro.menucrafter.repository.NewsLetterSubscriberRepository;
import com.sahu.restro.menucrafter.service.NewsLetterSubscriberService;

@Service
public class NewsLetterSubscriberServiceImpl implements NewsLetterSubscriberService {

	@Autowired
	private NewsLetterSubscriberRepository newsLetterSubscriberRepository;
	
	@Override
	public NewsLetterSubscriber save(NewsLetterSubscriber subscriber) {
		return newsLetterSubscriberRepository.save(subscriber);
	}

}
