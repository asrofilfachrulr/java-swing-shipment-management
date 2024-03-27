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
import Model.PackageDelivery;
import Model.PackageHistory;

public class PackageHistoryDao {
	public List<PackageHistory> getByPackageDelivery(PackageDelivery delivery) throws Exception {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PackageHistory> histories = new ArrayList<>();
        
        try {
			conn = DBHelper.getDBConnection();
			
			String query = "SELECT * FROM package_histories WHERE package_delivery_id = ? ORDER BY time DESC";
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id, staff_id;
				String status, location, description;
				Timestamp time;
				
				id = rs.getInt("id");
				time = rs.getTimestamp("time");
				status = rs.getString("status");
				location = rs.getString("location");
				description = rs.getString("description");
				staff_id = rs.getInt("staff_id");
				
				PackageHistory history = new PackageHistory(id, new Date(time.getTime()), status, location, description, staff_id);
				histories.add(history);
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
        
        return histories;
	}
}
