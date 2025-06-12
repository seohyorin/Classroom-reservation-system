public class TimeTable {
    String classnumber;
    String time;
    boolean classState;
    

    TimeTable(String classnumber, String time, boolean classState){
        this.classnumber = classnumber;
        this.time = time;
        this.classState = false;
    }

    public String CheckState(){
        if(classState == false){
            return "예약 가능";
        }else{
            return "예약 불가능";
        }
    }

    public void ShowTimeTable(){
        System.out.println("===============Time Table===============");
        for(int i=0;i<4;i++){
            System.out.println("[호실: "+classnumber+ " | 시간: " +time+ " | 예약상태:"+ CheckState()+"]");
        }

    }
}