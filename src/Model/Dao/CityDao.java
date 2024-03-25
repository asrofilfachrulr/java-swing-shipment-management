package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Helper.DBHelper;
import Model.City;

public class CityDao {
	public List<City> getCitiesAndId() throws Exception{
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<City> cities = new ArrayList<City>();
        
        try {
			conn = DBHelper.getDBConnection();
			
			String query = "SELECT id, name, metric FROM cities";
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				City city = new City(
						rs.getString("name"), 
						rs.getInt("id"), 
						rs.getInt("metric")
					);
				
				System.out.println(city.toString());
				
				cities.add(city);	
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new Exception(e);
		} finally {
            if(rs != null)
                rs.close();

            if(stmt != null)
                stmt.close();

            if(conn != null)
                conn.close();
        }
        
        return cities;
	}

}
