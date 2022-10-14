package jp.gihyo.projava.tasklist;

public record TaskItemRecord(String id,String task,String deadline,boolean done) {

}
//recordではできるが
// classではできない。（値を入れるところまでは確認したけど、表示させるところが分からなかった。）
//