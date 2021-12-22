package chromy;

import java.util.Scanner;
import java.sql.*;

public class chromy {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(“com.mysql.jdbc.Driver“); // MySQL 드라이버 로드
            Connection conn = DriverManager.getConnection(“jdbc:mysql://localhost:
            3306/chromy“, “root“,“youn4268!!“); // JDBC 연결
            System.out.println(“DB 연결 완료“);
        } catch (ClassNotFoundException e) {
            System.out.println(“JDBC드라이버로드오류“);
        } catch (SQLException e) {
            System.out.println(“DB연결오류“);
        }

        String url = "jdbc:mysql://localhost:3306/chromy";
        String userName = "root";
        String password = "youn4268!!";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from commend");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();

        Scanner sc = new Scanner(System.in);

        String first_commend = sc.nextLine();

        switch (first_commend) {
            case ("/java"):
                System.out.println("스캐너사용법");
                break;
            case ("/python"):
                System.out.println("파이썬사용법");
                break;
            case ("/git"):
                System.out.println("git 사용법");
                break;
            case ("/sql"):
                System.out.println("sql 사용법");
                break;
            default:
                System.out.println("다시 입력해 주세요.");
        }

    }
}
