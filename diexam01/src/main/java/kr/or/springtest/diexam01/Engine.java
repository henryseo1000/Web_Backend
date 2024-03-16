package kr.or.springtest.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public Engine() {
        System.out.println("Engine 객체 생성");
    }

    public void exec() {
        System.out.println("엔진이 동작합니다.");
    }
}
