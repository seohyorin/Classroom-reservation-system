import java.util.Scanner;

public class User extends Timetable {
    private BookingManager bookingManager;

    public User(BookingManager bookingManager) {
        super();
        this.bookingManager = bookingManager;
    }

    public void requestClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요.");
        String enteredStudentIdName = scanner.next();
        System.out.println("예약할 강의실의 번호를 입력하세요.");
        String enteredClassroomNumber = scanner.next();

        bookingManager.addBookingRequest(enteredStudentIdName, enteredClassroomNumber);
    }

    public void cancelClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요.");
        String enteredStudentIdName = scanner.next();
        System.out.println("취소할 강의실의 번호를 입력하세요.");
        String enteredClassroomNumber = scanner.next();
        
        String result = bookingManager.cancelBooking(enteredStudentIdName, enteredClassroomNumber);
        System.out.println(result);
    }

    public void checkBookingStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약 상태를 확인할 학번이름을 입력하세요.");
        String studentIdName = scanner.next();
        System.out.println("예약 상태를 확인할 강의실 번호를 입력하세요.");
        String classroomNumber = scanner.next();

        String status = bookingManager.getBookingStatus(studentIdName, classroomNumber);
        if ("찾을 수 없음".equals(status)) {
            System.out.println("해당하는 예약이 없습니다.");
        } else {
            System.out.println("예약 상태: " + status);
        }
    }
}
