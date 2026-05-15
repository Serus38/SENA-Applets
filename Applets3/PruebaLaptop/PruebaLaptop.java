package Applets3.PruebaLaptop;

public class PruebaLaptop {
    public static void main(String[] args) {

        // Objeto 1: Constructor vacío
        Laptop lap1 = new Laptop();

        // Objeto 2: Constructor con 4 parámetros (precio double)
        Laptop lap2 = new Laptop("Dell", "XPS 13", 16, 1200.50);

        // Objeto 3: Constructor sobrecargado (precio int)
        Laptop lap3 = new Laptop("Apple", "MacBook Pro", 8, 2000);

        // Uso de métodos modificadores sobrecargados en lap1
        lap1.setMarca("HP");
        lap1.setModelo("Pavilion");
        lap1.setMemoria(12.5); // Sobrecarga: acepta double, convierte a int
        lap1.setPrecio(850); // Sobrecarga: acepta int, convierte a double

        // Despliegue de información
        System.out.println("--- LAPTOPS ---");
        imprimirDatos(lap1);
        imprimirDatos(lap2);
        imprimirDatos(lap3);

        // Demostración de métodos estáticos y su sobrecarga
        System.out.println("--------------------------------");
        System.out.println("Total de laptops creadas (int): " + Laptop.getCuenta());
        System.out.println("Total de laptops creadas (double): " + Laptop.getCuenta(true));
    }

    // Método auxiliar para mostrar los datos
    public static void imprimirDatos(Laptop l) {
        System.out.println("Marca: " + l.getMarca() +
                " | Modelo: " + l.getModelo() +
                " | Memoria: " + l.getMemoria() + "GB" +
                " | Precio: $" + l.getPrecio());
    }
}