package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zakhar on 02.03.2017.
 */
public class Arena{
    private ArrayList<Fighter> fighters = new ArrayList<>();
    private int currentFighter;
    private int sleepTime;

    public Arena(int sleepTime){
        this.sleepTime = sleepTime;
    }

    public void setFighters(Fighter ... fighters){
        for (int i = 0; i < fighters.length; i++){
            this.fighters.add(fighters[i]);
        }
        Random random = new Random();
        currentFighter = random.nextInt(this.fighters.size());
    }

    public synchronized Fighter startFight() throws InterruptedException {
        System.out.println("***START***");
        DrawFighters.startBoxing();
        Thread.sleep(sleepTime);
        int lastFighter;
        boolean resultOfKicking;
        while (fighters.size() > 1){
            currentFighter = currentFighter >= fighters.size() ? 0 : currentFighter;
            int kick = fighters.get(currentFighter).kick();
            lastFighter = currentFighter++;
            currentFighter = currentFighter >= fighters.size() ? 0 : currentFighter;
            resultOfKicking = fighters.get(currentFighter).reactionOnKick(kick);
            DrawFighters.slideBorder();
            if (lastFighter % 2 == 0){
                System.out.println(fighters.get(currentFighter).getName() + " | " + fighters.get(lastFighter).getName());
                if (resultOfKicking){
                    DrawFighters.rKicksL();
                } else {
                    DrawFighters.lBlockedR();
                }
                System.out.println(fighters.get(currentFighter).getHp() + " | " + fighters.get(lastFighter).getHp());
            } else {
                System.out.println(fighters.get(lastFighter).getName() + " | " + fighters.get(currentFighter).getName());
                if (resultOfKicking){
                    DrawFighters.lKicksR();
                } else {
                    DrawFighters.rBlockedL();
                }
                System.out.println(fighters.get(lastFighter).getHp() + " | " + fighters.get(currentFighter).getHp());
            }
            if (!fighters.get(currentFighter).isAlive()){
                Thread.sleep(sleepTime);
                fighters.remove(currentFighter);
                if (currentFighter % 2 == 0){
                    DrawFighters.lWinn();
                } else {
                    DrawFighters.rWin();
                }
            }
            Thread.sleep(sleepTime);
        }
        return fighters.get(0);
    }
}
