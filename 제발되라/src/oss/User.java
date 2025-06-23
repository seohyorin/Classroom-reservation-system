package oss;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void addBookingRequest(String student, String room, String time) {
        bookings.add(new Booking(student, room, time));
        System.out.println("예약 신청 완료!");
    }

    public String cancel(String student, String room, String time) {
        for (Booking b : bookings) {
            if (b.student.equals(student) && b.room.equals(room) && b.time.equals(time)) {
                bookings.remove(b);
                return "예약 취소 완료!";
            }
        }
        return "해당 예약을 찾을 수 없습니다.";
    }

    private static class Booking {
        String student;
        String room;
        String time;

        Booking(String student, String room, String time) {
            this.student = student;
            this.room = room;
            this.time = time;
        }
    }
}

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
        String enteredClassroomNumber = scanner.next();
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

        String result = bookingManager.cancel(enteredStudentIdName, enteredClassroomNumber, enteredTime);
        System.out.println(result);
    }

    public void check() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("확인할 강의실 번호를 입력하세요:");
        String classNumber = scanner.next();
        System.out.println("확인할 시간을 입력하세요 (예: 09:00):");
        String time = scanner.next();

        TimeTable.SetClassInfo classInfo = new TimeTable.SetClassInfo();
        boolean found = false;

        for (TimeTable entry : classInfo.setclass) {
            if (entry.classnumber.equals(classNumber) && entry.time.equals(time)) {
                System.out.println("--- 예약 가능 여부 ---");
                System.out.println("[호실: " + entry.classnumber + " | 시간: " + entry.time + " | 예약상태: " + entry.CheckState() + "]");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 시간의 정보가 없습니다.");
        }
    }
}