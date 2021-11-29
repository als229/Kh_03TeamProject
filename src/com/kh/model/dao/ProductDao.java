package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Product;

public class ProductDao {
	
	public ArrayList<Product> selectByProductName(String keyword,Connection conn) {
		ArrayList <Product> list = new ArrayList<>();
		ResultSet rSet = null;
		Statement stmt = null;
		
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE '%" + keyword + "%'";
		//SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE '%삼%';
		try {
			stmt = conn.createStatement();
			rSet = stmt.executeQuery(sql);
			
			while(rSet.next()) {
			Product p = new Product(
					rSet.getString("PRODUCT_ID")
					,rSet.getString("PRODUCT_NAME")
					,rSet.getInt("PRICE")
					,rSet.getString("DESCRIPTION")
					,rSet.getInt("STOCK")
					);
			list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				close(conn);
				close(stmt);
		}
		return list ;
	}

	public ArrayList<Product> selectAll(Connection conn) {
		
		ArrayList<Product> list = new ArrayList<>();
		ResultSet rSet = null;
		Statement stmt = null;
		
		String sql = "SELECT * FROM PRODUCT";
				
		try {
			stmt = conn.createStatement();
			rSet = stmt.executeQuery(sql);
			
			while(rSet.next()) {
				Product p = new Product(rSet.getString("PRODUCT_ID")
						,rSet.getString("PRODUCT_NAME")
						,rSet.getInt("PRICE")
						,rSet.getString("DESCRIPTION")
						,rSet.getInt("STOCK"));
				list.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rSet);
		}
		return list;
	}

	public int insertProduct(String product_Id, String product_Name, int price, String description, int stock,Connection conn) {

		Statement stmt = null;
		int result = 0;
		
		String sql = "INSERT INTO PRODUCT VALUES ( '" + product_Id+ "','"
				 + product_Name+ "','" 
				 + price + "','" 
				 + description + "','" 
				 + stock + "')" ;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	public int updateProduct(String product_id, int price, String description, int stock ,Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		String sql = "UPDATE PRODUCT SET PRICE = '"
				+ price +"', DESCRIPTION = '"
				+ description +"', STOCK = '"
				+ stock+"' WHERE PRODUCT_ID = '"
				+ product_id + "'";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		
				
		return result;
	}

	public int deleteProduct(String product_Id, Connection conn) {

		int result = 0;
		Statement stmt = null;
		
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = '" + product_Id + "'";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		return result;
	}
	
	
	
	
}
