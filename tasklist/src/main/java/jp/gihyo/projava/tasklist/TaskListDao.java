package jp.gihyo.projava.tasklist;

import jp.gihyo.projava.tasklist.TaskItemRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskListDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    TaskListDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void add(TaskItemRecord taskItem){
        SqlParameterSource param=new BeanPropertySqlParameterSource(taskItem);
        //↑こっちがテーブルに入れたいオブジェクトを引数にする
        SimpleJdbcInsert insert=new SimpleJdbcInsert(jdbcTemplate).withTableName("tasklist");
        //↑こっちがテーブル名の指定
        insert.execute(param);
    }

    public List<TaskItemRecord> findAll(){
        String query="SELECT * FROM tasklist";
        List<Map<String,Object>> result=jdbcTemplate.queryForList(query);
        List<TaskItemRecord> taskItems=result.stream().map((Map<String,Object>row)->new TaskItemRecord(
                row.get("id").toString(),
                row.get("task").toString(),
                row.get("deadline").toString(),
                (Boolean)row.get("done")))
                .toList();

        return taskItems;
    }

    public int delete(String id){
        int number=jdbcTemplate.update("DELETE FROM tasklist WHERE id=?",id);//SQLのidが引数のidと同じとき削除する
        //                               ex)DELETE FROM tasklist WHERE id='0001'
        return number;
    }

    //tableに入っているtaskItemを更新する（更新したいタスク情報を引数として受け取る）
    public int update(TaskItemRecord taskItem){
        int number=jdbcTemplate.update(
                "UPDATE tasklist SET task=?,deadline=?,done=? WHERE id=?",
                taskItem.task(),
                taskItem.deadline(),
                taskItem.done(),
                taskItem.id());
        return number;
    }
}
