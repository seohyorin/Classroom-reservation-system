import java.util.HashMap;
import java.util.Map;

public class BookingManager {

    private Map<String, String> bookings = new HashMap<>();
    private TimeTable.SetClassInfo timetableInfo;

    public BookingManager(TimeTable.SetClassInfo timetableInfo) {
        this.timetableInfo = timetableInfo;
    }

    // 예약 요청 추가
    public void addBookingRequest(String studentIdName, String classroomNumber, String time) {
        // 시간표 배열에서 강의실 번호와 시간 일치하는 객체 찾기
        TimeTable target = findTimeTable(classroomNumber, time);

        if (target == null) {
            System.out.println("해당 강의실과 시간의 시간표가 없습니다.");
            return;
        }

        if (target.classState) { // 예약 불가능 상태면
            System.out.println("이미 예약된 시간입니다.");
            return;
        }

        String key = studentIdName + classroomNumber + time;
        if (bookings.containsKey(key)) {
            System.out.println("이미 예약된 상태입니다.");
            return;
        }

        // 예약 가능하면 상태 변경, 예약 저장
        target.classState = true;
        bookings.put(key, "예약 완료");
        System.out.println(studentIdName + "님의 " + classroomNumber + " 강의실 " + time + " 예약이 완료되었습니다.");
    }

    // 예약 취소
    public String cancelBooking(String studentIdName, String classroomNumber, String time) {
        String key = studentIdName + classroomNumber + time;
        if (!bookings.containsKey(key)) {
            return "예약 내역이 없습니다.";
        }

        // 예약 내역 삭제, 시간표 상태 변경
        bookings.remove(key);

        TimeTable target = findTimeTable(classroomNumber, time);
        if (target != null) {
            target.classState = false;
        }

        return "예약이 취소되었습니다.";
    }

    // 예약 상태 조회
    public String getBookingStatus(String studentIdName, String classroomNumber, String time) {
        String key = studentIdName + classroomNumber + time;
        if (bookings.containsKey(key)) {
            return bookings.get(key);
        }
        return "찾을 수 없음";
    }

    // 시간표에서 강의실번호+시간에 맞는 TimeTable 객체 찾기
    private TimeTable findTimeTable(String classnumber, String time) {
        for (TimeTable t : timetableInfo.setclass) {
            if (t.classnumber.equals(classnumber) && t.time.equals(time)) {
                return t;
            }
        }
        return null;
    }
}
