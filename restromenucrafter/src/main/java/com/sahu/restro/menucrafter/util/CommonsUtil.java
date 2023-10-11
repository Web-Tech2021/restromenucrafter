package com.sahu.restro.menucrafter.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class CommonsUtil {

	public String getSiteURL(HttpServletRequest request) {
		return ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toString();
	}

	public String prepareTheMailBodyContent(String content, Map<String, String> replacements) {
		StringBuffer contentBuffer = new StringBuffer(content);

		for (String wordToReplace : replacements.keySet()) {
			String replacement = replacements.get(wordToReplace);
			contentBuffer.replace(content.indexOf(wordToReplace),
					content.indexOf(wordToReplace) + wordToReplace.length(), replacement);
		}

		return contentBuffer.toString();
	}

}
