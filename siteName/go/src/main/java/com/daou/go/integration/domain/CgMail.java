package com.daou.go.integration.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "com.daou.go.integration.domain.cgmail")
@Table(name="vmail")
public class CgMail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id; // id
	
	@Column(name="make_day")
	private String make_day; // DB입력 날짜

	@Column(name="sender")
	private String sender; // 보내는 사람
	
	@Column(name="receiver")
	private String receiver; // 받는사람
	
	@Column(name="title")
	private String title; // 제목
	
	@Column(name="mail_desc")
	private String mail_desc; // 본문
	
	@Column(name="reg_daytime", nullable = true)
	private Date reg_daytime; //메일 발송시간
	
	@Column(name="body_flag")
	private String body_flag; //본문타입(text/html)
	
	@Column(name="check_flag")
	private char check_flag; //발송여부 'Y'or 'N'
	
	@Column(name="attaches_dir", nullable = true)
	private String attaches_dir; // 첨부파일 경로

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake_day() {
		return make_day;
	}

	public void setMake_day(String make_day) {
		this.make_day = make_day;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMail_desc() {
		return mail_desc;
	}

	public void setMail_desc(String mail_desc) {
		this.mail_desc = mail_desc;
	}

	public Date getReg_daytime() {
		return reg_daytime;
	}

	public void setReg_daytime(Date reg_daytime) {
		this.reg_daytime = reg_daytime;
	}

	public String getBody_flag() {
		return body_flag;
	}

	public void setBody_flag(String body_flag) {
		this.body_flag = body_flag;
	}

	public char getCheck_flag() {
		return check_flag;
	}

	public void setCheck_flag(char check_flag) {
		this.check_flag = check_flag;
	}

	public String getAttaches_dir() {
		return attaches_dir;
	}

	public void setAttaches_dir(String attaches_dir) {
		this.attaches_dir = attaches_dir;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CgMail [id=");
		builder.append(id);
		builder.append(", make_day=");
		builder.append(make_day);
		builder.append(", sender=");
		builder.append(sender);
		builder.append(", receiver=");
		builder.append(receiver);
		builder.append(", title=");
		builder.append(title);
		builder.append(", mail_desc=");
		builder.append(mail_desc);
		builder.append(", reg_daytime=");
		builder.append(reg_daytime);
		builder.append(", body_flag=");
		builder.append(body_flag);
		builder.append(", check_flag=");
		builder.append(check_flag);
		builder.append(", attaches_dir=");
		builder.append(attaches_dir);
		builder.append("]");
		return builder.toString();
	}


}
