package oss;

import java.util.*;

public class User {
    private BookingManager bookingManager;

    public User(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void requestClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요.");
        String enteredStudentIdName = scanner.next();
        System.out.println("예약할 강의실의 번호를 입력하세요.");
        String enteredClassroomNumber = scanner.nextLine();
        System.out.println("예약할 시간을 입력하세요 (예: 09:00):");
        String enteredTime = scanner.next();

        bookingManager.addBookingRequest(enteredStudentIdName, enteredClassroomNumber, enteredTime);
    }

    public void cancelClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요.");
        String enteredStudentIdName = scanner.next();
        System.out.println("취소할 강의실의 번호를 입력하세요.");
        String enteredClassroomNumber = scanner.next();
        System.out.println("취소할 시간을 입력하세요 (예: 09:00):");
        String enteredTime = scanner.next();

        bookingManager.cancelBooking(enteredStudentIdName, enteredClassroomNumber, enteredTime);
    }

    public void check() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("확인할 강의실 번호를 입력하세요:");
        String classNumber = scanner.next();
        System.out.println("확인할 시간을 입력하세요 (예: 09:00):");
        String time = scanner.nextLine();

        boolean found = false;
        for (TimeTable entry : bookingManager.getTableList()) {
            if (entry.classNumber.equals(classNumber) && entry.time.equals(time)) {
                System.out.println("--- 예약 가능 여부 ---");
                System.out.println("[호실: " + entry.classNumber + " | 시간: " + entry.time + " | 예약상태: " + entry.UserViewState() + "]");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 시간의 정보가 없습니다.");
        }
    }
}
