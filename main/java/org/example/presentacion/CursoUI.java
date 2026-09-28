package org.example.presentacion;

import org.example.business.Curso;
import org.example.business.CursoService;
import java.util.Scanner;

public class CursoUI {
    private static final CursoService service =new CursoService();

    public static void mostrarMenu(Scanner sc){
        int opcion;
        do{
            System.out.println("\n=== GESTION CURSO ===");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Regresar");
            System.out.println("Seleccione una opción: ");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: {
                    System.out.print("Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Creditos: ");
                    int creditos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Docente: ");
                    String docente = sc.nextLine();
                    service.registrar(new Curso(id, nombre, creditos, docente));
                    System.out.print("Curso registrado");
                    break;
                }
                case 2:
                    service.listar().forEach(c->
                            System.out.println(c.getId()+" | "+ c.getNombre()+" | "+c.getCreditos()+ "creditos | "+ c.getDocente()));
                    break;

                case 3: {
                    System.out.print("Id a actualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nuevos creditos: ");
                    int creditos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo docente: ");
                    String docente = sc.nextLine();
                    boolean ok =service.actualizar(new Curso(id, nombre, creditos, docente));
                    System.out.println(ok?"Curso actualizado" : "No se encontró el id");
                    break;

                }
                case 4: {
                    System.out.print("Id a eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    boolean ok = service.eliminar(id);
                    System.out.println(ok? "Curso eliminado" : "No se encontró el id");
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida");

            }
        } while (opcion !=0);
    }
}
