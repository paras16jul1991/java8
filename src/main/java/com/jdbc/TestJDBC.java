package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("");
		CallableStatement call = con.prepareCall("");
	//	call.setInt(parameterIndex, x);
		
	//	call.registerOutParameter(parameterIndex, sqlType);
	//	call.registerOutParameter(2, OracleTypes.CURSOR);
		//call.getString(0);
	}
}
