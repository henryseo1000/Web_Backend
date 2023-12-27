import javax.management.relation.Role;

import com.mysql.jdbc.Connection;

@Getter
@Setter
public class RoleDao{
    private static String dburl = "jdbc:mysql://localhost:3306/hello";
	private static String dbUser = "root";
	private static String dbpasswd = "";

    public Role getRole(Integer roleId){
        Role role = null;
        Connection conn = null;
        PreparedStatement ps = null;
		ResultSet rs = null;

        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
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
}