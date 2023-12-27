package com.jdbcexam;

import com.jdbcexam.dao.RoleDao;

public class JDBCExam2 {
    public static void main(String[] args) {
        //삭제 테스트
        int roleId = 500;

        RoleDao dao = new RoleDao();
        int deleteCount = dao.deleteRole(roleId);

        System.out.println(deleteCount);
    }
}
