package com.cand.source.bean;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cand.source.account.activation.EmailSender;

@Configuration
public class BeansConfig {

	@Bean
	public EmailSender emailSender() {
		EmailSender mailSender = new EmailSender();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("candsource@gmail.com");
		mailSender.setPassword("energystar");
		Properties prop = mailSender.getJavaMailProperties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.debug", "true");
		return mailSender;
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource("/com/cand/properties/basic.properties"),
				new ClassPathResource("/com/cand/properties/dataBase.properties") };
		properties.setLocations(resources);
		properties.setIgnoreUnresolvablePlaceholders(true);
		return properties;

	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

}
