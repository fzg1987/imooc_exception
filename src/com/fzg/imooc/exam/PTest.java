package com.fzg.imooc.exam;

import java.util.*;

/* * 1、扑克牌创建
 * 2、进行洗牌
 * 3、玩家创建
 * 4、进行发牌
 */
public class PTest {
    private List<Card> pokerList = new ArrayList<>();//创建扑克List
    private List<People> peopleList = new ArrayList<>();//创建玩家List
    /*
     *1、 扑克牌创建
     */
    public  void createCard(){
        String[] num={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] type={"红桃","方块","梅花","黑桃"};
        String[] other={"大王","小王"};
        int sum=0;//统计总牌数量
        int sum1=0;//每四个换一行数量
        System.out.println("----创建扑克牌----");
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < type.length; j++){
                pokerList.add(new Card(num[i],type[j],""));
            }
        }
        for (int d=0;d<other.length;d++){
            pokerList.add(new Card("","",other[d]));
        }
        for (Card poker : pokerList) {
            System.out.print(poker.getNum() +  poker.getType()+"  "+ poker.getOther());
            sum++;
            sum1++;
            if(sum1%10==0){
                System.out.println("\r\n");
            }
        }
        System.out.println("\r\n");
        System.out.println("扑克牌总数：  "+  sum);
        System.out.println("----扑克牌已经创建成功----");
    }
    /*
     * 2、洗牌
     */
    public void upsetPoker() {
        int sum1=0;//每四个换一行数量
        System.out.println("------下面开始洗牌...-------");
        Collections.shuffle(pokerList);
        System.out.println("------洗牌结束！洗牌后是------");
        //验证
        //System.out.println("洗牌后为："+pokerList.toString());
        for (Card poker : pokerList) {
            System.out.print(poker.getNum() +  poker.getType()+"  "+ poker.getOther()+"  ");
            sum1++;
            if(sum1%10==0){
                System.out.println("\r\n");
            }
        }
    }
    /*
     * 3、提示创建玩家
     */
    public void createPeople() {
        System.out.println("\r\n"+"------创建4个玩家------");
        int peopleNum=4;
        Integer id;
        String name;
        Scanner console = null;
        for (int j = 1; j <= peopleNum; j++) {
            System.out.println("请输入第"+j+"位玩家的ID和姓名：");
            while(true){
                try {
                    System.out.println("输入ID：");
                    console = new Scanner(System.in);
                    id = console.nextInt();
                    if(peopleList.contains(new People(id,null))) {
                        System.out.println("此Id已存在！");
                        continue;
                    }
                    break;
                }catch (InputMismatchException e) {
                    System.out.println("请输入整数类型ID！");
                }
            }
            while(true){
                System.out.println("输入姓名：");
                console = new Scanner(System.in);
                name = console.nextLine();
                if(peopleList.contains(new People(null,name))) {
                    System.out.println("此name已存在！");
                    continue;
                }
                break;
            }
            peopleList.add(new People(id,name));
        }
        console.close();//关闭输入
        //欢迎
        for (People people : peopleList) {
            System.out.println("----欢迎玩家："+people.getName());
        }
    }
    /*
     * 5、提示发牌---发牌---展示--提示发牌结束
     */
    private void issuePoker() {
        System.out.println("------开始发牌...-------");
        int sum=0;
        int i = (54/4)+1;//发牌次数
        int j = 0;//初始牌下标
        while(i>0) {
            for (People people : peopleList) {
                System.out.println("---玩家"+people.getName()+"-拿牌");
                people.cards.add(pokerList.get(j));
                j++;
                sum++;
                if(sum==54){
                    break;
                }
            }
            i--;
        }
        System.out.println("------发牌结束！-------");
        System.out.println("玩家各自的手牌为：");
        for (People people : peopleList) {
            System.out.println(people.getName()+"："+people.cards.toString());
        }}
    public static void main(String[] args) {
        PTest go = new PTest();
        go.createCard();
        go.upsetPoker();
        go.createPeople();
        go.issuePoker();
    }
}
