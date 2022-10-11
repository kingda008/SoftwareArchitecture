package com.baoge.designpattern.xingweixing.p07_beiwanglu;

public class Client {
    public static void main(String[] args) {
        //构建游戏对象
        CallOfDuty game = new CallOfDuty();
        //打游戏
        game.play();

        Caretaker caretaker = new Caretaker();
        //存档
        caretaker.archive(game.createMemoto());
        //退出游戏
        game.quit();
        //恢复游戏
        CallOfDuty newGame = new CallOfDuty();
        newGame.restore(caretaker.getMemoto());
    }
}
