import java.util.List;

package oss;

enum ReservationState {
    PENDING,
    APPROVED,
    REJECTED
}

public class Admin {

    // 예약 신청 현황 출력 (PENDING 상태인 예약만 보여줌)
    public void printPendingReservations(List<TimeTable> slots) {
        System.out.println("=== 예약 신청 현황 ===");
        boolean hasPending = false;
        for (TimeTable slot : slots) {
            if (slot.state == ReservationState.PENDING) {
                System.out.println(slot.classNumber + " " + slot.time + " 예약 대기중");
                hasPending = true;
            }
        }
        if (!hasPending) {
            System.out.println("승인 대기 중인 예약이 없습니다.");
        }
    }

    // 예약 승인
    public void approveReservation(TimeTable slot) {
        if (slot.state == ReservationState.PENDING) {
            slot.state = ReservationState.APPROVED;
            System.out.println(slot.classNumber + " " + slot.time + " 예약이 승인되었습니다.");
        } else {
            System.out.println("승인할 예약이 없습니다.");
        }
    }

    // 예약 거절
    public void rejectReservation(TimeTable slot) {
        if (slot.state == ReservationState.PENDING) {
            slot.state = ReservationState.REJECTED;
            System.out.println(slot.classNumber + " " + slot.time + " 예약이 거절되었습니다.");
        } else {
            System.out.println("거절할 예약이 없습니다.");
        }
    }
}
