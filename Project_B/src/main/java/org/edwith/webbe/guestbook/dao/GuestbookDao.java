package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
    private static String dburl = "jdbc:mysql://192.168.0.34:3306/testdb";
    private static String dbUser = "newuser";
    private static String dbpasswd = "1";

    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

            String query = "select * from guestbook";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String content = rs.getString("content");
                Date regdate = rs.getDate("regdate");

                Guestbook gb = new Guestbook(id, name, content, regdate);
                gb.setRegdate(regdate);

                list.add(gb);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public void addGuestbook(Guestbook guestbook){
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

            String query = "insert into guestbook (id, name, content, regdate) values (?, ?, ?, ?)";
            ps = conn.prepareStatement(query);

            ps.setLong(1, guestbook.getId());
            ps.setString(2, guestbook.getName());
            ps.setString(3, guestbook.getContent());
            ps.setDate(4, new java.sql.Date(guestbook.getRegdate().getTime()));

            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ps != null){
                try{
                    ps.close();
                }catch (Exception e){

                }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch (Exception e){

                }
            }
        }
    }
}
