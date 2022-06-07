package com.springboot.singletion;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void StatefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		int userPrice1 = statefulService1.order("userA", 10000);
		int userPrice2 = statefulService2.order("userA", 20000);
		
		//ThreadA : 사용자A 주문 금액 조회
//		int price = statefulService1.getPrice();
		System.out.println("price = " + userPrice1);
		
//		assertThat(statefulService1.getPrice()).isEqualTo(20000);
	}
	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
