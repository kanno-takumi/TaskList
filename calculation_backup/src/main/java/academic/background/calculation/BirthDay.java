package academic.background.calculation;

import java.time.*;

public class BirthDay {
LocalDateTime dt;
//代入するためのコンストラクタ
    public BirthDay(int year,int month){
       dt=LocalDateTime.of(year,month,1,0,0);
    }

//取得するためのメソッド   SimpleDateFormat
    public int getyear(){return dt.getYear();}
    public int getmonth(){return dt.getMonthValue();}
}
