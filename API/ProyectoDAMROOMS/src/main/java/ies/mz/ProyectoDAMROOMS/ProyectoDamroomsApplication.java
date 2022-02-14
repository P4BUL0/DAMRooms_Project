package ies.mz.ProyectoDAMROOMS;

import ies.mz.ProyectoDAMROOMS.microservicios.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoDamroomsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProyectoDamroomsApplication.class, args);

		RestClient restClient = new RestClient();
		restClient.verHabitacion(1);
	}



}
