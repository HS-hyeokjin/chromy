package chromy;
import java.sql.*;


public class DB {
    Connection conn;

try {
        Class.forName(“com.mysql.jdbc.Driver“); // MySQL 드라이버 로드
        conn = DriverManager.getConnection(“jdbc:mysql://localhost:3306/
        chromy“, “root“,““); // JDBC 연결
        System.out.println(“DB 연결 완료“);

    stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성

        ResultSet srs = stmt.executeQuery(“select * from student“); // 테이블의 모든 데이터 검색

        printData(srs, “ㅁ“, “ㅁ“, “ㅁ“);
    srs = stmt.executeQuery(“select name, id, dept from ㅁ where name=’“+ new
    String(“ㅁ“.getBytes(), “ISO-8859-1“) +“‘“); // name이 “이기자“인 레코드만 검색
    printData(srs, “name“, “id“, “dept“);
} catch (ClassNotFoundException e) {
        System.out.println(“JDBC 드라이버 로드 오류“);
        } catch (SQLException e) {
        System.out.println(“SQL 실행 오류“);
        } catch (UnsupportedEncodingException e) {
        System.out.println(“지원되지 않는 인코딩 타입“);
        }
ㅁㅁ
    Statement stmt = null;
}
private static void printData(ResultSet srs, String col1, String col2, String
        col3) throws UnsupportedEncodingException, SQLException {
        while (srs.next()) {
        if (!col1.equals(““))
        System.out.print(new String(srs.getString(“name“).getBytes(“ISO8859-1“))); // 한글 코드 변환
        if (!col2.equals(““))
        System.out.print(“\t|\t“ + srs.getString(“id“));
        if (!col3.equals(““))
        System.out.println(“\t|\t“ + new String(srs.getString(“dept“).
        getBytes(“ISO-8859-1“))); // 한글 코드 변환
        else
        System.out.println();
        }
        }