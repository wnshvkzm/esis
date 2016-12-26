package com.daou.go.cgmetal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ErpConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = DriverManager
				.getConnection(
						"jdbc:sqlserver://59.24.255.110:11433;databasename=UNILITE5_NEW",
						"UNILITE", "UNILITE");
		return connection;
	}

}