package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessCardManagerDao {
    String url = "jdbc:mysql://localhost/ddl";
    String user = "root";
    String password = "";

    public List<BusinessCard> searchBusinessCard(String keyword){
	    // 구현하세요.
        List<BusinessCard> card_list = new ArrayList<>();
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select * from info where name like ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String company = rs.getString("company");
                Date date = rs.getDate("date");

                BusinessCard card = new BusinessCard(name, tel, company);
                card.setCreateDate(date);

                card_list.add(card); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return card_list;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard){
	    // 구현하세요.
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String name = businessCard.getName();
            String tel = businessCard.getPhone();
            String company = businessCard.getCompanyName();
            Date date = businessCard.getCreateDate();

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            String sql = "insert into info(name, tel, company, date) values(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, tel);
            ps.setString(3, company);
            ps.setDate(4, sqlDate);

            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return businessCard;
    }

    public List<BusinessCard> printBusinessCardList(){
        List<BusinessCard> card_list = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select * from info";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String company = rs.getString("company");
                Date date = rs.getDate("date");

                BusinessCard card = new BusinessCard(name, tel, company);
                card.setCreateDate(date);

                card_list.add(card); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
                System.out.println(card.toString());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return card_list;
    }
}
