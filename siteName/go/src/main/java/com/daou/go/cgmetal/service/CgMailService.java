package com.daou.go.cgmetal.service;

import java.sql.SQLException;

public interface CgMailService {
	public void vmailInsertValue(String sender, String receiver, String title, String content) throws SQLException;
}
