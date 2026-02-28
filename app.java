package com.estudiantes.test;
import java.util.Scanner; // ERROR: IMPORT INNECESARIO (Scanner no se usa en el código), genera warning de código muerto/uso de imports.

// Clase App para demostración de métricas de calidad.
// (Nota: Faltan comentarios en los métodos internos para bajar la cobertura)
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.procesarOperacionCompleja(10, 5, "SUMA");
        app.metodoDuplicadoUno();
        // ERROR: metodoDuplicadoDos() no es invocado (código muerto / duplicación no usada).
    }
   
    public void procesarOperacionCompleja(int a, int b, String op) {
        if (op != null) {
            if (op.equals("SUMA")) {
                System.out.println(a + b);
            } else if (op.equals("RESTA")) {
                if (a > b) {
                    System.out.println(a - b);
                } else {
                    System.out.println(b - a);
                }
            } else if (op.equals("MULT")) {
                for (int i = 0; i < a; i++) { // ERROR: Bucle innecesario si solo se quiere mostrar "Iniciando..." una vez; lógica confusa que aumenta complejidad.
                    if (i == 0) System.out.println("Iniciando...");
                }
                System.out.println(a * b);
            } else if (op.equals("DIV")) {
                if (b != 0) System.out.println(a / b);
                // ERROR: En caso b==0 no se informa al usuario ni se lanza excepción; comportamiento silencioso (potencial bug).
            } else {
                System.out.println("Operación desconocida");
            }
        } else {
            // ERROR: op puede ser null; aunque se evita NPE con el if, no se informa ni se trata el caso (silencio funcional).
        }
    }

    
    public void metodoDuplicadoUno() {
        System.out.println("Iniciando proceso de log...");
        int x = 10;
        int y = 20;
        int z = x + y;
        System.out.println("El valor calculado es: " + z);
        System.out.println("Finalizando proceso de log...");
    }

    public void metodoDuplicadoDos() {
        // ERROR: Método idéntico a metodoDuplicadoUno (duplicación de código). Debe extraerse a un método reutilizable.
        System.out.println("Iniciando proceso de log...");
        int x = 10;
        int y = 20;
        int z = x + y;
        System.out.println("El valor calculado es: " + z);
        System.out.println("Finalizando proceso de log...");
    }

    public void metodoMuyLargo() {
        // ERROR: Método muy largo (muchas líneas). Aumenta LOC y reduce legibilidad; difícil de mantener y de cubrir con tests.
        System.out.println("Línea 1");
        System.out.println("Línea 2");
        // ...
        System.out.println("Línea 50");
    }

    public void calcularImpuestoSilencioso(double monto) {
        double i = monto * 0.15;
        System.out.println(i);
        // ERROR: Método "silencioso": imprime el impuesto pero no retorna valor ni registra; difícil de reutilizar o testear.
    }
}