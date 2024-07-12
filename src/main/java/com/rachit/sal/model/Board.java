package com.rachit.sal.model;

import java.util.List;
import java.util.Random;

public class Board {
    private List<Player> playerList;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;
    String winner;

    public Board(List<Snake> snakeList, List<Ladder> ladderList, List<Player> playerList) {
        this.playerList = playerList;
        this.snakeList = snakeList;
        this.ladderList = ladderList;
    }

    public void start(){
        Random rand = new Random();
        while(winner == null){
            for (Player player : playerList) {
                int dice = rand.nextInt(6) + 1;
                int lastPosition = player.getPosition();
                int newPosition = player.getPosition()+dice;
                int flag = 0;
                for(Ladder ladder : ladderList){
                    if(newPosition == ladder.getStart()){
                        player.setPosition(ladder.getEnd());
                        flag = 1;
                        break;
                    }
                }

                if(flag == 1){
                    continue;
                }

                for(Snake snake : snakeList){
                    if(newPosition == snake.getHead()){
                        player.setPosition(snake.getTail());
                        flag = 1;
                        break;
                    }
                }

                if(flag == 1){
                    continue;
                }

                if(newPosition<=100)
                    player.setPosition(newPosition);

                System.out.println(player.getName() + " rolled a "+newPosition + " and moved from "+ lastPosition + " to " + player.getPosition());
                if(player.getPosition()==100){
                    winner = player.getName();
                    break;
                }
            }
        }
    }

    public String getWinner() {
        return winner;
    }
}
