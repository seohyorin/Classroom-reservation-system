public class TimeTable {
    String classnumber;
    String time;
    boolean classState;
    

    TimeTable(String classnumber, String time, boolean classState){
        this.classnumber = classnumber;
        this.time = time;
        this.classState = classState;
    }

    public String CheckState(){
        if(classState == false){
            return "예약 가능";
        }else{
            return "예약 불가능";
        }
    }

    static class SetClassInfo{
        TimeTable[] setclass = {
            new TimeTable("55102", "09:00", false),new TimeTable("55102", "10:00", false),
            new TimeTable("55102", "11:00", false),new TimeTable("55102", "14:00", false),
            new TimeTable("55102", "15:00", false),new TimeTable("55110", "9:00", false),
            new TimeTable("55110", "10:00", false),new TimeTable("55110", "11:00", false),
            new TimeTable("55110", "12:00", false),new TimeTable("55110", "13:00", false),
            new TimeTable("55501", "10:00", false),new TimeTable("55501", "11:00", false),
            new TimeTable("55501", "12:00", false),new TimeTable("55516", "9:00", false),
            new TimeTable("55516", "12:00", false),new TimeTable("55516", "13:00", false),
            new TimeTable("55516", "14:00", false)
        };
        

        public void SetTimeTable(String classnumber){
            System.out.println("========= "+classnumber+" 호실 예약 가능 시간표 =========");
            for(int i=0;i<17;i++){
                 if (setclass[i].classnumber.equals(classnumber)){
                    System.out.println("[호실: "+setclass[i].classnumber+ " | 시간: " +setclass[i].time+ " | 예약상태:"+ setclass[i].CheckState()+"]");
                 }
            }
        }
    }   
}