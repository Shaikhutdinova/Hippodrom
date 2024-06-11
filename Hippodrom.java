package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Stiv", 3, 0));
        horses.add(new Horse("Belka", 3, 0));
        horses.add(new Horse("Silver", 3, 0));
        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        horses.forEach(x -> x.move());
    }

    public void print() {
        horses.forEach(x -> x.print());
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int index = 0;
        for (int i = 1; i < horses.size(); i++) {
            if(horses.get(i).getDistance() > horses.get(index).getDistance()){
                index = i;
            }
        }

        return horses.get(index);
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
