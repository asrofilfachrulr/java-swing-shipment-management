package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Helper.DBHelper;
import Model.DeliveryRequest;
import Model.PackageDelivery;

public class PackageDeliveryDao {
	public List<PackageDelivery> getByOwner(int user_id) {
		return null;
	}
	
	public List<PackageDelivery> getByStaff(int staff_id) {
		return null;
	}
	
	public PackageDelivery getById(int id) {
		return null;
	}
	
	public PackageDelivery getByDeliveryReq(DeliveryRequest req) throws Exception {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PackageDelivery delivery = null;
        
        try {
			conn = DBHelper.getDBConnection();
			
			String query =  "SELECT * FROM package_deliveries WHERE delivery_req_id = ? LIMIT 1";
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, req.getId());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id, staffId;
				String status;
				
				id = rs.getInt("id");
				status = rs.getString("status");
				staffId = rs.getInt("staff_id");
				
				delivery = new PackageDelivery(req, id, status, staffId, null);
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
        
        return delivery;
	}
}
