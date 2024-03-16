package kr.or.springtest.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Engine v8;

    public Car(){
        System.out.println("Car 객체 생성");
    }

    public void setEngine(Engine e){
        this.v8 = e;
    }

    public void run(){
        System.out.println("Engine 이용 - 달리는 중");
        v8.exec();
    }
}
