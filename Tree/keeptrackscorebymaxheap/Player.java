/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keeptrackscorebymaxheap;

/**
 *
 * @author FPTSHOP
 */
public class Player {
    private String name ; 
    private int score ; 

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", score=" + score + '}';
    }
    
    
}
