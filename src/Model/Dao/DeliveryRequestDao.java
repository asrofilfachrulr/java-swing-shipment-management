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
			
			String query = "SELECT dr.*, c.name AS origin_name, c.metric AS origin_metric, c.name_abbr AS origin_name_abbr, c2.name AS dest_name, c2.metric AS dest_metric, c2.name_abbr AS dest_name_abbr " +
		               "FROM delivery_requests dr " +
		               "JOIN cities c ON dr.city_origin_id = c.id " +
		               "JOIN cities c2 ON dr.city_dest_id = c2.id " +
		               "WHERE customer_id = ? " +
		               "ORDER BY dr.request_time DESC;";

			
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
	            String originNameAbbr = rs.getString("origin_name_abbr");
	            int destId = rs.getInt("city_dest_id");
	            String destName = rs.getString("dest_name");
	            int destMetric = rs.getInt("dest_metric");
	            String destNameAbbr = rs.getString("dest_name_abbr");
	            
	            City originCity = new City(originName, originId, originMetric, originNameAbbr);
	            City destCity = new City(destName, destId, destMetric, destNameAbbr);
	            

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
	            
	            request.setPickupTime(pickupTime == null ? null : new Date(pickupTime.getTime()));
	            request.setPickupTimeEst(pickupTimeEst == null ? null : new Date(pickupTimeEst.getTime()));

	            requests.add(request);
	            System.out.println(request.toString());
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
	
	public List<DeliveryRequest> adminGetAll(int staffId) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<DeliveryRequest> requests = new ArrayList<>();
		
		try {
			conn = DBHelper.getDBConnection();
			
			String query = "SELECT dr.*, c.name AS origin_name, c.metric AS origin_metric, c.name_abbr AS origin_name_abbr, c2.name AS dest_name, c2.metric AS dest_metric, c2.name_abbr AS dest_name_abbr " +
		               "FROM delivery_requests dr " +
		               "JOIN cities c ON dr.city_origin_id = c.id " +
		               "JOIN cities c2 ON dr.city_dest_id = c2.id " +
		               "JOIN staff s ON dr.city_origin_id = s.office_city_id " +
		               "WHERE s.id = ? " +
		               "ORDER BY dr.request_time DESC;";

			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, staffId);
			
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
	            String originNameAbbr = rs.getString("origin_name_abbr");
	            int destId = rs.getInt("city_dest_id");
	            String destName = rs.getString("dest_name");
	            int destMetric = rs.getInt("dest_metric");
	            String destNameAbbr = rs.getString("dest_name_abbr");
	            
	            City originCity = new City(originName, originId, originMetric, originNameAbbr);
	            City destCity = new City(destName, destId, destMetric, destNameAbbr);
	            

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
	            
	            request.setPickupTime(pickupTime == null ? null : new Date(pickupTime.getTime()));
	            request.setPickupTimeEst(pickupTimeEst == null ? null : new Date(pickupTimeEst.getTime()));

	            requests.add(request);
	            System.out.println(request.toString());
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
	
	public void cancel(int id, int user_id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBHelper.getDBConnection();
			
			String query = "UPDATE delivery_requests SET is_canceled = 1 WHERE id = ? AND customer_id = ?";
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			stmt.setInt(2, user_id);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
	
	public void remove(int id, int user_id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBHelper.getDBConnection();
			
			String query = "DELETE FROM delivery_requests WHERE id = ? AND customer_id = ? AND pickup_time_est IS NULL";
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			stmt.setInt(2, user_id);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
	
	public void updatePickupEst(int id, Date time) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBHelper.getDBConnection();
			
			String query = "UPDATE FROM delivery_requests SET pickup_time_est = ? WHERE id = ?";
			stmt = conn.prepareStatement(query);
			
			stmt.setTimestamp(1, time != null ? new Timestamp(time.getTime()) : null);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
	
	public void updatePickup(int id, Date time) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBHelper.getDBConnection();
			
			String query = "UPDATE FROM delivery_requests SET pickup_time_ = ? WHERE id = ?";
			stmt = conn.prepareStatement(query);
			
			stmt.setTimestamp(1, time != null ? new Timestamp(time.getTime()) : null);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		} finally {

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
}
