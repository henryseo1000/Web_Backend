package org.example.exam31;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet", value = "/info")
public class InfoServlet extends HttpServlet {
    private String message;

    public InfoServlet() {
        System.out.println("생성자 호출");
    }

    public void init() {
        System.out.println("init 메서드 호출");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Parameter Test</title></head>");
        out.println("<body>");

        // url에 파라메터로 값을 넘겨줄 수 있다 -> 이는 /parameter?name=서호준&age=22 식으로 표현 가능
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getContextPath();
        String remoteAddr = request.getRemoteAddr();

        out.println("uri : " + uri + "<br>");
        out.println("url : " + url + "<br>");
        out.println("contextPath : " + contextPath + "<br>");
        out.println("remoteAddr : " + remoteAddr + "<br>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("service 호출");
//    }

    public void destroy() {
        System.out.println("destroy 호출");
    }
}