import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// import Admin;
// import User;
// import TimeTable;

package oss;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 강의실 예약 시스템 ===");
        System.out.print("관리자이신가요? (y/n): ");
        String input = sc.nextLine();

        List<TimeTable> list = new ArrayList<>();
        list.add(new TimeTable("101", "10:00 ~ 12:00", true)); // 예시용

        if (input.equalsIgnoreCase("y")) {
            Admin admin = new Admin();
            admin.printPendingReservations(list);
            admin.approveReservation(list.get(0));
        } else {
            User user = new User();
            user.requestClass("101호");
            user.cancelClass("101호");
        }

        sc.close();
    }
}