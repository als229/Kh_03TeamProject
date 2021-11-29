package com.kh.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.kh.common.JDBCTemplate.*;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class ProductService {

	public ArrayList<Product> selectByProductName(String keyword) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectByProductName(keyword, conn);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectAll() {
		
		Connection conn = getConnection();
		
		ArrayList <Product> list = new ProductDao().selectAll(conn);
		
		close(conn);
		
		return list;
	}

	public int insertProduct(String product_Id, String product_Name, int price, String description, int stock) {
		Connection conn = getConnection();
		
		int result = new ProductDao().insertProduct(product_Id,product_Name,price,description,stock,conn);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int updateProduct(String product_id,int price, String description, int stock) {
		Connection conn = getConnection();
		
		int result = new ProductDao().updateProduct(product_id,price,description,stock,conn);
		
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteProduct(String product_Id) {
		Connection conn = getConnection();
		int result = new ProductDao().deleteProduct(product_Id, conn);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
