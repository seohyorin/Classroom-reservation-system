enum ReservationState {
    PENDING,
    APPROVED,
    REJECTED
}

class Admin {
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