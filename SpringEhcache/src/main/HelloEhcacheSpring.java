package main;

import java.util.List;

import manager.PersonManagerImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings({"unchecked"})
public class HelloEhcacheSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PersonManagerImpl personManager = (PersonManagerImpl) context.getBean("personManager");
		
		for(int i=0;i<5;i++) {
			showPersonsInfo(personManager);
		}
	}
	private static void showPersonsInfo(PersonManagerImpl personManager) {
		List<String> persons = personManager.getList();
		
		for(String person : persons) {
			System.out.println(person);
		}
	}
}
