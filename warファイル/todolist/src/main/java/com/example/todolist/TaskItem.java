package com.example.todolist;

public class TaskItem {
    String id;
    String task;
    String deadline;
    boolean done;

    public TaskItem(String id,String task,String deadline,boolean done){
        this.id=id;
        this.task=task;
        this.deadline=deadline;
        this.done=done;
    }

//    public void setId(String id){
//        this.id=id;
//    }
//    public void setTask(String task){
//        this.task=task;
//    }
//    public void setDeadline(String deadline){
//        this.deadline=deadline;
//    }
//    public void setDone(boolean done){
//        this.done=done;
//    }

    public String getId() {
        return id;
    }
    public String getTask(){
        return task;
    }
    public String getDeadline(){
        return deadline;
    }
    public boolean getDone(){
        return done;
    }

}
