package Model.Dao;

import Helper.DBHelper;
import Helper.KeyHelper;
import Model.Staff;
import Model.StaffPackageManagement;

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

    public Staff getLoggedStaff(String username) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Staff staff = null;

        try {
            conn = DBHelper.getDBConnection();

            String query = "SELECT staff.id, staff.email, staff.phone, staff.fullname, staff.username, cities.name_abbr AS office_city, office_types.name_abbr AS office_type FROM staff JOIN cities ON staff.office_city_id = cities.id JOIN office_types ON staff.office_type_id = office_types.id WHERE username = ?";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            rs = stmt.executeQuery();
            if(rs.next()){
                String email, phone, fullname, username1, officeType, officeCity;
                int id;
                StaffPackageManagement staffPackageManagement = new StaffPackageManagement();

                id = rs.getInt("id");
                email = rs.getString("email");
                phone = rs.getString("phone");
                fullname = rs.getString("fullname");
                username1 = rs.getString("username");
                officeType = rs.getString("office_type");
                officeCity = rs.getString("office_city");

                staff = new Staff(
                        email,
                        phone,
                        fullname,
                        id,
                        username1,
                        staffPackageManagement,
                        officeCity,
                        officeType
                );
            }
        } catch (Exception e){
            throw new Exception(e);
        } finally {
            if(rs != null)
                rs.close();

            if(stmt != null)
                stmt.close();

            if(conn != null)
                conn.close();
        }

        return staff;
    }

}
