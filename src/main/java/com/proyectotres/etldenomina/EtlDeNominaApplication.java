package com.proyectotres.etldenomina;

import com.proyectotres.etldenomina.model.Empleado;
import com.proyectotres.etldenomina.services.ProcesadorArchivos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class EtlDeNominaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EtlDeNominaApplication.class, args);

        Path rutaEntrada = Path.of("src/nomina.txt");

        ProcesadorArchivos pr = new ProcesadorArchivos();

        List<Empleado> doc = pr.leerEmpleados(rutaEntrada);

        List<String> repo = doc.stream()
                .map(Empleado::reporte)
                .collect(Collectors.toList());

        pr.generarReporte(repo);
    }

}
