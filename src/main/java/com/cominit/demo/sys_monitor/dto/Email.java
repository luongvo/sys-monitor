package com.cominit.demo.sys_monitor.dto;

import org.thymeleaf.context.Context;

public class Email {
	private String[] to;
	private String[] cc;
	private String[] bcc;
	private String subject;
	private String template;
	private Context body;

	public String[] getTo() {
		return to;
	}

	public void setTo(String... to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String... cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String... bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return template + ".html";
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Context getBody() {
		return body;
	}

	public void setBody(Context body) {
		this.body = body;
	}

}
