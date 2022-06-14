package com.fzg.imooc.exam;

/*
 * Car类用来封装牌的类型、花色、大小王参数
 */
public class Card {
    private String num;
    private String type;
    private String other;
    public Card(String num,String type,String other){
        this.num=num;
        this.type=type;
        this.other=other;
    }
    public String getOther() {
        return other;
    }
    public void setOther(String other) {
        this.other = other;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return num + type + other;
    }
}
