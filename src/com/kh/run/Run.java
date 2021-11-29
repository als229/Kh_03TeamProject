package com.kh.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.view.ProductView;

public class Run {

	public static void main(String[] args) {
		
//	      Properties prop = new Properties();
//	      prop.setProperty("driver", "oracle.jdbc.driver.OrcleJdbc");
//	      prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
//	      prop.setProperty("username", "JDBC");
//	      prop.setProperty("userpwd", "JDBC");
//
//	      try { // resources : 주로
//	         prop.store(new FileOutputStream("resources/driver.properties"), "driver.properties");
//	         prop.storeToXML(new FileOutputStream("resources/query.xml"), "sibar.xml");
//	      } catch (FileNotFoundException e) {
//	         e.printStackTrace();
//	      } catch (IOException e) {
//	         e.printStackTrace();
//	      }
		
		
		new ProductView().MainMenu();
	}

}
