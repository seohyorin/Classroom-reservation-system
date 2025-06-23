package oss;

public class TimeTable {
    String classNumber;
    String time;
    ReservationState state;
    

    TimeTable(String classNumber, String time, ReservationState state){
        this.classNumber = classNumber;
        this.time = time;
        this.state = state;
    }

        public String UserViewState(){ //유저가 보는 화면의 상태
        switch (state) {
             case PENDING:
                return "승인 대기"; //승인 대기 중
            case APPROVED:
                return "예약 불가능"; //이미 다른 사람이 예약함
            case REJECTED:
                return "예약 가능"; //예약이 거절되어 다시 예약 가능
            default:
                return "상태 불명";
        }
    }
    
    public String AdminViewState(){ //관리자가 보는 화면의 상태
        switch (state) {
             case PENDING:
                return "예약 대기";
            case APPROVED:
                return "예약 승인";
            case REJECTED:
                return "예약 거절";
            default:
                return "상태 불명";
        }
    }
    
    public static class SetClassInfo{
        TimeTable[] setclass = {
            new TimeTable("55102", "09:00", ReservationState.REJECTED),new TimeTable("55102", "10:00", ReservationState.REJECTED),
            new TimeTable("55102", "11:00", ReservationState.REJECTED),new TimeTable("55102", "14:00", ReservationState.REJECTED),
            new TimeTable("55102", "15:00", ReservationState.REJECTED),new TimeTable("55110", "09:00", ReservationState.REJECTED),
            new TimeTable("55110", "10:00", ReservationState.REJECTED),new TimeTable("55110", "11:00", ReservationState.REJECTED),
            new TimeTable("55110", "12:00", ReservationState.REJECTED),new TimeTable("55110", "13:00", ReservationState.REJECTED),
            new TimeTable("55501", "10:00", ReservationState.REJECTED),new TimeTable("55501", "11:00", ReservationState.REJECTED),
            new TimeTable("55501", "12:00", ReservationState.REJECTED),new TimeTable("55516", "09:00", ReservationState.REJECTED),
            new TimeTable("55516", "12:00", ReservationState.REJECTED),new TimeTable("55516", "13:00", ReservationState.REJECTED),
            new TimeTable("55516", "14:00", ReservationState.REJECTED)
        };

        public TimeTable[] getSetClass(){
            return setclass;
        }
        

        public void SetTimeTable(String classNumber, boolean isAdmin){
            System.out.println("========= "+classNumber+" 호실 예약 가능 시간표 =========");
            for(TimeTable statusSlot : setclass){
                 if (statusSlot.classNumber.equals(classNumber)){
                    String status;
                    if(isAdmin){
                        status = statusSlot.AdminViewState();
                    }else{
                         status = statusSlot.UserViewState();
                    }
                    System.out.println("[호실: "+statusSlot.classNumber+ " | 시간: " +statusSlot.time+ " | 예약상태:"+ status +"]");
                 }
            }
        }
} 
}  