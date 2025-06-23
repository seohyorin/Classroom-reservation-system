package oss;

import java.util.*;

public class User {
    private BookingManager bookingManager;

    public User(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void requestClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요:");
        String enteredStudentIdName = scanner.nextLine();  // nextLine() 변경
        System.out.println("예약할 강의실의 번호를 입력하세요:");
        String enteredClassroomNumber = scanner.nextLine();  // nextLine() 변경
        System.out.println("예약할 시간을 입력하세요 (예: 09:00):");
        String enteredTime = scanner.nextLine();  // nextLine() 변경

        bookingManager.addBookingRequest(enteredStudentIdName, enteredClassroomNumber, enteredTime);
    }

    public void cancelClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요:");
        String enteredStudentIdName = scanner.nextLine();  // nextLine() 변경
        System.out.println("취소할 강의실의 번호를 입력하세요:");
        String enteredClassroomNumber = scanner.nextLine();  // nextLine() 변경
        System.out.println("취소할 시간을 입력하세요 (예: 09:00):");
        String enteredTime = scanner.nextLine();  // nextLine() 변경

        // 수정: System.out.println 제거
        bookingManager.cancelBooking(enteredStudentIdName, enteredClassroomNumber, enteredTime);
    }
    
    public void showTimeTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시간표를 확인할 강의실 번호를 입력하세요:");
        String classNumber = scanner.nextLine();
        
        // TimeTable의 SetTimeTable 메서드 활용
        TimeTable.SetClassInfo classInfo = new TimeTable.SetClassInfo();
        classInfo.SetTimeTable(classNumber, false);  // isAdmin = false
    }

    public void checkMyReservations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요:");
        String studentName = scanner.nextLine();
        
        System.out.println("=== " + studentName + "님의 예약 관련 현황 ===");
        
        // 승인 대기 중인 예약 표시
        System.out.println("\n[ 승인 대기 중인 예약 ]");
        boolean hasPending = false;
        for (TimeTable entry : bookingManager.getTableList()) {
            if (entry.state == ReservationState.PENDING) {
                System.out.println("- " + entry.classNumber + "호실 " + entry.time + " (승인 대기)");
                hasPending = true;
            }
        }
        if (!hasPending) {
            System.out.println("승인 대기 중인 예약이 없습니다.");
        }
        
        // 승인된 예약 표시
        System.out.println("\n[ 승인된 예약 ]");
        boolean hasApproved = false;
        for (TimeTable entry : bookingManager.getTableList()) {
            if (entry.state == ReservationState.APPROVED) {
                System.out.println("- " + entry.classNumber + "호실 " + entry.time + " (승인됨)");
                hasApproved = true;
            }
        }
        if (!hasApproved) {
            System.out.println("승인된 예약이 없습니다.");
        }
        
        System.out.println("\n※ 현재는 전체 예약 현황을 보여드립니다.");
    }
}