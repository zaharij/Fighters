package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<Fighter> fighters = fighterGenerator(100);
        Arena arena = new Arena(3000);
        int i = 0;
        while (fighters.size() > 1){
            if (i >= fighters.size() - 1){
                i = 0;
            }
            arena.setFighters(fighters.remove(i), fighters.remove(i));
            Fighter fighter = arena.startFight();
            fighters.addLast(fighter);
            i++;
        }

        System.out.println(fighters.get(0).getName() + " is the winner!!!");
        System.out.println("damage = " + fighters.get(0).getDamage());
        System.out.println("agility = " + fighters.get(0).getAgility());
        System.out.println("intuition = " + fighters.get(0).getIntuition());
    }

    private static LinkedList<Fighter> fighterGenerator(int fightersNumber){
        LinkedList<Fighter> fighters = new LinkedList<>();
        Random random = new Random();
        int hp = 100;
        int minNumber = 1;
        int maxNumber = 50;
        int maxCurrentRandomNumber;
        int[] skills = new int[3];
        for (int i = 0; i < fightersNumber; i++){
            int skillsSum = skills.length * minNumber;
            for (int j = 0; j < skills.length - 1; j++) {
                maxCurrentRandomNumber = maxNumber - skillsSum;
                int currentRandom = random.nextInt(maxCurrentRandomNumber + 1);
                skills[j] = minNumber + currentRandom;
                skillsSum += currentRandom;
            }
            skills[skills.length - 1] = maxNumber - skillsSum + minNumber;
            fighters.add(new Fighter("Fighter_" + i, skills[0], skills[1], skills[2], hp));
        }
        return fighters;
    }
}
