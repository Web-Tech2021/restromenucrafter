package com.sahu.restro.menucrafter.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sahu.restro.menucrafter.constants.RestroMenuCrafterConstants;
import com.sahu.restro.menucrafter.model.User;

@Component
public class MailSenderUtil {

	private Logger LOGGER = LoggerFactory.getLogger(MailSenderUtil.class);

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Autowired
	private Environment environment;

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private CommonsUtil commonsUtil;

	public String sendMailForResetPassword(User user, String siteURL) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage(); 
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
		messageHelper.setFrom(fromEmail);
		messageHelper.setTo(user.getEmail());
		messageHelper.setSubject(environment.getProperty("reset_password_subject"));
		messageHelper.setSentDate(new Date());

		try {
			File resetPasswordFile = resourceLoader.getResource("classpath:mail/reset_password_mail.ftl").getFile();
			String resetPasswordBody = new String(Files.readAllBytes(resetPasswordFile.toPath()));
			
			Map<String, String> replacements = new HashMap<>();
			replacements.put(RestroMenuCrafterConstants.FTL_SITE_URL, siteURL);
			replacements.put(RestroMenuCrafterConstants.FTL_USER_NAME, user.getFirstName() + " " + user.getLastName());
			replacements.put(RestroMenuCrafterConstants.FTL_REST_PSW_URL, siteURL + RestroMenuCrafterConstants.RESET_PWD_TOKEN_ATR + user.getResetPasswordToken());

			messageHelper.setText(commonsUtil.prepareTheMailBodyContent(resetPasswordBody, replacements), true);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}
		
		mailSender.send(mimeMessage);
		return "Mail sent";
	}

	public String sendWelcomeMail(User user, String siteURL) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(fromEmail);
			messageHelper.setTo(user.getEmail());
			messageHelper.setSubject(environment.getProperty("welcome_to_website_subject"));
			messageHelper.setSentDate(new Date());

			File welcomeFile = resourceLoader.getResource("classpath:mail/welcome_mail.ftl").getFile();
			String welcomeBody = new String(Files.readAllBytes(welcomeFile.toPath()));
			
			Map<String, String> replacements = new HashMap<>();
			replacements.put(RestroMenuCrafterConstants.FTL_SITE_URL, siteURL);
			replacements.put(RestroMenuCrafterConstants.FTL_USER_NAME, user.getFirstName() + " " + user.getLastName());

			messageHelper.setText(commonsUtil.prepareTheMailBodyContent(welcomeBody, replacements), true);
			mailSender.send(mimeMessage);

			return "Mail sent";
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		} catch (MessagingException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}
	}

}
