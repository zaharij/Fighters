package com.company;

import java.util.Random;

/**
 * Created by Zakhar on 01.03.2017.
 */
public class Fighter {
    private final static int MAX_PERCENT = 100;
    private final static int INTUITION_KOEF = 2;
    private final static int MIN_DAMAGE = 1;
    private String name;
    private int damage;
    private int agility;
    private int intuition;
    private int hp;
    private boolean isAlive;

    public Fighter(String name, int demage, int agility, int intuition, int hp) {
        this.name = name;
        this.damage = demage;
        this.agility = agility;
        this.intuition = intuition;
        this.hp = hp;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntuition() {
        return intuition;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * returns damage when the fighter kicks
     * @return
     */
    public int kick(){
        if (!isAlive){
            return 0;
        }
        Random random = new Random();
        int currentDamage = random.nextInt(this.damage - MIN_DAMAGE + 1) + MIN_DAMAGE;
        boolean intuition = random.nextInt(MAX_PERCENT + 1) + 1 <= this.intuition ? true : false;
        return intuition ? currentDamage * INTUITION_KOEF : currentDamage;
    }

    /**
     * describes the reaction on kick
     * @param damage
     */
    public boolean reactionOnKick(int damage){
        if (!isAlive){
            return true;
        }
        Random random = new Random();
        boolean isAvoided = random.nextInt(MAX_PERCENT + 1) + 1 <= this.agility ? true : false;
        if (!isAvoided){
            this.hp -= damage;
            if (this.hp <= 0){
                this.isAlive = false;
                this.hp = 0;
            }
            return true;
        }
        return false;
    }
}
