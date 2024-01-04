package org.example.exam31;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "LifeCycleServlet", value = "/lifecycle")
public class LifeCycleServlet extends HttpServlet {
    private String message;

    public LifeCycleServlet() {
        System.out.println("생성자 호출");
    }

    public void init() {
        System.out.println("init 메서드 호출");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 메서드 호출");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        //아래 url로 post 요청을 보내고, name을 입력 받아 보내도록 함
        out.println("<form method='post' action='/exam31_war_exploded/lifecycle'>");
        out.println("name : <input type='text' name='name'><br>");
        out.println("<input type='submit' value='ok'><br>");
        out.println("</form>");

        // 헤더 이름 값에 대한 리스트를 가져온다.
        Enumeration<String> headerNames = request.getHeaderNames();
        out.println("{");

        // 리스트에 있는 항목들을 뽑아낸다.
        while(headerNames.hasMoreElements()){
            // 리스트의 이름값을 뽑아냄
            String headerName = headerNames.nextElement();

            // 리스트의 해당 이름에 대한 값을 뽑아냄
            String headerValue = request.getHeader(headerName);
            out.println("\"" + headerName + "\" : " + headerValue + ", <br>");
        }
        out.println("}");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost 메서드 호출");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        out.println("<h1> hello " + name + "</h1>");
        out.close();
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("service 호출");
//    }

    public void destroy() {
        System.out.println("destroy 호출");
    }
}