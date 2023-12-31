package com.juhao666.design.pattern.chain.good;

public class SecondPassHandler extends AbstractHandler{

    private int play(){
        return 90;
    }

    public int handler(){
        System.out.println("The 2nd-->SecondPassHandler");

        int score = play();
        if(score >= 90){
            //分数>=90 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}