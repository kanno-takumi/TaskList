package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskListDao {
    private final JdbcTemplate jdbcTemplate;//クラスの中のデータベースの変数
    @Autowired
        //コンストラクタ（Autowiredにより、自動で引数を設定してくれる）
    TaskListDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    //データベースに登録するメソッド
    public  void add(TaskItem taskItem){//引数でTaskItemを使う
        SqlParameterSource param=new BeanPropertySqlParameterSource(taskItem);//taskItemクラスのオブジェクトをparamへ格納する
        SimpleJdbcInsert insert=new SimpleJdbcInsert(jdbcTemplate).withTableName("tasklist");//データベースに保存するためのインスタンスを生成
        insert.execute(param);//Insertを行う
    }

    //データベースから取り出すメソッド
    public List<TaskItem> findAll(){
        List<TaskItem> taskItemList=new ArrayList<>();
        String query="SELECT*FROM tasklist";//「tasklistテーブルから取り出す」というSQL文→query
        List<Map<String,Object>> result=jdbcTemplate.queryForList(query);//SQLを読み取りList<Map<string,Object>>型として格納する。//戻り値となるListは<Map<列名（キー）,中身>>となる
        for(Map map:result){
            TaskItem taskItem=new TaskItem(map.get("id").toString(),map.get("task").toString(),map.get("deadline").toString(),(Boolean)map.get("done"));
            taskItemList.add(taskItem);
        }


        return taskItemList;

    }
}


//mapメソッドはリストを引数にとり、処理後の結果をStreamにして返す。
//中間操作