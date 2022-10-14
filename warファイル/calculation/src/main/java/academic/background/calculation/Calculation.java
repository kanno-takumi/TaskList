package academic.background.calculation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Calculation {
    private int age;
    private int junior_year;
    private int high_year;
    private int college_year;

    private String string_junior_year;
    private String string_high_year;
    private String string_college_year;

    //①viewから値を受け取る
    //SampleView sampleview=new SampleView();
    //②BirthDayオブジェクトに値を埋め込む

    void yearcalc(int year,int month,int day){
        System.out.println("yearcalcが呼び出されました");
        LocalDate tempage;
        tempage=(LocalDate.now().minus(year,ChronoUnit.YEARS));
        tempage=(tempage.minus(month,ChronoUnit.MONTHS));
        tempage=(tempage.minus(day,ChronoUnit.DAYS));
        this.age=tempage.getYear();
        this.junior_year=year+13;
        this.high_year=year+16;
        this.college_year=year+19;


//        System.out.println("現在は"+LocalDateTime.now().getYear()+"年です");
//        System.out.println("あなたは"+year+"年生まれです");
    }

    void monthcalc(int month){
        if(month==1||month==2||month==3){
            this.junior_year=this.junior_year-1;
            this.high_year=high_year-1;
            this.college_year=college_year-1;
        }
    }

    void calc(int year,int month,int day){
        System.out.println("calcが呼び出されました");
        yearcalc(year,month,day);
        monthcalc(month);

    }

    //年齢を与えるメソッド
    int getage(){
        return this.age;
    }

    //学歴を与えるメソッド
//    List<Integer> getyear(){
      List<List<String>> getyear(){
        return Arrays.asList(
                Arrays.asList(String.valueOf(junior_year)+"年4月　中学校入学",String.valueOf(junior_year+3)+"年3月　中学校卒業"),
                Arrays.asList(String.valueOf(high_year)+"年4月　高校入学",String.valueOf(high_year+3)+"年3月　高校卒業"),
                Arrays.asList(String.valueOf(college_year)+"年4月　大学入学",String.valueOf(college_year+4)+"年3月　大学卒業"));
//        return Arrays.asList(junior_year,high_year,college_year);
    }


}
