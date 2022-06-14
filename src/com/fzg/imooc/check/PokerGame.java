package com.fzg.imooc.check;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 扑克游戏
 * 1. 创建扑克牌；
 * 2. 洗牌
 * 3. 创建玩家
 * 4. 发牌
 */
public class PokerGame {
    final int players = 4;
    String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] type = {"红桃","黑桃","草花","方块"};
    String[] other = {"大王 ","小王 "};

    public List<Card> pokerList;
    List<People> peopleList = new ArrayList<>();
    //1. 创建扑克牌
    public void createCard(){
        System.out.println("---------------下面开始创建扑克牌---------------");
        pokerList = new ArrayList<>();
        for (int i = 0; i < type.length; i++) {
            for (int j = 0; j < num.length; j++) {
                Card cardNew = new Card(type[i], num[j], "" );
                pokerList.add(cardNew);
            }
        }
        for (int i = 0; i < other.length; i++) {
            pokerList.add(new Card("","",other[i]));
        }
        System.out.println("---------------创建扑克牌完成-------------------");
        printPoker(13);
    }

    /**
     * 2. 洗牌
     */
    public void upsetPoker(){
        System.out.println("------------------下面开始洗牌-------------------");
        Collections.shuffle(pokerList);
        System.out.println("------------------洗牌结束----------------------");
        printPoker(4);
    }

    /**
     * 打印扑克牌
     * @param row 每行打印数量
     */
    public void printPoker(int row){
        int cycle = 0;
        for (Card card : pokerList) {
            if (cycle < row){
                System.out.print(card.getType()+card.getNum()+card.getOther());
                System.out.print("\t");
                cycle++;
            }else{
                System.out.print("\n");
                System.out.print(card.getType()+card.getNum()+card.getOther());
                System.out.print("\t");
                cycle = 1;
            }
        }
        System.out.println("\n");
    }

    /**
     * 3. 创建玩家
     */
    public void createPeople(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < players; i++) {
            System.out.println("请输入玩家姓名");
            People people = new People(i+"", scanner.next());
            peopleList.add(people);
        }
        for (People p:peopleList) {
            System.out.println("欢迎第"+p.getId()+"位玩家"+p.getName()+"进入游戏！");
        }
        scanner.close();
    }

    //打印手牌
    private void printPeopleCards(List<Card> cards) {
        for (Card card:cards) {
            System.out.print(card.getType()+card.getNum()+card.getOther());
            System.out.print("\t");
        }
    }

    //4. 发牌
    public void playCard(){
        System.out.println("------------------开始发牌----------------------");
        int totalNum = 0;
        int cardNum = 0;
        while(totalNum < pokerList.size()){
            for (int i = 0; i < players && totalNum < pokerList.size(); i++) {
                peopleList.get(i).cards.add(cardNum,pokerList.get(totalNum));
                totalNum++;
            }
            cardNum++;
        }
        System.out.println("------------------发牌结束----------------------");
        for (People p : peopleList) {
            System.out.println("ID为"+p.getId() + "的玩家" + p.getName() + "的手牌为：");
            printPeopleCards(p.cards);
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        PokerGame pg = new PokerGame();
        pg.createCard();
        pg.upsetPoker();
        pg.createPeople();
        pg.playCard();
    }
}
