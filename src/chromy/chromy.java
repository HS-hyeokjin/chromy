package chromy;

import javax.sql.rowset.spi.SyncResolver;
import java.util.Scanner;

public class chromy {
    public static void main(String[] args) {
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
