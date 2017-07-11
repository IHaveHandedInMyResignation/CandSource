package com.cand.source.account.activation;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.cand.source.persistentce.Profile;

public class EmailSender extends JavaMailSenderImpl {

	private static final Logger log = Logger.getLogger(EmailSender.class);
	private static final String HEADER_MESSAGE = "To activate your account and verify your email address, please click the following link:\n\n";
	private static final String FOOTER_MESSAGE = "\n\n\nThis is a post-only mailing.  Replies to this message are not monitored or answered.";

	public void sendActivationEmailMsg(Profile profile, String code) {
		String activUrl = "http://localhost:8080/CAndSource/account/" + profile.getLogin() + "/email/" + code + "/activation";

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(HEADER_MESSAGE);
		strBuilder.append(activUrl);
		strBuilder.append(FOOTER_MESSAGE);
		
		MimeMessage mimeMessage = createMimeMessage();
		MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
		try {
			mailMsg.setFrom("candsource@gmail.com");
			mailMsg.setTo("ra9191@o2.pl"); //TODO
			mailMsg.setSubject("C&Source account activacion email");
			mailMsg.setText(strBuilder.toString());
			send(mimeMessage);
		} catch (MessagingException e) {
			log.error(e.getMessage(), e);
		}
	}

}
