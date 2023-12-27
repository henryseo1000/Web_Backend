package com.jdbcexam.dao;

import com.jdbcexam.dto.Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/hello";
	private static String dbUser = "root";
	private static String dbpasswd = "";

	public int deleteRole(Integer roleId) {
		int deleteCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );

			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );

			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1,  roleId);

			deleteCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if

			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally

		return deleteCount;
	}

	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public Role getRoleById(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			/**
			 * jdbc.Driver에 대한 패키지 이름이 수정되면서 "com.mysql.jdbc.Driver"가 아니라 아래 클래스명으로 시도해야 한다.
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

			/**
			 * 아래와 같이 물음표가 존재하는 쿼리는 완전한 쿼리가 아니기 때문에 반드시 물음표에 값을 바인딩하는 과정이 필요하다.
			 */
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);

			/**
			 * 현재는 아래 코드가 그 물음표에 바인딩하는 역할을 담당하고 있다.	1은 물음표의 순서를 생각하면 된다.
			 */
			ps.setInt(1, roleId);
			rs = ps.executeQuery();

			if (rs.next()) {
				String description = rs.getString(1);
				int id = rs.getInt("role_id");
				role = new Role(id, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role;
	}

	public int insertRole(Role role){
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

			String query = "insert into role (role_id, description) values (?, ?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			count = ps.executeUpdate();
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
		return count;
	}
}