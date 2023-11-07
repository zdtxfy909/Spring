package polymorphism02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//스프링 컨테이너 사용
		System.out.println("--- 스프링 컨테이너 구동전 ----");
		//1. 스프링 컨테이너 구동(스프링 설정 파일 읽어서)
		GenericXmlApplicationContext factory
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨테이너 사용 : 생성된 객체를 요청(lookup)
		System.out.println("--- tv 요청 사용 ----");
		TV tv = (TV)factory.getBean("tv2Lg"); 
		//id명이 tv인 것을 가져옴(직접요청)
		System.out.println("tv : " + tv);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		System.out.println("--- tv 요청(한번 더) 사용 ----");
		tv = (TV)factory.getBean("tv2Lg"); 
		System.out.println("tv : " + tv);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. 스프링 컨테이너 종료(close)
		factory.close();
	}
}
