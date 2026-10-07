package coe318.lab4;

/**
 *
 * @author Kevin L
 */
public class Account {
    private String name;
    private double balance;
    private int number;
    
    public Account(String name, int number, double initialBalance) {
        this.name = name;
        this.number = number;
        balance = initialBalance;
        
    }
    
    public String getName() {
        return name;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public int getNumber() {
        return number;
    }
    
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount < 0 || balance < amount) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }
    
    @Override
    public String toString() {//DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " +
        String.format("$%.2f", getBalance()) + ")";
     
    }
    
    
    /*public static void main(String[] ,args) {
        System.out.println(this.getName(),this.getBalance(),this.getNumber());
    }*/
    
}
