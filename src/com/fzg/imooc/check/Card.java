package com.fzg.imooc.check;

/**
 * 用于存放扑克牌型
 */
public class Card {
    private String Type;
    private String Num;
    private String Other;

    public String getType() {
        return Type;
    }
    public String getNum() {
        return Num;
    }
    public String getOther() {
        return Other;
    }

    public Card(String type, String num, String other) {
        this.Type = type;
        this.Num = num;
        this.Other = other;
    }
}
