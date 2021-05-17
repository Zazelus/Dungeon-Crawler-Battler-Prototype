package com.javaCrawl.player;

public class Player {

    private String name;

    private int health;
    private int damage;

    private boolean dead = false;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Player(boolean dead) {
        this.dead = dead;
    }

    public Player(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(int damageAmount, int myHealth) {
        if (damageAmount >= this.health || myHealth <= 0) {
            System.out.println(this.name + " is dead!");
            this.dead = true;
        } else {
            this.health -= damageAmount;

            System.out.println("The remaining life of " + this.name + " is: " + this.health);
            System.out.println("Your remaining HP: "+ myHealth);
        }
    }

}
