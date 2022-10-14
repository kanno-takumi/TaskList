package jp.gihyo.projava.tasklist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
public class HomeRestController{
    private final List<TaskItemRecord> taskitems=new ArrayList<>();

    @GetMapping("/restadd")
    String addItem(@RequestParam("task") String task,@RequestParam("deadline") String deadline){
        String id= UUID.randomUUID().toString().substring(0,8);
        TaskItemRecord item=new TaskItemRecord(id,task,deadline,false);//TaskItemの型のitemを作成しただけ
        //TaskItemコンストラクタが呼び出される→フィールドに中身のあるitemが作成された
        taskitems.add(item);

//        System.out.println("taskitemsの中身");
//        System.out.println(taskitems.get(0));
        return "タスクを追加しました";
    }

    @GetMapping("/restlist")
    String listItems(){
        //taskitemsを一行にしている
        String result=taskitems.stream().map(TaskItemRecord::toString).collect(Collectors.joining(","));
        return result;
    }

    @RequestMapping(value="/resthello")
    @ResponseBody
    String hello(){
        return """
         <html> 
         <head><title>hello</title></head>    
         <body>
         <h1>Hello</h1>
         It works!
         現在時刻は%sです
        </body>
        </html>
        """.formatted(LocalDateTime.now());
    }
}

