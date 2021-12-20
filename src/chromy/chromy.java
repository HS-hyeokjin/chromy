package chromy;

import javax.sql.rowset.spi.SyncResolver;
import java.util.Scanner;

public class chromy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();

        switch (a) {
            case ("/자바"):
                System.out.println("스캐너사용법");
                break;
            case ("/git"):
                System.out.println("머든 ?");
                break;
            case ("/sql"):
                System.out.println("???");
                break;
            default:
                System.out.println("다시 입력해 주세요.");
        }

    }
}
