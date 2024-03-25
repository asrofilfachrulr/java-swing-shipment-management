package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import Helper.DBHelper;
import Model.DeliveryRequest;

public class DeliveryRequestDao {
	public void add(DeliveryRequest req) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DBHelper.getDBConnection();
			
			String insertQuery = "INSERT INTO delivery_requests " +
                    "(sender_name, sender_phone, sender_address, " +
                    "recipient_name, recipient_phone, recipient_address, " +
                    "weight, is_fragile, description, cost, " +
                    "request_time, customer_id, city_origin_id, city_dest_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(insertQuery);
			
			stmt.setString(1, req.getSenderName());
			stmt.setString(2, req.getSenderPhone());
			stmt.setString(3, req.getSenderAddress());
			stmt.setString(4, req.getRecipientName());
			stmt.setString(5, req.getRecipientPhone());
			stmt.setString(6, req.getRecipientAddress());
			stmt.setFloat(7, req.getWeight());
			stmt.setBoolean(8, req.getIsFragile());
			stmt.setString(9, req.getStuffDesc());
			stmt.setFloat(10, req.getCost());
			stmt.setTimestamp(11, new Timestamp(req.getTime().getTime()));
			stmt.setInt(12, req.getCustomerId());
			stmt.setInt(13, req.getOriginCity().getId());
			stmt.setInt(14, req.getDestCity().getId());
	
			System.out.println(stmt.toString());

			stmt.execute();
			
		} catch (Exception e) {
			if (e instanceof SQLException) {
				throw new SQLException(e);
			} else {
				System.out.println(e.getLocalizedMessage());
			}
		} finally {
			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
}
