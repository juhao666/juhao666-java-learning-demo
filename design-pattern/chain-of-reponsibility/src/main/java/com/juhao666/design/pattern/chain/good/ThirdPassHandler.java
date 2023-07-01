package com.juhao666.design.pattern.chain.good;

public class ThirdPassHandler extends AbstractHandler{

    private int play(){
        return 95;
    }

    public int handler(){
        System.out.println("The 3rd-->ThirdPassHandler-->last one");
        int score = play();
        if(score >= 95){
            //分数>=95 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}

