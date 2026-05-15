package Applets3.AppletsMetodos;

public class Account {
    private String number;
    private String name;
    private double balance;

    public Account(String number, String name, double balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String showAccountInfo() {
        return "Datos de la cuenta:\n" +
                "Numero: " + number + "\n" +
                "Nombre: " + name + "\n" +
                "Saldo: " + balance;
    }
    
}
