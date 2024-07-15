package uce.edu.ec.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uce.edu.ec.impl.AdministratorImpl;
import uce.edu.ec.impl.CustomerImpl;
import uce.edu.ec.model.Administrator;
import uce.edu.ec.model.Customer;

import java.util.Scanner;

@Component
public class Controller {

    @Autowired
    private CustomerImpl customerImpl;

    @Autowired
    private AdministratorImpl AdministratorImpl;

    public Controller(CustomerImpl customerImpl, uce.edu.ec.impl.AdministratorImpl administratorImpl) {
        this.customerImpl = customerImpl;
        AdministratorImpl = administratorImpl;
    }

    public void crearCliente(Scanner scanner) {
        System.out.println("Nombre del Cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Contrasenia del Cliente:");
        String contraseniaCliente = scanner.nextLine();
        System.out.println("Email del Cliente:");
        String emailCliente = scanner.nextLine();

        Customer cliente = new Customer(nombreCliente, contraseniaCliente, emailCliente);

        customerImpl.saveCustomer(cliente);
        System.out.println("Cliente creado con éxito!");
    }

    public void leerCliente(Scanner scanner) {
        System.out.println("ID del Cliente:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Customer cliente = customerImpl.getCustomerById(id);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarCliente(Scanner scanner) {
        System.out.println("ID del Cliente:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        customerImpl.deleteCustomer(id);
        System.out.println("Cliente eliminado con éxito!");
    }

    public void crearAdministrador(Scanner scanner) {
        System.out.println("Nombre del Administrador:");
        String nombreAdministrador = scanner.nextLine();
        System.out.println("Contrasenia del Administrador:");
        String contraseniaAdministrador = scanner.nextLine();
        Administrator administrator = new Administrator(nombreAdministrador, contraseniaAdministrador);
        AdministratorImpl.saveAdministrator(administrator);
        System.out.println("Vendedor creado con éxito!");
    }

    public void leerAdministrador(Scanner scanner) {
        System.out.println("ID del Vendedor:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Administrator administrator = AdministratorImpl.getAdministratorById(id);
        if (administrator != null) {
            System.out.println(administrator);
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }

    public void eliminarAdministrador(Scanner scanner) {
        System.out.println("ID del Vendedor:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        AdministratorImpl.deleteAdministrator(id);
        System.out.println("Vendedor eliminado con éxito!");
    }
}

