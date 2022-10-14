package jp.gihyo.projava.tasklist;

public class TaskItem {
    private String id;
    private String task;
    private String deadline;
    private boolean done;
    public TaskItem(String id,String task,String deadline,boolean done){
        this.id=id;
        this.task=task;
        this.deadline=deadline;
        this.done=done;
    }

    public String getId(){
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