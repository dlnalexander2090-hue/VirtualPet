
import java.util.Random;
import java.util.Scanner;

public class VirtualPet {

    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int energia = random.nextInt(21) + 40;
        int higiene = random.nextInt(21) + 40;
        int peso = random.nextInt(21) + 40;
        int animo = random.nextInt(21) + 40;

        System.out.println("Bienvenido a Virtual Pet");

        System.out.print("¿Quieres un perro o un gato? ");
        String tipo = teclado.nextLine().toLowerCase();
        while (!tipo.equals("perro") && !tipo.equals("gato")) {
            System.out.print("Tienes que escribir perro o gato: ");
            tipo = teclado.nextLine().toLowerCase();
        }

        System.out.print("¿Cómo se llama tu mascota? ");
        String nombre = teclado.nextLine();

        boolean viva = true;
        int opcion = -1;

        while (viva && opcion != 0) {

            System.out.println();
            System.out.println("--- " + nombre + " (" + tipo + ") ---");
            System.out.println("Energía: " + energia + " | Higiene: " + higiene
                    + " | Peso: " + peso + " | Ánimo: " + animo);
            System.out.println("1. Dormir");
            System.out.println("2. Jugar");
            System.out.println("3. Comer");
            System.out.println("4. Bañar");
            System.out.println("5. Atacar");
            System.out.println("6. Bailar");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            while (!teclado.hasNextInt()) {
                System.out.print("Tienes que escribir un número: ");
                teclado.next();
            }
            opcion = teclado.nextInt();

            if (opcion == 1) {
                if (tipo.equals("perro")) {
                    energia = energia + 25;
                } else {
                    energia = energia + 20;
                }
                animo = animo + 10;
                System.out.println(nombre + " ha dormido.");

            } else if (opcion == 2) {
                  energia = energia - 20;
                animo = animo + 20;
                System.out.println(nombre + " ha jugado.");

            } else if (opcion == 3) {
                energia = energia + 10;
                higiene = higiene - 15;
                peso = peso + 10;
                 System.out.println(nombre + " ha comido.");

            } else if (opcion == 4) {
                if (tipo.equals("perro")) {
                    energia = energia - 10;
                    higiene = higiene + 25;
                    animo = animo - 15;
                } else {
                    energia = energia - 5;
                    higiene = higiene + 25;
                    animo = animo + 5;
                }
                 System.out.println(nombre + " se ha bañado.");

            } else if (opcion == 5) {
                System.out.print("¿Cuántas veces quieres atacar? ");
                int veces = 0;

                while (veces <= 0) {
                    while (!teclado.hasNextInt()) {
                        System.out.print("Tienes que escribir un número: ");
                        teclado.next();
                    }
                    veces = teclado.nextInt();
                    if (veces <= 0) {
                        System.out.print("Tiene que ser un número mayor que 0: ");
                    }
                }

                int i = 1;
                while (i <= veces && viva) {
                    energia = energia - 3;
                    higiene = higiene - 3;
                    animo = animo - 3;
                    System.out.println("Ataque " + i);

                    if (energia <= 0 || higiene <= 0 || animo <= 0) {
                        viva = false;
                    }
                       i++;
                }

            } else if (opcion == 6) {
                // Llamo al metodo bailar y me quedo con la energia que devuelve
                energia = bailar(nombre, energia);

            } else if (opcion == 0) {
                System.out.println("Has salido del juego. ¡Hasta pronto!");

            } else {

                System.out.println("Opción no válida.");
            }

            if (energia <= 0 || energia > 100
                    || higiene <= 0 || higiene > 100
                    || peso <= 0 || peso > 100
                    || animo <= 0 || animo > 100) {
                viva = false;
            }
        }

        if (!viva) {
            System.out.println();
            System.out.println("Energía: " + energia + " | Higiene: " + higiene +
                    " | Peso: " + peso + " | Ánimo: " + animo);
            System.out.println(nombre + " ha muerto. Fin del juego.");
        }

            teclado.close();
    }

    // Metodo nuevo de la practica de Git: la mascota baila y gasta energia.
    // Es static porque en mi programa todo esta en el main con variables locales,
    // por eso recibe el nombre y la energia y devuelve la energia nueva.
    public static int bailar(String nombre, int energia) {
        System.out.println(nombre + " está bailando un mambo!");
        return energia - 10;
    }
}
