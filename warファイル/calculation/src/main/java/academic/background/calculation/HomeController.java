package academic.background.calculation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class HomeController {

    BirthDay birthday;
    Calculation calculation=new Calculation();
   @RequestMapping(value="/entry")
    String hello(Model model){
//        model.addAttribute("attributeValue","値の受け渡しに成功しました");
          return "BirthdayEntry";
      }
    @RequestMapping(value="/display")
    String model(@RequestParam("birthday_year") int year,@RequestParam("birthday_month") int month,@RequestParam("birthday_day") int day,Model model){
       System.out.println(year+"/"+month);
        calculation.calc(year,month,day);

        model.addAttribute("age",calculation.getage());
        model.addAttribute("year",calculation.getyear());
        return ("display");
    }


//    String addItem(@RequestParam("task") String task, @RequestParam("deadline") String deadline){
//        String id= UUID.randomUUID().toString().substring(0,8);
////taskとdeadlineを受け取った
//        TaskItemRecord item=new TaskItemRecord(id,task,deadline,false);
//        dao.add(item);
//        return "redirect:/list";
//    }

}
