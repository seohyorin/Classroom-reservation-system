package oss;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 시스템 초기화
        TimeTable.SetClassInfo setClassInfo = new TimeTable.SetClassInfo();
        BookingManager bookingManager = new BookingManager(setClassInfo);
        
        System.out.println("=== 강의실 예약 시스템 ===");
        
        while (true) {
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 관리자 모드");
            System.out.println("2. 사용자 모드");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
                    adminMode(bookingManager, sc);
                    break;
                case "2":
                    userMode(bookingManager, sc);
                    break;
                case "3":
                    System.out.println("시스템을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }
    
    private static void adminMode(BookingManager bookingManager, Scanner sc) {
        Admin admin = new Admin();
        
        while (true) {
            System.out.println("\n=== 관리자 모드 ===");
            System.out.println("1. 예약 신청 현황 보기");
            System.out.println("2. 예약 승인");
            System.out.println("3. 예약 거절");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.print("선택: ");
            
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
                    admin.printPendingReservations(bookingManager.getTableList());
                    break;
                case "2":
                    approveReservation(admin, bookingManager, sc);
                    break;
                case "3":
                    rejectReservation(admin, bookingManager, sc);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }
    
    private static void userMode(BookingManager bookingManager, Scanner sc) {
        User user = new User(bookingManager);
        
        while (true) {
            System.out.println("\n=== 사용자 모드 ===");
            System.out.println("1. 강의실 예약");
            System.out.println("2. 예약 취소");
            System.out.println("3. 강의실 상태 확인");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.print("선택: ");
            
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
                    user.requestClass();
                    break;
                case "2":
                    user.cancelClass();
                    break;
                case "3":
                    user.check();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }
    
    private static void approveReservation(Admin admin, BookingManager bookingManager, Scanner sc) {
        System.out.print("승인할 강의실 번호를 입력하세요: ");
        String classNumber = sc.nextLine();
        System.out.print("승인할 시간을 입력하세요 (예: 09:00): ");
        String time = sc.nextLine();
        
        TimeTable targetSlot = findSlot(bookingManager.getTableList(), classNumber, time);
        if (targetSlot != null) {
            admin.approveReservation(targetSlot);
        } else {
            System.out.println("해당 강의실을 찾을 수 없습니다.");
        }
    }
    
    private static void rejectReservation(Admin admin, BookingManager bookingManager, Scanner sc) {
        System.out.print("거절할 강의실 번호를 입력하세요: ");
        String classNumber = sc.nextLine();
        System.out.print("거절할 시간을 입력하세요 (예: 09:00): ");
        String time = sc.nextLine();
        
        TimeTable targetSlot = findSlot(bookingManager.getTableList(), classNumber, time);
        if (targetSlot != null) {
            admin.rejectReservation(targetSlot);
        } else {
            System.out.println("해당 강의실을 찾을 수 없습니다.");
        }
    }
    
    private static TimeTable findSlot(List<TimeTable> slots, String classNumber, String time) {
        for (TimeTable slot : slots) {
            if (slot.classNumber.equals(classNumber) && slot.time.equals(time)) {
                return slot;
            }
        }
        return null;
    }
}