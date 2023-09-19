package com.methaporce.vista;

import com.methaporce.modelo.GestorPelicula;
import com.methaporce.modelo.Pelicula;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPelicula gestor = new GestorPelicula();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar película");
            System.out.println("2. Eliminar película");
            System.out.println("3. Marcar película como disponible");
            System.out.println("4. Mostrar películas no disponibles");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el ID de la película:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese el nombre de la película:");
                    String nombre = scanner.nextLine();
                    System.out.println("¿La película está disponible? (true/false):");
                    boolean disponible = scanner.nextBoolean();

                    Pelicula pelicula = new Pelicula(id, nombre, disponible);
                    gestor.agregarPelicula(pelicula);
                    System.out.println("Película agregada con éxito.");
                    break;
                case 2:
                    System.out.println("Ingrese el ID de la película a eliminar:");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarPelicula(idEliminar);
                    System.out.println("Película eliminada con éxito.");
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la película a marcar como disponible:");
                    int idDisponible = scanner.nextInt();
                    gestor.marcarPeliculaComoDisponible(idDisponible);
                    System.out.println("Película marcada como disponible con éxito.");
                    break;
                case 4:
                    System.out.println("Películas no disponibles:");
                    for (Pelicula peliculaNoDisponible : gestor.obtenerPeliculasNoDisponibles()) {
                        System.out.println(peliculaNoDisponible.getNombre());
                    }
                    break;

                case 5:
                    System.out.println("¡Adiós!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
