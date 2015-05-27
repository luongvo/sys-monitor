/**
 *
 */
package com.cominit.demo.sys_monitor.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cominit.demo.sys_monitor.dto.Attack;
import com.cominit.demo.sys_monitor.dto.Email;
import com.cominit.demo.sys_monitor.enums.AttackStatus;
import com.cominit.demo.sys_monitor.service.interfaces.IEmailService;

@Service
public class EmailService implements IEmailService {
	private static Logger LOGGER = Logger.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine templateEngine;

	public boolean sendEmail(Email email) {
		try {
			// Prepare message using a Spring helper
			final MimeMessage mimeMessage = this.javaMailSender
					.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(
					mimeMessage, true, "UTF-8");

			message.setFrom("notify-dn-olympus@axonactive.vn");
			message.setSubject(email.getSubject());
			message.setTo(email.getTo());

			// add cc and bcc
			if (email.getCc() != null && !"".equals(email.getCc())) {
				message.setCc(email.getCc());
			}
			if (email.getBcc() != null && !"".equals(email.getBcc())) {
				message.setBcc(email.getBcc());
			}

			// Create the HTML body using Thymeleaf
			final String htmlContent = this.templateEngine.process(
					email.getTemplate(), email.getBody());
			message.setText(htmlContent, true);

			// Send email
			this.javaMailSender.send(mimeMessage);
			return true;
		} catch (MessagingException | NullPointerException e) {
			LOGGER.error("Cannot send Email ", e);
		}
		return false;
	}

	public Email generateDailyStatisticEmail(long timestamp) {
		// generate data
		List<Attack> attacks = new ArrayList<>();
		attacks.add(new Attack("201.12.111.167", AttackStatus.BLOCKED));
		attacks.add(new Attack("165.1.253.3", AttackStatus.NOT_BLOCKED));
		attacks.add(new Attack("23.243.17.56", AttackStatus.BLOCKED));

		Email email = new Email();

		// generate excel file
		email.setSubject("[Cominit Monitoring System] Daily statistic");
		email.setTo("vodailuong@gmail.com");
		email.setTemplate("daily-statistic-template");

		// content variables
		Context ctx = new Context();
		ctx.setVariable("count", attacks.size());
		ctx.setVariable("attacks", attacks);
		email.setBody(ctx);

		return email;
	}

	

}
