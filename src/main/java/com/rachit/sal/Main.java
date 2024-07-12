package com.rachit.sal;

import com.rachit.sal.model.Board;
import com.rachit.sal.model.Ladder;
import com.rachit.sal.model.Player;
import com.rachit.sal.model.Snake;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        int sn = sc.nextInt();
        ArrayList<Snake> snakes = new ArrayList<>();
        for(int i = 0; i < sn; i++) {
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snakes.add(new Snake(head, tail));
        }

        int ln = sc.nextInt();
        ArrayList<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i < ln; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladders.add(new Ladder(start, end));
        }
        ArrayList<Player> players = new ArrayList<>();
        int pn = sc.nextInt();

        for(int i=0; i<pn; i++){
            players.add(new Player(sc.next()));
        }

        Board board = new Board(snakes, ladders, players);
        board.start();
        System.out.println(board.getWinner() + " wins the game");
    }
}