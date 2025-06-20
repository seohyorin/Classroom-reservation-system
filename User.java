import java.util.Scanner;

public class User{
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
        classInfo.SetTimeTable(classNumber, false);
}
