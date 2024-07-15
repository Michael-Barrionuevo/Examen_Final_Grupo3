package uce.edu.ec.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uce.edu.ec.Container.Controller;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "ec.edu.uce.Proyecto_Final")
@EnableJpaRepositories(basePackages = "ec.edu.uce.Proyecto_Final.repository")
@EntityScan(basePackages = "ec.edu.uce.Proyecto_Final.model")
public class ProyectoFinalApplication implements CommandLineRunner {

    @Autowired
    private static Controller controller;

    public static void main(String[] args) {
        SpringApplication.run(ProyectoFinalApplication.class, args);
		/*java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});*/
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Leer Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Crear Administrador");
            System.out.println("6. Leer Administrador");
            System.out.println("8. Eliminar Administrador");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    controller.crearCliente(scanner);
                    break;
                case 2:
                    controller.leerCliente(scanner);
                    break;
                case 3:
                    controller.eliminarCliente(scanner);
                    break;
                case 5:
                    controller.crearAdministrador(scanner);
                    break;
                case 6:
                    controller.leerAdministrador(scanner);
                    break;
                case 8:
                    controller.eliminarAdministrador(scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
        scanner.close();
    }

}

