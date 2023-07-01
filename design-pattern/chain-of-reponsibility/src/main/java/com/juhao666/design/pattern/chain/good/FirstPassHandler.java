package com.juhao666.design.pattern.chain.good;

public class FirstPassHandler  extends AbstractHandler{

    private int play(){
        return 80;
    }

    @Override
    public int handler(){
        System.out.println("The 1st-->FirstPassHandler");
        int score = play();
        if(score >= 80){
            //分数>=80 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}