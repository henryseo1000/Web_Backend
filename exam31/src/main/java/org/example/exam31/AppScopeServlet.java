package org.example.exam31;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AppScopeServlet", value = "/AppScope")
public class AppScopeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 브라우저가 response를 받았을 때 response의 타입(이미지, 텍스트 등)을 정의한다.
        // 텍스티인데, html 형태인 경우
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        ServletContext application = getServletContext();

        int value = 1;

        // application scope에 value = 1이라는 값을 맡긴다.
        application.setAttribute("value", 1);

        out.println("<h1>value : " + value + "</h1>");
    }

    public void destroy() {
    }
}