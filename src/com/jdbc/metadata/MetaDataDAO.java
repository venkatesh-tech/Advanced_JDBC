package com.jdbc.metadata;

import java.sql.*;

public class MetaDataDAO {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venky1234@");
				Statement stmt = con.createStatement();) {

			ResultSet resultSet = stmt.executeQuery("select * from account");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				System.out.println(resultSetMetaData.getColumnName(i));
				System.out.println(resultSetMetaData.getColumnTypeName(i));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
