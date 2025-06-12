import java.util.Scanner;

public class User extends Timetable {

    public User() {
        super();
    }

    public void requestClass(String classroom, String idname) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요.");
        String id = scanner.next();
        System.out.println("예약할 강의실의 번호를 입력하세요.");
        int calssroom = scanner.nextInt();
        System.out.println("학번이름: " + idname);
        System.out.println("신청한 강의실: " + classroom);
    }

    public void cancelClass(String classroom, String idname) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학번이름을 입력하세요.");
        String id = scanner.next();
        System.out.println("취소할 강의실의 번호를 입력하세요.");
        int calssroom = scanner.nextInt();
        System.out.println("학번이름: " + idname);
        System.out.println("한 강의실: " + classroom);
    }

}