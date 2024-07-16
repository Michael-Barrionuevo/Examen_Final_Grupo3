package uce.edu.ec.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uce.edu.ec.container.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "uce.edu.ec")
@EnableJpaRepositories(basePackages = "uce.edu.ec.repository")
@EntityScan(basePackages = "uce.edu.ec.model")

public class ProyectoFinalApplication implements CommandLineRunner {

    private final Controller controller;

    @Autowired
    public ProyectoFinalApplication(Controller controller) {
        this.controller = controller;
    }

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
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Crear Administrador");
            System.out.println("5. Leer Administrador");
            System.out.println("6. Eliminar Administrador");
            System.out.println("0. Salir");

            try {
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
                    case 4:
                        controller.crearAdministrador(scanner);
                        break;
                    case 5:
                        controller.leerAdministrador(scanner);
                        break;
                    case 6:
                        controller.eliminarAdministrador(scanner);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Consume la entrada inválida
                option = -1; // Reinicia la opción para continuar en el bucle
            }
        } while (option != 0);
        scanner.close();
    }

}

