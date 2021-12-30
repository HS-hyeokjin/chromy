package chromy;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.sql.*;

public class chromy {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        Connection conn;
        Statement stmt = null;
        String main_commend = "";
        String sql_commend = "";
        String ddl_commend = "";
        String dml_commend = "";
        String dcl_commend = "";


        insert insert = new insert();
        System.out.println(insert.insert);

        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chromy", "root", "youn4268!!"); // JDBC 연결


        System.out.println("\n..데이터베이스 연결 완료\n.\n.\n");
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from commend");

        resultSet.next();
        String commend = resultSet.getString("commend");

        while (!main_commend.equals("/종료")) {
            System.out.println("사용하실 모드를 선택해주세요");
            System.out.print("[java//python//git//sql]\n->");
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
                    System.out.println("sql mode ... on");

                    while (!sql_commend.equals("/종료")) {
                        System.out.println("/ddl /dml /dcl");
                        sql_commend = sc.nextLine();
                        switch (sql_commend) {
                            case ("/ddl"):
                                while (!ddl_commend.equals("/종료")) {
                                    System.out.println("Please select your desired menu \n/create /alter /drop /truncate");
                                    ddl_commend = sc.nextLine();

                                    switch (ddl_commend) {
                                        case ("/create"):
                                            System.out.println("CREATE TABLE table_name\n" +
                                                    "(\n" +
                                                    "column_name1 data_type(size),\n" +
                                                    "column_name2 data_type(size),\n" +
                                                    "column_name3 data_type(size),\n" +
                                                    "....\n" +
                                                    ");\n" +
                                                    "table_name 테이블 명을 나타낸다. \n" +
                                                    "column_name1 : 컬럼의 이름을 나타낸다. \n" +
                                                    "\n" +
                                                    "data_type(size) : 컬럼에 있는 데이터의 타입을 명시한다. (e.g. varchar, integer, decimal, date, etc.)\n" +
                                                    "\n" +
                                                    "\n" +
                                                    "\n" +
                                                    "Persons이라는 테이블을 만들고 5개의 컬럼을 만든다. \n" +
                                                    "\n" +
                                                    "\n" +
                                                    "\n" +
                                                    "CREATE TABLE Persons\n" +
                                                    "(\n" +
                                                    "PersonID int,\n" +
                                                    "LastName varchar(255),\n" +
                                                    "FirstName varchar(255),\n" +
                                                    "Address varchar(255),\n" +
                                                    "City varchar(255)\n" +
                                                    ");\n" +
                                                    "\n");
                                            break;
                                        case ("/alter"):
                                            resultSet = stmt.executeQuery("select commend, id, content from commend where commend = '"+ new
                                                    String("/create".getBytes(), "ISO-8859-1") +"'"); // commend가 /create인 레코드만 검색
                                            printData(resultSet, "commend", "id", "content");

                                            break;
                                        case ("/drop"):
                                            System.out.println("drop");
                                            break;
                                        case ("/truncate"):
                                            System.out.println("truncate");
                                            break;
                                        default:
                                            System.out.println("다시 입력해 주세요.");
                                    }
                                    break;
                                }
                                break;
                            case ("/dml"):
                                System.out.println("dml db");
                                break;
                            case ("/dcl"):
                                System.out.println("dcl cd");
                                break;
                            case ("/add"):
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

        resultSet.close();
        stmt.close();
        conn.close();
    }

    private static void printData(ResultSet srs, String col1, String col2, String col3) throws UnsupportedEncodingException, SQLException {
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print(new String(srs.getString("commend").getBytes("ISO-8859-1"))); // 한글 코드 변환
            if (!col2.equals(""))
                System.out.print("\t|\t" + srs.getString("id"));
            if (!col3.equals(""))
                System.out.println("\t|\t" + new String(srs.getString("content").
                        getBytes("ISO-8859-1"))); // 한글 코드 변환
            else
                System.out.println();
        }
    }
}