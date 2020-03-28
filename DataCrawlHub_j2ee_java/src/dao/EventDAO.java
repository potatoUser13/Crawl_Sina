package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bean.Event;

public class EventDAO {
	
	public EventDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
    }
	
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/crawldata?useSSL=false&serverTimezone=UTC",
				"root", "wy654383369");
    }
 
    
    
    
    public int getTotal() {
		int total = 0;
		try (Connection c = getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from crawlSina";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return total;
	}
	
	public void add(Event event) {
		  
        String sql = "insert into bridge values(null,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, event.id);
            ps.setString(2, event.name);
            ps.setString(3, event.hot);
       
            
  
            ps.execute();
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                event.id = id;
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }

	public Event get(int id) {
		Event event = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from crawlSina where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                event = new Event();
                String name = rs.getString(2);
                String hot = rs.getString(3);
          
                
                event.name = name;
                event.hot = hot;
               
                event.id = id;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return event;
    }

	public void update(Event event) {
		  
        String sql = "update event set name= ?, hot = ?  where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, event.name);
            ps.setString(2, event.hot);
            ps.setInt(3, event.id);
  
            ps.execute();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }

	public void delete(int id) {
		  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from crawlSina where id = " + id;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }

	public List<Event> list() {
        return list(0, Short.MAX_VALUE);
    }

	public List<Event> list(int start, int count) {
        List<Event> events = new ArrayList<Event>();
  
        String sql = "select * from crawlSina order by id asc limit ?,? ";
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
            	Event event = new Event();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String hot = rs.getString(3);
                String time = rs.getString(5);
                
                

                event.id = id;
                event.name = name;
                event.hot = hot;
                event.time =time;
                
                
                events.add(event);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return events;
    }
    
    
    
    
    
}
