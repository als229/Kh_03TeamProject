package com.kh.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.ProductController;

public class ProductView {
	private Scanner sc = new Scanner(System.in);

	public void MainMenu() {
		while (true) {
			System.out.println("메뉴 구성");
			System.out.println("1. 상품 전체 조회하기");
			System.out.println("2. 상품 추가 하기");
			System.out.println("3. 상품명 검색하기(키워드)");
			System.out.println("4. 상품 정보 수정 하기(id로 조회)");
			System.out.println("5. 상품 삭제 하기(id로 조회)");
			System.out.println("0. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");

			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				selectAll();
				break;
			case 2:
				insertProduct();
				break;
			case 3:
				selectByProductName();
				break;
			case 4:
				updateProduct();
				break;
			case 5:
				deleteProduct();
				break;
			case 0:
				System.out.println("시스템을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;

			}
		}
	}

	public void deleteProduct() {
		System.out.println("삭제하기 메뉴입니다.");
		System.out.println("삭제하고 싶은 상품 ID를 입력해 주세용");
		System.out.print("상품 ID : ");
		String product_Id = sc.nextLine();
		
		new ProductController().deleteProduct(product_Id);
		
	}

	public void updateProduct() {
		System.out.println("상품 수정하기 입니당");
		System.out.println("수정하고 싶은 상품 id를 입력해 주세용");
		System.out.print("상품 id : ");
		String product_id = sc.nextLine();
		
		System.out.println("업데이트하실 정보들을 입력해 주세용");
		
		System.out.print("상품 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("상품 설명 : ");
		String description = sc.nextLine();

		System.out.print("상품 재고 : ");
		int stock = sc.nextInt();
		sc.nextLine();

		new ProductController().updateProduct(product_id,price,description,stock);
	}

	public void insertProduct() {
		System.out.println("상품 추가메뉴입니다.");
		System.out.println("추가하실 상품 정보들을 입력해 주세용");

		System.out.print("상품 id : ");
		String product_Id = sc.nextLine();

		System.out.print("상품 이름 : ");
		String product_Name = sc.nextLine();

		System.out.print("상품 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("상품 설명 : ");
		String description = sc.nextLine();

		System.out.print("상품 재고 : ");
		int stock = sc.nextInt();
		sc.nextLine();

		new ProductController().insertProduct(product_Id, product_Name, price, description, stock);

	}

	public void selectAll() {

		System.out.println("전체 조회하기 입니다.");
		new ProductController().selectAll();

	}

	public void selectByProductName() {
		System.out.println("이름으로 조회하기 입니다.");
		System.out.println("찾고싶은 상품 이름을 입력해주세요~");
		System.out.print("상품 이름 : ");
		String keyword = sc.nextLine();

		new ProductController().selectByProductName(keyword);
	}

	public void displaySuccess(String message) {

		System.out.println("요청 성공! / " + message);

	}

	public void displayFail(String message) {

		System.out.println("요청 실패... / " + message);

	}

	public void displayList(List list) {

		Iterator it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
