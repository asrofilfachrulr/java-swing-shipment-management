package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Helper.DBHelper;
import Model.City;
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
	
	public List<DeliveryRequest> getAll(int userId) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<DeliveryRequest> requests = new ArrayList<>();
		
		try {
			conn = DBHelper.getDBConnection();
			
			String query = "select dr.*, c.name origin_name, c.metric origin_metric, c2.name dest_name, c2.metric dest_metric from delivery_requests dr \r\n"
					+ "	join cities c\r\n"
					+ "	on dr.city_origin_id =  c.id \r\n"
					+ "	join cities c2 \r\n"
					+ "	on dr.city_dest_id = c2.id\r\n"
					+ "	where customer_id = ?;";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, userId);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
	            String senderName = rs.getString("sender_name");
	            String senderPhone = rs.getString("sender_phone");
	            String senderAddress = rs.getString("sender_address");
	            String recipientName = rs.getString("recipient_name");
	            String recipientPhone = rs.getString("recipient_phone");
	            String recipientAddress = rs.getString("recipient_address");
	            float weight = rs.getFloat("weight");
	            boolean isFragile = rs.getBoolean("is_fragile");
	            String description = rs.getString("description");
	            float cost = rs.getFloat("cost");
	            Timestamp requestTime = rs.getTimestamp("request_time");
	            Timestamp pickupTime = rs.getTimestamp("pickup_time");
	            Timestamp pickupTimeEst = rs.getTimestamp("pickup_time_est");
	            int customerId = rs.getInt("customer_id");
	            boolean isCanceled = rs.getBoolean("is_canceled");
	            int originId = rs.getInt("city_origin_id");
	            String originName = rs.getString("origin_name");
	            int originMetric = rs.getInt("origin_metric");
	            int destId = rs.getInt("city_dest_id");
	            String destName = rs.getString("dest_name");
	            int destMetric = rs.getInt("dest_metric");
	            
	            City originCity = new City(originName, originId, originMetric);
	            City destCity = new City(destName, destId, destMetric);
	            

	            DeliveryRequest request = new DeliveryRequest(
	            		senderName, 
	            		senderPhone, 
	            		senderAddress, 
	            		recipientName, 
	            		recipientPhone, 
	            		recipientAddress, 
	            		weight, 
	            		isFragile, 
	            		description, 
	            		cost, 
	            		new Date(requestTime.getTime()), 
	            		originCity, 
	            		destCity
	            );
	            request.setId(id);
	            request.setCustomerId(customerId);
	            request.setCanceled(isCanceled);
	            request.setPickupTime(new Date(pickupTime.getTime()));
	            request.setPickupTimeEst(new Date(pickupTimeEst.getTime()));

	            requests.add(request);
			}
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (rs != null)
				rs.close();
			
			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
		
		return requests;
	}
}
