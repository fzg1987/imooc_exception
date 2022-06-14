package com.fzg.imooc.check;

import java.util.ArrayList;
import java.util.List;

public class People {
    private String id;
    private String name;
    public List<Card> cards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public People(String id, String name){
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
    }
}
