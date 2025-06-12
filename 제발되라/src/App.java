import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 수업 예약 시스템 ===");
        System.out.print("관리자이신가요? (y/n): ");
        String input = sc.nextLine();

        if (isAdminLogin(input)) {
            System.out.println("관리자 모드로 진입합니다.");
            Admin admin = new Admin();
            admin.approveClass("자바 프로그래밍");
            admin.viewAllSchedules();
        } else {
            System.out.println("사용자 모드로 진입합니다.");
            User user = new User();
            user.requestClass("자료구조");
            user.viewMySchedule();
        }

        sc.close();
    }

    public static boolean isAdminLogin(String input) {
        return input.equalsIgnoreCase("y");
    }
}
