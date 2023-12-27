package com.jdbcexam;

import com.jdbcexam.dao.RoleDao;
import com.jdbcexam.dto.Role;

public class JDBCExam {
    public static void main( String[] args )
    {
        Role role = new Role(500, "CTO");
        RoleDao rd= new RoleDao();

        int count = rd.insertRole(role);
        System.out.println(count);
    }
}
