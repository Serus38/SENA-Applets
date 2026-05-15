package Applets3.PruebaLaptop;

public class Laptop {

    private String marca;
    private String modelo;
    private int memoria;
    private double precio;

    // Variable estática
    private static int cuenta = 0;

    public Laptop() {
        this.marca = "Genérica";
        this.modelo = "Básico";
        this.memoria = 0;
        this.precio = 0.0;
        cuenta++; // Incrementa la cuenta
    }


    public Laptop(String marca, String modelo, int memoria, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.precio = precio;
        cuenta++;
    }

    // Sobrecarga del constructor (precio como int)
    public Laptop(String marca, String modelo, int memoria, int precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.precio = (double) precio;
        cuenta++;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getMemoria() {
        return memoria;
    }

    public double getPrecio() {
        return precio;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Sobrecarga de modificadores
    // Memoria: acepta int y double
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = (int) memoria;
    }

    // Precio: acepta double y int
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPrecio(int precio) {
        this.precio = (double) precio;
    }

    // Método estático que regresa int
    public static int getCuenta() {
        return cuenta;
    }

    // Sobrecarga del método estático para que regrese double
    public static double getCuenta(boolean comoDouble) {
        return (double) cuenta;
    }
}
