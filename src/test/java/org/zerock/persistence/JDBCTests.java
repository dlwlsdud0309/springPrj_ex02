package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j //Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성, 즉 로그 객체를 생성
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test //JUnit에서 테스트 대상을 표시하는 어노테이션, junit에서 해당 메서드가 JUnit 상에서 단위테스트 대상인지 알려줌
	public void testConnection() {
		
		try(Connection con =
			DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"book_ex",
					"book_ex")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
