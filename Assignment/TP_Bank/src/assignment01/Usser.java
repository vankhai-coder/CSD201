/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment01;

/**
 *
 * @author FPTSHOP
 */
public class Usser {
    private String name ; 
    private String accNumber ; 
    private double balance ; 

    public Usser(String name, String accNumber, double balance) {
        this.name = name;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    
    
}
