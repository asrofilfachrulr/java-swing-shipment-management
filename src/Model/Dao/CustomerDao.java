package Model.Dao;

import Helper.DBHelper;
import Helper.KeyHelper;
import Model.Customer;
import Model.CustomerPackageManagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    public Customer getLoggedCustomer(String username) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            conn = DBHelper.getDBConnection();

            String query = "SELECT id, email, phone, fullname, return_address, username FROM customers WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            rs = stmt.executeQuery();
            if(rs.next()){
                String id, email, phone, fullname, returnAddress, username1;
                CustomerPackageManagement customerPackageManagement = new CustomerPackageManagement();

                id = rs.getString("id");
                email = rs.getString("email");
                phone = rs.getString("phone");
                fullname = rs.getString("fullname");
                returnAddress = rs.getString("return_address");
                username1 = rs.getString("username");

                customer = new Customer(
                        email,
                        phone,
                        fullname,
                        id,
                        username1,
                        returnAddress,
                        customerPackageManagement
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

        return customer;
    }

    public boolean verifyLogin(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean compareResult = false;

        try {
            conn = DBHelper.getDBConnection();

            String query = "SELECT password FROM customers WHERE username = ?";
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
