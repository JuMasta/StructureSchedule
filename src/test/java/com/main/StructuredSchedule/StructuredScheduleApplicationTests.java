package com.main.StructuredSchedule;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.StructuredSchedule.util.JwtUtil;



@SpringBootTest
class StructuredScheduleApplicationTests {

	Logger logger = LoggerFactory.getLogger(StructuredScheduleApplicationTests.class);
	
	@Test
	void contextLoads() {
		
		JwtUtil jwtUtil = new JwtUtil();
		logger.info(jwtUtil.generateToken("nikbulat97@mail.ru"));
	}

}
