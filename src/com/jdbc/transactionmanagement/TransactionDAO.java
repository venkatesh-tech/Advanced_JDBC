package com.jdbc.transactionmanagement;

import java.sql.*;

public class TransactionDAO {

	public static void main(String[] args) {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venky1234@");
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);

			stmt.executeUpdate("update account set bal=bal-500 where accno=2");
			stmt.executeUpdate("update account set bal=bal+500 where accno=1");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	}
}
