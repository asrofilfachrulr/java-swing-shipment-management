package Model.Dao;

import Helper.DBHelper;
import Helper.KeyHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDao {
    public boolean verifyLogin(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean compareResult = false;

        try {
            conn = DBHelper.getDBConnection();


            String query = "SELECT password FROM staff WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            rs = stmt.executeQuery();
            if(rs.next()){
                String hashedPw = rs.getString("password");

                compareResult = KeyHelper.hashCompare(password,hashedPw);
            }
        }
        catch(Exception err) {
            if(err instanceof SQLException){
                throw new SQLException(err);
            } else {
                System.out.println(err.getLocalizedMessage());
            }
        }
        finally {
            if(rs != null)
                rs.close();

            if(stmt != null)
                stmt.close();

            if(conn != null)
                conn.close();
        }

        return compareResult;
    }
}
