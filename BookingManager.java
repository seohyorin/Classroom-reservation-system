import java.util.Arrays;
import java.util.List;

public class BookingManager {
    private TimeTable[] savedTableArray;
    private List<TimeTable> savedTableList;

    public BookingManager(SetClassInfo SetClassInfo){
        this.savedTableArray = SetClassInfo.getSetClass();
        this.savedTableList = Arrays.asList(savedTableArray);
    }

    public List<TimeTable> getTableList(){
        return savedTableList;
    }

    public void addBookingRequest(String studentName, String classNumber, String time){
    	boolean found = false;
    	for(TimeTable slot : savedTableList){
            if(slot.classNumber.equals(classNumber)&&slot.time.equals(time)){
            	found = true;
            	if(slot.state == ReservationState.REJECTED){
                    slot.state = ReservationState.PENDING;
                    System.out.println(classNumber + "호실, "+time+"시간의 예약을 완료했습니다.");
                }else{
                    System.out.println("이미 예약이 완료된 강의실입니다.");
                }
                return;
            }
        }
        if(!found) {
        	System.out.println("해당 강의실을 찾을 수 없습니다.");
        }
    }

    public void cancelBooking(String studentName, String classNumber, String time){
        boolean found = false;
    	for(TimeTable slot : savedTableList){
            if(slot.classNumber.equals(classNumber)&&slot.time.equals(time)){
                found = true;
            	if(slot.state == ReservationState.PENDING){
                    slot.state = ReservationState.REJECTED;
                    System.out.println(classNumber + "호실, "+time+"시간의 예약을 취소했습니다.");
                }else{
                    System.out.println("현재 예약 대기 중인 강의실이 아닙니다.");
                }
                return;
            }
        }
        if(!found) {
        	System.out.println("해당 강의실을 찾을 수 없습니다.");
        }
    }
}
