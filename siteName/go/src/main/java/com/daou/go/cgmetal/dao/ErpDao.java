package com.daou.go.cgmetal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daou.go.cgmetal.domain.ManufactureStatus;
import com.daou.go.cgmetal.domain.OutsourceStatus;
import com.daou.go.cgmetal.domain.PurchaseStatus;
import com.daou.go.cgmetal.domain.StockStatus;

public class ErpDao {
	private ConnectionMaker connectionMaker;

	public ErpDao(ConnectionMaker connection) {
		this.connectionMaker = connection;
	}

	public List<StockStatus> getStockCondition(String itemAccount)
			throws ClassNotFoundException, SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<StockStatus> list = new ArrayList<StockStatus>();

		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("SELECT ITEM_CODE, ITEM_NAME,"
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(STOCK_Q AS MONEY), 1),'.00','') as STOCK_Q, "
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(SAFE_STOCK_Q AS MONEY), 1),'.00','') as SAFE_STOCK_Q"
							+ ", SAFE_STOCK_PER "
							+ "FROM GW_STOCK_STATUS "
							+ "WHERE (CONVERT(varchar(10), MAKE_DATE,112)=CONVERT(varchar(10), GETDATE()-1,112)) "
							+ "AND ITEM_ACCOUNT= ? ");

			statement.setString(1, itemAccount);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				StockStatus status = new StockStatus();

				status.setItemCode(resultSet.getString("ITEM_CODE"));
				status.setItemName(resultSet.getString("ITEM_NAME"));
				status.setStockQ(resultSet.getString("STOCK_Q"));
				status.setSafeStockQ(resultSet.getString("SAFE_STOCK_Q"));
				status.setSafeStockPer(resultSet.getInt("SAFE_STOCK_PER"));

				list.add(status);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
				}
			}
		}
		return list;
	}

	public List<PurchaseStatus> getPurchaseCondition()
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PurchaseStatus> list = new ArrayList<PurchaseStatus>();
		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("select custom_name, ITEM_ACCOUNT_NAME, ITEM_NAME,custom_code, ORDER_DATE, "
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(ORDER_Q AS MONEY), 1),'.00','') as ORDER_Q, "
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(NOTINSTOCK_Q AS MONEY), 1),'.00','') as NOTINSTOCK_Q, "
							+ "DVRY_DATE, MAIL_ID "
							+ "FROM GW_PURCHASE_STATUS "
							+ "WHERE NOTINSTOCK_Q IS NOT NULL "
							+ "AND (CONVERT(varchar(10), MAKE_DATE,112)=CONVERT(varchar(10), GETDATE(),112)) "
							+ "ORDER BY custom_code asc, DVRY_DATE desc;");

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PurchaseStatus status = new PurchaseStatus();

				status.setCustomName(resultSet.getString("custom_name"));
				status.setItemAccountName(resultSet
						.getString("ITEM_ACCOUNT_NAME"));
				status.setItemName(resultSet.getString("ITEM_NAME"));
				status.setCustomCode(resultSet.getString("custom_code"));
				status.setMakeDate(resultSet.getString("ORDER_DATE"));
				status.setOrderQ(resultSet.getString("ORDER_Q"));
				status.setNotinstockQ(resultSet.getString("NOTINSTOCK_Q"));
				status.setDvryDate(resultSet.getString("DVRY_DATE"));
				status.setMailId(resultSet.getString("MAIL_ID"));

				list.add(status);
			}
		} catch (Exception e) {

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {

				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {

				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {

				}
			}
		}
		return list;
	}

	public List<PurchaseStatus> getCustomName() throws ClassNotFoundException,
			SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PurchaseStatus> list = new ArrayList<PurchaseStatus>();

		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("select distinct(custom_name), MAIL_ID, custom_code "
							+ "FROM GW_PURCHASE_STATUS "
							+ "WHERE NOTINSTOCK_Q IS NOT NULL "
							+ "AND (CONVERT(varchar(10), MAKE_DATE,112)=CONVERT(varchar(10), GETDATE()-1,112)) "
							+ "ORDER BY custom_code asc;");

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PurchaseStatus status = new PurchaseStatus();
				status.setCustomName(resultSet.getString("custom_name"));
				status.setMailId(resultSet.getString("MAIL_ID"));
				status.setCustomCode(resultSet.getString("custom_code"));

				list.add(status);
			}
		} catch (Exception e) {

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {

				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {

				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {

				}
			}
		}
		return list;
	}

	public List<OutsourceStatus> getOutsourceCondition()
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<OutsourceStatus> list = new ArrayList<OutsourceStatus>();
		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("select "
							+ "CUSTOM_NAME, TREE_CODE, TREE_NAME, ITEM_NAME, ORDER_DATE, "
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(ORDER_Q AS MONEY), 1),'.00','') as ORDER_Q, "
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(NOTINSTOCK_Q AS MONEY), 1),'.00','') as NOTINSTOCK_Q, "
							+ "DVRY_DATE, MAIL_ID "
							+ "FROM GW_OUTSOURCE_STATUS "
							+ "WHERE (CONVERT(varchar(10), MAKE_DATE ,112)=CONVERT(varchar(10), GETDATE()-1 ,112)) "
							+ "AND NOTINSTOCK_Q > 0"
							+ "order by TREE_CODE asc, ORDER_DATE asc ");

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OutsourceStatus status = new OutsourceStatus();
				status.setCustomName(resultSet.getString("CUSTOM_NAME"));
				status.setTreeName(resultSet.getString("TREE_NAME"));
				status.setItemName(resultSet.getString("ITEM_NAME"));
				status.setMakeDate(resultSet.getString("ORDER_DATE"));
				status.setOrderQ(resultSet.getString("ORDER_Q"));
				status.setNotinstockQ(resultSet.getString("NOTINSTOCK_Q"));
				status.setDvryDate(resultSet.getString("DVRY_DATE"));

				list.add(status);
			}
		} catch (Exception e) {

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {

				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {

				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {

				}
			}
		}
		return list;
	}

	public List<OutsourceStatus> getOutsourceCustomName()
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<OutsourceStatus> list = new ArrayList<OutsourceStatus>();
		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("select distinct(CUSTOM_NAME), MAIL_ID "
							+ "FROM GW_OUTSOURCE_STATUS "
							+ "WHERE (CONVERT(varchar(10), MAKE_DATE ,112)=CONVERT(varchar(10), GETDATE()-1 ,112)) ");

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OutsourceStatus status = new OutsourceStatus();
				status.setCustomName(resultSet.getString("CUSTOM_NAME"));
				status.setMailId(resultSet.getString("MAIL_ID"));

				list.add(status);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
				}
			}
		}
		return list;
	}

	public List<ManufactureStatus> getManufacture(String workShopCode)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<ManufactureStatus> list = new ArrayList<ManufactureStatus>();
		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("SELECT WORK_SHOP_NAME, ITEM_NAME, "
							+ "REPLACE(CONVERT(VARCHAR(50),CAST(WKORD_Q AS MONEY), 1),'.00','') as WKORD_Q, "
							+ "ROUND(TIME_RATE,1) as TIME_RATE, ROUND(TEMPN_03,1) as TEMPN_03,0"
							+ ", ROUND(GOOD_RATE,1) as GOOD_RATE, ROUND(TOTAL_RATE,1) as TOTAL_RATE "
							+ "FROM GW_PRODUCT_STATUS "
							+ "WHERE WORK_SHOP_CODE LIKE ? "
							+ "AND (CONVERT(varchar(10), MAKE_DATE,112)=CONVERT(varchar(10), GETDATE()-1,112))");

			statement.setString(1, workShopCode);

			try {
				resultSet = statement.executeQuery();
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			while (resultSet.next()) {
				ManufactureStatus status = new ManufactureStatus();
				status.setWorkShopName(resultSet.getString("WORK_SHOP_NAME"));
				status.setItemName(resultSet.getString("ITEM_NAME"));
				status.setWkordQ(resultSet.getString("WKORD_Q"));
				status.setTimeRate(resultSet.getInt("TIME_RATE"));
				status.setTempn03(resultSet.getInt("TEMPN_03"));
				status.setGoodRate(resultSet.getInt("GOOD_RATE"));
				status.setTotalRate(resultSet.getInt("TOTAL_RATE"));

				list.add(status);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
				}
			}
		}
		return list;
	}

	public List<String> getMailUser(String workShopCode)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			connection = connectionMaker.makeConnection();

			statement = connection
					.prepareStatement("SELECT distinct(EMAIL_ADDR), WORK_SHOP_CODE "
							+ "FROM  WORKER_VIEW "
							+ "WHERE WORK_SHOP_CODE LIKE ? "
							+ "AND EMAIL_ADDR LIKE '%com%'");

			statement.setString(1, workShopCode);

			try {
				resultSet = statement.executeQuery();
			} catch (Exception e) {
			}

			while (resultSet.next()) {
				list.add(resultSet.getString("EMAIL_ADDR"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
				}
			}
		}
		return list;
	}
}
