package com.windfarm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.windfarm.service.WindService;



public class DBManager {
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://localhost:3306/import_js";
	
    
    public static Connection DBConnection(){
    	Connection con = null;
    	try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("无法连接数据库" ); 
            e.printStackTrace();
        }
		return con;
    }
    
    // 增删修改
    public int insertData(String sql,int farmID, Map<String, List<String>> dataMap) {
    	
    	
        int a = 0;
        Connection conn = DBConnection();
        try {
        	WindService.isExistInsertValue(farmID, dataMap);//判断是否存在历史数据
            PreparedStatement pst = conn.prepareStatement(sql);
            if(dataMap.size()>0){
            	int count = 1;
            	
            	for(Map.Entry<String, List<String>>entry:dataMap.entrySet()){            		
            		String key = entry.getKey();
            		pst.setInt(count++,farmID);
            		pst.setString(count++, key);
            		List<String> dataList = entry.getValue();
            		for(String data : dataList){
            			if(data.length() == 0){
            				data = "0";
            			}
            			pst.setString(count++, data);
            		}
            		System.out.println(count);
            		count = 1;
            		a = pst.executeUpdate();
            	}
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
}

