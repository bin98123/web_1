package database;

import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	String INSERT_USERS_SQL = "INSERT INTO user" + "  (uid ,uname ,uigname, upass, uemail, urank, uscore) VALUES "
			+ " (?, ?, ?, ?, ?,?,?);";

//	int result = 0;

	public int registerUser(UserDetails user) throws ClassNotFoundException, SQLException {
		int result = 0;
		Class.forName("org.hsqldb.jdbcDriver");
//		Class.forName("org.hsqldb.jdbc.jdbcDriver");
//		Class.forName("org.hsqldb.jdbc.JDBCDriver");
//		"org.hsqldb.jdbc.jdbcDriver"
//		"org.hsqldb.jdbc.JDBCDriver"
//		"org.hsqldb.jdbcDriver"
//		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:///C:/Users/user/Desktop/data/test", "SA",
		// path: C:\\Users\\user\\Desktop\Desktop\For Student\Exercises\Hsqldb
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", ""))
//		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\user\\Downloads\\Compressed\\hsqldb-2.5.1\\hsqldb\\data\test", "SA", "");
//				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL))

		{
			// Step 3: Execute the query or update query
			try {
				Statement statement = connection.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String uName = user.getUserName();
			String uIGName = user.getUserNameIG();
			String uEmail = user.getUserEmail();
			try (PreparedStatement checkAccountExists = connection
//					.prepareStatement("select 1,2,4 from user where UNAME=? and UIGNAME=? and UEMAIL=?")) {
					.prepareStatement("select 1 from user where UNAME = ?")) {
				checkAccountExists.setString(1, uName);
//				checkAccountExists.setString(2, uIGName);
				try (PreparedStatement checkNameAccountExists = connection
						.prepareStatement("select 1 from user where UIGNAME=?")) {
					checkNameAccountExists.setString(1, uIGName);
					try (PreparedStatement checkEmailAccountExists = connection
							.prepareStatement("select 1 from user where UEMAIL=?")) {
						checkEmailAccountExists.setString(1, uEmail);

						try (ResultSet rs = checkAccountExists.executeQuery()) {
							if (!rs.next()) {
								try (ResultSet rs1 = checkNameAccountExists.executeQuery()) {
									if (!rs1.next()) {
										try (ResultSet rs2 = checkEmailAccountExists.executeQuery()) {

											if (rs2.next()) {
											} else {

												try (PreparedStatement insert = connection
														.prepareStatement(INSERT_USERS_SQL)) {
													insert.setString(1, user.getUserID());
													insert.setString(2, user.getUserName());
													insert.setString(3, user.getUserNameIG());
													insert.setString(4, user.getUserPassword());
													insert.setString(5, user.getUserEmail());
													insert.setInt(6, user.getUserRank());
													insert.setInt(7, user.getUserScore());
													insert.executeUpdate();
													result = insert.executeUpdate();

												}

											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;

//			int x = statement.executeUpdate(INSERT_USERS_SQL);
//			if(x=0) {
//				JOptionPane.showMessageDialog(parentComponent, message);
//			}
//				System.out.println(preparedStatement);
//				String uName;
//				
//				if (user.getUserEmail().equals(rs.getString(4)) || user.getUserName().equals(rs.getString(1))
//						|| user.getUserNameIG().equals(rs.getString(2))) {
//				}
//			}
//				catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//							}} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		} catch (SQLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
	}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		} catch (SQLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//	}}
////		}
//	catch(SQLException e3)
//	{
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}

//	}

//	public boolean existUser(String userName, String userIGName, String userEmail) {
//		Connection connection;
//		try {
//			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", "");
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select *from user");
//			while (rs.next()) {
//				if (userEmail.equals(rs.getString(4)) || userName.equals(rs.getString(1))
//						|| userIGName.equals(rs.getString(2))) {
//					System.out.println(rs.getString(1));
//					System.out.println(rs.getString(2));
//					System.out.println(rs.getString(4));
//					return true;
//				}
//			}

//	}catch(SQLException e)
//	{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}return false;
//	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public boolean checkUpdate() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", "");
		PreparedStatement stmt = connection.prepareStatement(INSERT_USERS_SQL);
		int i = stmt.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
}
