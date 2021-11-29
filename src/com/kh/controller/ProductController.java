package com.kh.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.kh.model.vo.Product;
import com.kh.service.ProductService;
import com.kh.view.ProductView;

public class ProductController {

	public void selectByProductName(String keyword) {
		
		ArrayList <Product> list = new ArrayList<>();
		list = new ProductService().selectByProductName(keyword);

		if(list.isEmpty()) {
			System.out.println("그런 제품 없는데용?");
		}else {
			for(int i = 0; i < list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}

	public void selectAll() {
		
		ArrayList<Product> list = new ProductService().selectAll();
		
		if(list.isEmpty()) {
			new ProductView().displayFail("조회할 내용이 없습니다.");
		}else {
			new ProductView().displaySuccess("요청하신 조회 결과입니다.");
			new ProductView().displayList(list);
		}
		
	}

	public void insertProduct(String product_Id, String product_Name, int price, String description, int stock) {
		
		int result = new ProductService().insertProduct(product_Id,product_Name,price,description,stock);
		
		if(result>0) {
			new ProductView().displaySuccess("상품 추가 성공!");
		}else {
			new ProductView().displayFail("상품 추가 실패...!");
			
		}
		
	}

	public void updateProduct(String product_id,int price, String description, int stock) {

		int result = new ProductService().updateProduct(product_id,price,description,stock);
		
		if(result > 0) {
			new ProductView().displaySuccess("상품 수정 성공!");
		}else
		new ProductView().displayFail("상품 수정 실패...!");
		
	}

	public void deleteProduct(String product_Id) {
		
		int result = new ProductService().deleteProduct(product_Id);
		
		if(result > 0) {
			new ProductView().displaySuccess("삭제에 성공했습니다.");
		}else {
			new ProductView().displayFail("삭제에 실패했습니다...!");
		}
		
	}
}
