package org.example.exam31;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AppScopeServlet2", value = "/AppScope2")
public class AppScopeServlet2 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 브라우저가 response를 받았을 때 response의 타입(이미지, 텍스트 등)을 정의한다.
        // 텍스트인데, html 형태인 경우
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        ServletContext application = getServletContext();

        try {
            // Application 객체로부터 value라는 값을 가져온다.
            // 단, AppScope1이 실행되지 않았다면, value 값이 존재하지 않을 것이므로 예외 처리가 필요할 것이다.
            int value = (int) application.getAttribute("value");
            value++;

            // application scope에 value = 1이라는 값을 맡긴다.
            application.setAttribute("value", value);

            out.println("<h1>value : " + value + "</h1>");
        } catch(Exception e){
            out.println("value의 값이 설정되지 않았습니다.");
        }
    }

    public void destroy() {
    }
}