package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlGuiDao implements SQLGUIDAOInterface {
	 private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/companydb";

		
		public ArrayList<ArrayList> getQuery (String qry) { 
			ArrayList<ArrayList> arraylistquery = new ArrayList<>(); 
			
			
			
			try {
				Class.forName(DRIVER_CLASS_NAME);
				Connection conn = DriverManager.getConnection(URL, "student", "student"); 
				Statement statement = conn.createStatement(); 
				ResultSet rs = statement.executeQuery(qry); 
				ResultSetMetaData md = rs.getMetaData(); 
				
				ArrayList<String> list = new ArrayList<> (); 
				for(int i=1; i <= md.getColumnCount(); i++ ) { 
					list.add(md.getColumnName(i)); 
				}
				
				arraylistquery.add(list); 
				
				int x = md.getColumnCount();
				while (rs.next()) { 
					ArrayList<String> row = new ArrayList<>(); 
					for (int i=1; i <= x; i++) { 
						row.add(rs.getString(i)); 
					}
					arraylistquery.add(row); 
					System.out.println(row);
				}
				
				rs.close(); 
				statement.close(); 
				conn.close(); 
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return arraylistquery; 
		}

	}


