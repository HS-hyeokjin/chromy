package chromy;

import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class chromy {
    public static void main(String[] args)  {
        Connection conn;
        Statement stmt = null;
        String sql_commend = "kfkfkwkaakakk";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chromy", "root","youn4268!!"); // JDBC 연결
            System.out.println("DB연결완료");

            stmt = conn.createStatement(); //SQL문 처리용 Statement 객체 생성
            ResultSet srs = stmt.executeQuery("select * from chromy"); // 테이블의 모든데이터 검색문
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC드라이버로드오류");
        } catch (SQLException e) {
            System.out.println("DB연결오류");
        }

        Scanner sc = new Scanner(System.in);
        String main_commend = "";

        while(!main_commend.equals("/종료")) {

            main_commend = sc.nextLine();

            switch (main_commend) {
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
                    while (!sql_commend.equals("/종료")) {
                        System.out.println("sql 사용법");
                        System.out.println("dml. ddl. dcl");
                        sql_commend = sc.nextLine();
                        switch (sql_commend) {
                            case ("/dml"):
                                System.out.println("dml db");
                                break;
                            case ("/ddl"):
                                System.out.println("ddl db");
                                break;
                            case ("/dcl"):
                                System.out.println("dcl cd");
                                break;
                            case ("/추가"):
                                System.out.println("추가되었습니다");
                                break;
                            default:
                                System.out.println("다시 입력해 주세요.");
                        }
                    }

                    break;
                default:
                    System.out.println("다시 입력해 주세요.");
            }
        }
    }
}
