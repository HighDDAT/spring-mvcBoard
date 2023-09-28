package com.spring.mvcboard.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml")
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testConnection() throws Exception {
		long start = System.currentTimeMillis();
		
		for(int i=0; i<100; i++) {
		try(Connection con = ds.getConnection()) {
			log.info(con);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
	}
		long end = System.currentTimeMillis();
		
		log.info("======================");
		
		log.info(end-start);
}
	
	@Test
	public void testConnection2() {
		
		try(SqlSession session = sessionFactory.openSession();
				Connection con = session.getConnection()) {
			
			log.info("session : " + session);
			log.info("con : " + con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testConnection3() throws Exception {
        try(Connection connection = ds.getConnection()) {
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}