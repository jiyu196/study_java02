package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconn {
	//
	public static void main(String[] args) throws Exception{
		//1. 접속 객체 취득
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "sample", "1234");
		System.out.println(conn);
		
		//2. 문장 생성
		Statement stmt = conn.createStatement();
		
		//3. 문장 실행 후 결과 반환.  행과열로 구성된 결과표가 resultset임.
		ResultSet rs = stmt.executeQuery("select * from student");
		
		//4. 결과 순회 후 파싱 . int, string 맞춰서 잘 가져오기
		while(rs.next()) {
			System.out.println(rs.getInt("studno") + ":: " + rs.getString("name"));
		}
	}
}
