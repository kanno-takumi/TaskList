package jp.gihyo.projava.tasklist;

import jp.gihyo.projava.tasklist.TaskItemRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Controller
public class HomeController{
    private List<TaskItemRecord> taskitems=new ArrayList<>();
    private TaskListDao dao;

    @Autowired
    HomeController(TaskListDao dao){
        this.dao=dao;
    }

    @RequestMapping(value="/hello")
    String hello(Model model){
       model.addAttribute("time",LocalDateTime.now());
       return "hello";
    }

    @GetMapping("/list")
    String listitems(Model model){
        List<TaskItemRecord> taskItems=dao.findAll();
        model.addAttribute("taskList",taskItems);
        return "home";
    }

    @GetMapping("/add")
    String addItem(@RequestParam("task") String task,@RequestParam("deadline") String deadline){
        String id=UUID.randomUUID().toString().substring(0,8);
//taskとdeadlineを受け取った
        TaskItemRecord item=new TaskItemRecord(id,task,deadline,false);
        dao.add(item);
        return "redirect:/list";
    }

    @GetMapping("/delete")//htmlファイルからidをidとして受け取る
    String deleteItem(@RequestParam("id") String id){
        dao.delete(id);//daoオブジェクトからdeleteメソッドを呼び出す
        return "redirect:/list";
    }

    //HTMLからRequestParamにより値を受け取り、TaskListDaoのメソッドを呼び出すことでデータベースに接続している
    @GetMapping("/update")
    String updateItem(@RequestParam("id") String id,
                      @RequestParam("task") String task,
                      @RequestParam("deadline")String deadline,
                      @RequestParam("done") boolean done){
        //ここでオブジェクト(taskItem)にHTMLから受け取った値を入れていく
        //taskitemは更新したいオブジェクト
        TaskItemRecord taskItem=new TaskItemRecord(id,task,deadline,done);
        dao.update(taskItem);
        return "redirect:/list";
    }
}

