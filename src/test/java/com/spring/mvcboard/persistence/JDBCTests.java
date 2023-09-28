package com.spring.mvcboard.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/web02";
	private static final String USER = "web02";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try (Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection2()throws Exception {
		
		Class clz = Class.forName("org.mariadb.jdbc.Driver");
		
		long start = System.currentTimeMillis();
		for(int i=0; i<100; i++) {
		
		Connection con = 
					DriverManager.getConnection(
							"jdbc:mariadb://localhost:3306/web02",
							"web02",
							"1234");
		log.info(clz);
		
		con.close();
		
		}
		long end = System.currentTimeMillis();
		log.info("======================");
		
		log.info(end-start);
	}
}