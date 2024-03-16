package kr.or.springtest.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Diexam02Application {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("setting.xml");

        // Bean에 등록해두었던 아이디를 이용해 객체를 불러올 수 있다.
        // resources 아래의 setting.xml을 이용
        Car car = (Car) ac.getBean("c");
        car.run();
    }
}
