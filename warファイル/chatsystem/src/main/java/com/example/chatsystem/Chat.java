package com.example.chatsystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

import static com.example.chatsystem.CombLogin.getName2;
import static com.example.chatsystem.CombLogin.getPass2;
import static com.example.chatsystem.CombUser.*;

@Controller
public class Chat  {

    //この部分があると、最初に文字を入力できる（一番最初に表示される部分だけ）
    private List<String> chats = new ArrayList();//またgetName2がnullになってるよ
    String getName=null;
    String getPass=null;
    //localhost:8080/helloで最初開ける
    @RequestMapping(value="/chat")
    String hello(Model model){
        System.out.println("新規登録のnameの値は"+getName1());
        if(!(getName1() ==null)) {
            model.addAttribute("name", "ユーザ名:" + getName1());
            model.addAttribute("pass", "パスワード:" + getPass1() + "　　　で新規登録しました");
            getName=getName1();
            getPass=getPass1();
            CombUser.keepname=null;
        }
        System.out.println("ログインのnameの値は"+getName2());
        if(!(getName2()==null)) {
            model.addAttribute("name", "ユーザ名:" + getName2());
            model.addAttribute("pass", "パスワード:" + getPass2() + "　　　でログインしました");
            getName=getName2();
            getPass=getPass2();
            CombLogin.keepname=null;
        }
        model.addAttribute("chats",chats);
        return "chat.html";
    }
    //localhost:8080/addで処理を実行（開くことはできない）
    @RequestMapping(value="/add")
    //@RequestParamでhtmlからとってくる
    String addChat(/*@RequestParam("name") String name,*/ @RequestParam("chat") String chat) {
//        chats.add(name+"　:　"+chat);
        chats.add( getName+" :  "+chat);
        return "redirect:/chat";
    }


}


