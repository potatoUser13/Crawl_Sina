package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class a {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/crawlSina?characterEncoding=UTF-8&serverTimezone=UTC","root", "wy654383369");

		Statement s = c.createStatement();

		// 准备sql语句
		// 注意： 字符串要用单引号'
		String sql = "insert into bridge values(null,'nihao',2500)";
		s.execute(sql);


	}

}
