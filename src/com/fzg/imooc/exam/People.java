package com.fzg.imooc.exam;

/*
 * People类用来封装人员id、name、手牌
 */
import java.util.ArrayList;
import java.util.List;
public class People {
    private Integer id;
    private String name;
    public List<Card> cards;
    public People (Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<Card>();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
