package com.jdbc.batch;

import java.sql.*;

public class BatchDAO {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venky1234@");
				Statement stmt = con.createStatement();) {

			stmt.addBatch("insert into account values(1,'clinton','bill',5000)");
			stmt.addBatch("insert into account values(2,'clinton','hillary',2000)"); // output will be "1" means one roe
																						// have been inserted

			int[] result = stmt.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
