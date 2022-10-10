package com.example.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {
    private List<TaskItem> taskitems=new ArrayList<>();

    @GetMapping(value="/list")//urlで/listが呼ばれたとき
    String listItems(Model model){
        model.addAttribute("taskList",taskitems);
        return "home";
    }
    @GetMapping("/add")
    String addItem(@RequestParam("task") String task,@RequestParam("deadline") String deadline){
        String id=UUID.randomUUID().toString().substring(0,8);
        TaskItem item=new TaskItem(id,task,deadline,false);
        taskitems.add(item);
        return "redirect:/list";
    }
    @GetMapping("/delete")
    String deleteItem(@RequestParam("id") String id){
        int listSize=taskitems.size();
        TaskItem item=new TaskItem("sample","sample","sample",false);
        for(int i=0;i<listSize;i++){
//            System.out.println(taskitems.get(i).getId());
//            System.out.println(id);
            if(taskitems.get(i).getId().equals(id)){//taskitems(list)の全てのクラスからidの検索をかける
                taskitems.remove(i);
                break;
            }
        }
    return "redirect:/list";
    }
}
