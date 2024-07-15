package uce.edu.ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uce.edu.ec.View.Principal;

@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(ProyectoFinalApplication.class, args);
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}

}
