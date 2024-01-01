package org.example.exam31;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "TenServlet", value = "/ten")
public class TenServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 브라우저가 response를 받았을 때 response의 타입(이미지, 텍스트 등)을 정의한다.
        // 텍스티인데, html 형태인 경우
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<h1>1-10까지 출력해보자!</h1>");
        for(int i = 1; i <= 10; i++){
            out.println(i + "<br>");
        }
        out.close();
    }

    public void destroy() {
    }
}