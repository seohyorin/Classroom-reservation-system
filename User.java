import java.util.Scanner;

public class User extends Timetable {

    public User() {
        super();
    }

    public void requestClass(String classroom) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약할 강의실의 번호를 입력하세요.");
        int calssroom = scanner.nextInt();
        System.out.println("신청한 강의실: " + classroom);
    }

    public void cancelClass(String classroom) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("취소할할 강의실의 번호를 입력하세요.");
        int calssroom = scanner.nextInt();
        System.out.println("취소한 강의실: " + classroom);
    }

}