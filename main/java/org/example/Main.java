package org.example;
import org.example.presentacion.CursoUI;
import org.example.presentacion.EstudianteUI;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner sc= new Scanner(System.in);
        int opcion;

        do{
            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion=sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ha elegido Gestionar Estudiante.");
                    EstudianteUI.mostrarMenu(sc);
                    break;
                case 2:
                    System.out.println("Ha elegido Gestionar Curso.");

                    break;
                case 0:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        }while(opcion!=0);
        sc.close();
    }
}
