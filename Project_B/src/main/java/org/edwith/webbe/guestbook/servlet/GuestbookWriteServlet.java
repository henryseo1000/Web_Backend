package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {
    GuestbookDao dao;
    final static long count = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        Long id = count + 1;
        Date regdate = new Date();

        Date sqldate = new java.sql.Date(regdate.getTime());

        Guestbook gb = new Guestbook(id, name, content, sqldate);
        System.out.println("doPost 실행됨");
        System.out.println(gb.toString());

        dao.addGuestbook(gb);
    }
}
