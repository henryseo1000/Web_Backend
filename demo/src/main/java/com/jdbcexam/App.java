package com.jdbcexam;

import com.jdbcexam.dao.RoleDao;
import com.jdbcexam.dto.Role;

public class App 
{
    public static void main( String[] args )
    {
        RoleDao dao = new RoleDao();
		Role role = dao.getRoleById(100);
		System.out.println(role);
    }
}
