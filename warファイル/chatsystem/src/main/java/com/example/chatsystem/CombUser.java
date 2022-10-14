package com.example.chatsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CombUser {
   static String[] name = new String[100];
   static String[] pass = new String[100];
int[] test=new int[5];

    static  String keepname;
    static String keeppass;

    @RequestMapping(value="/signup")
          public String transfer(){
        return "register.html";

    }

    int i = 5;
@RequestMapping(value="/Register")
    public String makeUser(@RequestParam("name") String name, @RequestParam("pass") String pass) {
    keepname=name;
    keeppass=pass;
    this.name[i] = name;
    this.pass[i] = pass;

    System.out.println("name["+i+"]の中身は"+this.name[i]);//確認用
    System.out.println("pass["+i+"]の中身は"+this.pass[i]);//確認用
    i=i+1;

    return "redirect:/chat";
    }

    static String getName1(){
                //System.out.println("getName1でとってきたkeepname"+keepname);
    return keepname;
    }
    static String getPass1(){
    return keeppass;
    }

    public void existUser(){
        this.name[0]="takumi";this.pass[0]="pass";
        this.name[1]="leo";this.pass[1]="dog1";
        this.name[2]="mary";this.pass[2]="dog2";
        this.name[3]="guest";this.pass[3]="guestpass";
    }
}

