package com.example.chatsystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
@Controller
public class CombLogin {
    int miss=0;
    CombUser user=new CombUser();
    @RequestMapping(value="/login")
    public String login(Model model) {
        if (miss>0) {
            model.addAttribute("failuremessage", "ユーザ名またはパスワードが違います");
            model.addAttribute("failuremessage2","ログインに失敗しました(" + miss + "  回)");
            model.addAttribute("failuremessage3","ユーザがない場合は新規登録してください");
        }

        return "login.html";
    }

    String name, pass;
    boolean judge = false;

    static String keepname;
    static String keeppass;

    @RequestMapping(value = "/confirm")
    String confirm(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        keepname=name;
        keeppass=pass;
        user.existUser();
        judgesystem(name, pass);
        if (judge) {
            this.success();
            judge=false;
            return "redirect:/chat";
        } else {
            this.miss = this.miss + 1;
            //this.failure();
            return "redirect:/login";
        }
    }

    void judgesystem(String name, String pass) {
        //UserAdmin user = new UserAdmin();
        //user.existUser();

        user.existUser();
        for (int i = 0; i < 10; i++) {
            if (name.equals(user.name[i]) && pass.equals(user.pass[i])) {
                this.judge = true;
                break;
            }
        }
    }

    /*
    public void failure(
    ) {
        System.out.println("login failed(" + miss + "time)");
        System.out.println("If no user exists,make your user ");


//html↑↑の文字を受け渡し隊を
        if (miss >= 3) {//missを3回以上したとき終了
            //assertion
            System.out.println("you cant login anymore");
            System.exit(0);
        }

    }
    */

    public void success() {
        System.out.println("login succeed");
    }

    public static String getName2(){
        System.out.println("getname2でprintlnしてる値　　"+keepname);
        return keepname;}

    public static String getPass2(){
        return keeppass;
    }

}





