package com.daou.go.cgmetal.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.daou.go.integration.domain.CgMail;
import com.daou.go.integration.repository.CgMailRepository;

@Service
@Configurable
public class CgMailServiceImpl implements CgMailService {

	@Autowired(required=true)
	@Qualifier("cgMailRepository")
	CgMailRepository cgMailRepository;

	@Transactional
	@Override
	public void vmailInsertValue(String sender, String receiver, String title,
			String content) {

		
		CgMail mail = new CgMail();

		mail.setMake_day(Date());
		mail.setSender(sender);
		mail.setReceiver(receiver);
		mail.setTitle(title);
		mail.setMail_desc(content);
		mail.setCheck_flag('N');
		mail.setBody_flag("html");

		this.cgMailRepository.save(mail);

	}

	public String Date() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		String today = dateFormat.format(date);

		return today;
	}

}
