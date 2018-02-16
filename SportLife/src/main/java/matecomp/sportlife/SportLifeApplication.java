package matecomp.sportlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import matecomp.sportlife.controllersteam.EquipoController;

@SpringBootApplication
@ComponentScan(basePackageClasses = EquipoController.class)
public class SportLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportLifeApplication.class, args);
	}
}
